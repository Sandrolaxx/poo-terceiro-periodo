import dados.ListaDeClientes;
import dados.ListaDeQuartos;
import entidades.Cliente;
import entidades.Quarto;
import entidades.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto");
            System.out.println("3. Listar Quartos");
            System.out.println("4. Reservar Quarto.");
            System.out.println("5. Realizar Check-Out");

            int opcao = lerValorInteiro("Opção");

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarQuarto();
                    break;
                case 3:
                    listarTodosOsQuartos();
                    break;
                case 4:
                    reservarQuarto();
                    break;
                case 5:
                    realizarCheckout();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }


    private static Cliente cadastrarCliente(){
        System.out.println("Digite o nome do cliente: ");
        String nome = lerValorString("Nome do cliente");
        System.out.println("Digite o cpf do cliente: ");
        String cpf = lerValorString("CPF do cliente");
        Cliente cliente =  new Cliente(nome, cpf);
        ListaDeClientes.adicionarCliente(cliente);
        return cliente;
    }

    private static Quarto cadastrarQuarto(){
        System.out.println("Digite a descrição do quarto: ");
        String descricao = lerValorString("Descrição do quarto");
        System.out.println("Digite o número do quarto: ");
        int num = lerValorInteiro("Número do quarto");
        System.out.println("Digite o valor da diária do quarto");
        double valor = lerValorDouble("Valor do quarto");
        Quarto quarto = new Quarto(num, descricao, valor);
        ListaDeQuartos.adicionarQuarto(quarto);
        return quarto;
    }

    private static void reservarQuarto(){
        System.out.println("Digite o número do quarto: ");
        Quarto quarto = selecionarQuarto();
        if(quarto == null){
            System.out.println("Um quarto deve ser selecionado.");
            return;
        }
        Cliente cliente = selecionarClientes();
        if(cliente == null){
            System.out.println("Um cliente deve ser selecionado.");
            return;
        }
        Date inicio = lerValorDate("Data de check-in");
        Date fim = lerValorDate("Data de check-out");
        Reserva reserva = new Reserva(inicio, fim, cliente);

        if(ListaDeQuartos.reservarQuarto(quarto, reserva)){
            System.out.println("Reservado com sucesso.");
        }else{
            System.out.println("Não foi possível reservar. Quarto já está ocupado.");
        }
    }

    private static void realizarCheckout(){
        System.out.println("Digite o número do quarto: ");
        Quarto quarto = selecionarQuarto();
        if(quarto == null){
            System.out.println("Um quarto deve ser selecionado.");
            return;
        }
        int reserva = selecionarReserva(quarto);
        System.out.println("Total de diárias a pagar: R$" + Double.toString(quarto.calcularValorReserva(quarto.encontrarReserva(reserva))));
        quarto.removerReserva(reserva);
        System.out.println("Check-out realizado com sucesso.");
    }

    private static int selecionarReserva(Quarto quarto){
        quarto.listarReservas();
        return lerValorInteiro("Número da reserva");
    }


    private static void listarTodosOsQuartos(){
        ListaDeQuartos.listarQuartos();
    }

    private static void listarTodosOsClientes(){
        ListaDeClientes.listarClientes();
    }

    //Métodos relacionados ao scanner
    private static int lerValorInteiro(String mensagem){
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem + ": ");
                valor = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }

        return valor;
    }

    private static double lerValorDouble(String mensagem){
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem + ": ");
                valor = Double.parseDouble(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }

        return valor;
    }

    private static String lerValorString(String mensagem){
        String input = "";
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem + ": ");
            input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                valido = true;
            } else {
                System.out.println("Entrada inválida. O campo não pode estar vazio.");
            }
        }

        return input;
    }

    private static Date lerValorDate(String mensagem){
        boolean valido = false;
        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        while(!valido) {
            String input = lerValorString(mensagem);
            try {
                data = formato.parse(input);
                valido = true;
            } catch (ParseException e) {
                System.out.println("Entrada inválida. O formato de data é dd/mm/yyyy");
            }
        }
        return data;
    }

    private static Quarto selecionarQuarto(){
        if(!ListaDeQuartos.temQuartos()){
            System.out.println("Não tem quartos");
            return null;
        }

        System.out.println("Selecione o quarto correspondente:");
        listarTodosOsQuartos();
        int numero = lerValorInteiro("Número do quarto");
        Quarto quarto = ListaDeQuartos.encontrarQuartoPorNumero(numero);
        if(quarto == null){
            System.out.println("Quarto inválido");
            return null;
        }
        return quarto;
    }

    private static Cliente selecionarClientes(){
        if(!ListaDeClientes.temClientes()){
            System.out.println("Não tem clientes");
            return null;
        }

        System.out.println("Selecione o cliente correspondente:");
        listarTodosOsClientes();
        int numero = lerValorInteiro("Número do cliente");
        Cliente cliente = ListaDeClientes.encontrarClientePorNumero(numero);
        if(cliente == null){
            System.out.println("Cliente inválido");
            return null;
        }
        return cliente;
    }
}