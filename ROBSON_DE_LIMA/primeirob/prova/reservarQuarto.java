package Arquivos.prova;
import java.util.Scanner;
import java.util.ArrayList;
import ROBSON_DE_LIMA.Arquivos.prova.cadastroClientes;
import ROBSON_DE_LIMA.Arquivos.prova.cadastroQuarto;

public class reservarQuarto {
    private static ArrayList<Quarto> quarto = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
}
public static void main (String [] args){
    Scanner scanner = new Scanner(System.in);
        int opcao;
        do{
            System.out.println ("\n Sistema de Reserva de Quartos HOTEIS LIMA & CIA");
            System.out.println (" 1 - CADSTRO DE CLIENTES");
            System.out.println (" 2 - CADSTRO DE QUARTOS");
            System.out.println (" 3 - LISTAR QUARTOS DISPONIVEIS");
            System.out.println (" 4 - RESERVAR UM QUARTO");
            System.out.println (" 5 Sair");
            System.out.print (" Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastroClientes(scanner);
                    break;
                case 2:
                    cadastroQuarto(scanner);
                    break;
                case 3:
                    listarQuartosDisponiveis();
                    break;
                case 4:
                    reservarQuarto();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
        scanner.close();

    private static void cadastroClientes (Scanner scanner);{
        System.out.print("Digite o Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite um Id para o cliente: ");
        String id = scanner.nextLine();

        Cliente cliente = new cliente(nome, id);
        cliente.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastroQuarto (Scanner scanner);{
        System.out.print("Digite o Numero do Quarto: ");
        String numero = scanner.nextLine();
        System.out.print("Digite o Tipo de quarto: Casal ou Solteiro. ");
        String tipo = scanner.nextLine();

        Quarto quarto = new quarto(numero, tipo);
        quarto.add(quarto);

        System.out.println("Quarto cadastrado com sucesso!");
    }

    private void reservarQuarto (Scanner scanner){
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o Id do cliente: ");
        String id = scanner.nextLine();

        Cliente cliente = new cliente (nome, id);
        cliente.add(cliente);
    
    System.out.print("Digite o Numero do Quarto que irá Reservar");
    String numero = Scanner.nextLine;

    Quarto reservarQuarto = null;
        for (Quarto quarto : quarto) {
            if (quarto.getnumero().equalsIgnoreCase(numero)) {
                reservarQuarto = quarto;
                break;
            }
        }

        if (reservarQuarto != null && !reservarQuarto.isreservado()) {
            reservarQuarto.Reservar();
            System.out.println("Quarto Reservado com Sucesso para " + cliente.getNome() + "!");
        } else if (reservarQuarto != null && reservarQuarto.isreservado()) {
            System.out.println("Quarto ja está Reservado.");
        } else {
            System.out.println("Quarto não encontrado.");
        }
        private static void listarQuartosDisponiveis() {
            System.out.println("\n QUARTOS DISPONÍVEIS PARA RESERVA: ");
            for (Quarto quarto : quarto) {
                if (!quarto.isreservado()) {
                    System.out.println("Numero: " + quarto.getnumero() + " | Tipo: " + quarto.gettipo());

    }

        }


