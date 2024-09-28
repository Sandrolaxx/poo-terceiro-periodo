package TIAGO_SOARES.primeirob.prova;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import TIAGO_SOARES.primeirob.prova.classes.Cliente;
import TIAGO_SOARES.primeirob.prova.classes.Quarto;
import TIAGO_SOARES.primeirob.prova.classes.Reserva;
import TIAGO_SOARES.primeirob.prova.utils.Console;

public class Main {
    private static int escolha;
    static Console console = new Console();
    static Cliente[] clientes = new Cliente[10];
    static Quarto[] quartos = new Quarto[10];
    static Reserva[] reservas = new Reserva[5];

    static SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        do {
            console.clear();
            System.out.println(
                "====== Menu ======\n" +
                "[1] Cadastrar Cliente\n" +
                "[2] Cadastrar Quarto\n" +
                "[3] Listar Quartos\n" +
                "[4] Reservar quartos\n" +
                "[5] Realizar Check-out\n" +
                "[6] Verificar disponibilidade (Quarto)\n" +
                "[7] Verificar Reservas\n" +
                "[8] Sair\n" +
                "====== ==== ======");
            System.out.print("(Usuario): ");
            escolha = leitor.nextInt();

            int escolhaInterna;

            switch (escolha) {
                case 1:
                    cadastrarCliente(leitor);
                    break;
                case 2:
                    cadastrarQuarto(leitor);
                    break;
                case 3:
                    if(verificaQuartosCadastrados()){
                        do {
                            console.clear();
                            leitor.nextLine();
                            System.out.println("(Sistema): Quartos Cadastrados!.\n");

                            exibeQuartosCadastrados();

                            System.out.println("\n(Sistema): Gostaria de exibir os quartos novamente? ");
                            System.out.println("(Sistema): [1] Sim [2] Nao, retornar.");
                            System.out.print("(Usuario): ");

                            escolhaInterna = leitor.nextInt();
                        } while (escolhaInterna != 2);
                    }else{
                        console.clear();
                        System.out.println("(Sistema): Nenhum Quarto cadastrado ainda, por favor realize o cadastro de ao menos um Quarto");
                        System.out.println("\n(Sistema): Retornando ao menu em 3 segundos... ");
            
                        console.sleep(3000);
                    }
                    break;
                case 4:
                    if(verificaQuartosCadastrados() && verificaClienteCadastrados()){
                        realizaReserva(leitor);
                    }        
                    break;
                case 5:
                    if(verifcaReservaCadastrada()){
                        realizaCheckOut(leitor);
                    }else{
                        console.clear();
                        System.out.println("(Sistema): Nenhuma Reserva Cadastrada. Por favor realize pelo menos uma Reserva");
                        System.out.println("\n(Sistema): Retornando ao menu em 3 segundos... ");
            
                        console.sleep(3000);
                    }
                    break;
                case 6:
                    if(verificaQuartosCadastrados()){
                        do{
                            Date dataDisponivel;
                            console.clear();
                            System.out.println("(Sistema): Verificar disponibilidade de Quartos");

                            System.out.println("\n(Sistema): Informe a data que deseja para verificar a disponibilidade de quartos. Formato aceitável (dd/MM/yyyy)");
                            System.out.print("(Usuario): ");
                            String dataString = leitor.nextLine();

                            try {
                                dataDisponivel = formatarData.parse(dataString);
                                if(dataDisponivel != null){
                                    buscaQuartoPorData(dataDisponivel);
                                }
                            } catch (ParseException e) {
                                console.clear();
                                System.out.println("(Sistema): Data invaível. Por favor, tente novamente");
                            }

                            System.out.println("\n(Sistema): Gostaria de realizar outra verificaçao? ");
                            System.out.println("(Sistema): [1] Sim [2] Nao, retornar.");
                            System.out.print("(Usuario): ");
                            escolhaInterna = leitor.nextInt();
                        }while(escolhaInterna != 2);
                    }else{
                        console.clear();
                        System.out.println("(Sistema): Nenhum Quarto cadastrado ainda, por favor realize o cadastro de ao menos um Quarto");
                        System.out.println("\n(Sistema): Retornando ao menu em 3 segundos... ");
            
                        console.sleep(3000);
                    }
                    break;
                case 7:
                    if(verifcaReservaCadastrada()){
                        do{
                            console.clear();
                            System.out.println("(Sistema): Verificar Reservas");
                            exibeReservasCadastradas();

                            System.out.println("\n(Sistema): Gostaria de realizar outra verificação? ");
                            System.out.println("(Sistema): [1] Sim [2] Nao, retornar.");
                            System.out.print("(Usuario): ");
                            escolhaInterna = leitor.nextInt();
                        }while(escolhaInterna != 2);
                    }else{
                        console.clear();
                        System.out.println("(Sistema): Nenhuma Reserva cadastrada ainda, por favor realize o cadastro de ao menos uma Reserva");
                        System.out.println("\n(Sistema): Retornando ao menu em 3 segundos... ");
            
                        console.sleep(3000);
                    }
                    break;
                default:
                    break;
            }

        } while (escolha != 8);
        leitor.close();
    }

    private static void cadastrarCliente(Scanner leitor){
        int escolhaInterna;
        leitor.nextLine();

        do {
            String nome;
            String cpf;

            console.clear();
            System.out.println("(Sistema): Para prosseguir com o registro, precisaremos de algumas informaçoes. \n");

            System.out.println("(Sistema): Qual é o nome do Cliente?");
            System.out.print("\n(Usuario): ");
            nome = leitor.nextLine();
            
            System.out.println("\n(Sistema): Qual CPF do Cliente?");
            System.out.print("\n(Usuario): ");
            cpf = leitor.nextLine();

            try {
                Cliente cliente = new Cliente(nome, cpf);                

                    for(int i = 0; i < clientes.length; i++){
                        if(clientes[i] == null){
                            clientes[i] = cliente;
                            break;
                        }
                    }
                    console.clear();
                    System.out.println("(Sistema): Cliente registrado com sucesso!\n");
                    System.out.println("(Sistema): Você pode verificar o Cliente cadastrado no menu inicial\n");
            } catch (Exception e) {
                console.clear();
                System.out.println("(Sistema): Desculpe, ocorreu um problema ao realizar o registro!");
            }

            System.out.println("(Sistema): Gostaria de cadastrar outro Cliente?\n");

            System.out.println(
                            "[1] Sim\n" +
                            "[2] Nao, retornar");
            System.out.print("(Usuario): ");
            escolhaInterna = leitor.nextInt();
            leitor.nextLine();
        } while (escolhaInterna != 2);
    }

    private static void cadastrarQuarto(Scanner leitor){
        int escolhaInterna;
        leitor.nextLine();

        do {
            String nome;

            console.clear();
            System.out.println("(Sistema): Para prosseguir com o registro, precisaremos de algumas informaçoes. \n");

            System.out.println("(Sistema): Qual é o nome do Quarto?");
            System.out.print("\n(Usuario): ");
            nome = leitor.nextLine();

            try {
                Quarto quarto = new Quarto(nome);                

                    for(int i = 0; i < quartos.length; i++){
                        if(quartos[i] == null){
                            quartos[i] = quarto;
                            break;
                        }
                    }
                    console.clear();
                    System.out.println("(Sistema): Quarto registrado com sucesso!\n");
                    System.out.println("(Sistema): Você pode verificar o Quarto cadastrado no menu inicial\n");
            } catch (Exception e) {
                console.clear();
                System.out.println("(Sistema): Desculpe, ocorreu um problema ao realizar o registro!");
            }

            System.out.println("(Sistema): Gostaria de cadastrar outro Quarto?\n");

            System.out.println(
                            "[1] Sim\n" +
                            "[2] Nao, retornar");
            System.out.print("(Usuario): ");
            escolhaInterna = leitor.nextInt();
            leitor.nextLine();
        } while (escolhaInterna != 2);
    }

    private static void realizaReserva(Scanner leitor){
        int escolhaInterna;
        Date dataReserva;
        Cliente clienteReserva;
        Quarto quartoReserva;

        do {
            
            console.clear();

            quartoReserva = adicionarQuartoReserva(leitor);

            clienteReserva = adicionarClienteReserva(leitor);

            dataReserva = solicitaDataReserva(leitor);

            if(dataReserva != null){
                Date today = new Date();

                long diffDateMillis = dataReserva.getTime() - today.getTime();
                long diffDays = diffDateMillis / (1000 * 60 * 60 * 24);
                
                double value = quartoReserva.getValueDay() * diffDays;

                Reserva reserva = new Reserva(quartoReserva, dataReserva, value, clienteReserva);

                for(int i = 0; i < reservas.length; i++){
                    if(reservas[i] == null){
                        reservas[i] = reserva;
                        break;
                    }
                }

                console.clear();
                System.out.println("(Sistema): Reserva realizada com sucesso!!");
                reserva.exibeReserva();
            }else {
                System.out.println("(Sistema): Nao foi possível validar a data da reserva, tente novamente!");
            }

            System.out.println("\n(Sistema): Gostaria de realizar outra reserva?");
            System.out.println("(Sistema): [1] Sim [2] Nao, retornar.");
            System.out.print("(Usuário): ");
            escolhaInterna = leitor.nextInt();
        } while (escolhaInterna != 2);
    }

    private static void realizaCheckOut(Scanner leitor) {
        int escolhaInterna;
        
        do {
            console.clear();
            System.out.println("(Sistema): Realizar Devoluçao.\n");
            leitor.nextLine();

            exibeReservasCadastradas();

            System.out.println("\n(Sistema): Qual codigo(id) da Reserva deseja realizar o CheckOut?");
            System.out.print("(Usuario): ");
            String id = leitor.nextLine();

            Reserva reservaEncontrada = buscaReservaPorId(id);

            if(reservaEncontrada != null){
                Quarto quartoReservado = buscarQuartoPorNome(reservaEncontrada.getQuarto().getName());

                if(quartoReservado != null){
                    quartoReservado.setAvailable(true);
                }
            }else{
                System.out.println("(Sistema): Reserva nao encontrada, tente novamente!");
            }

            System.out.println("\n(Sistema): Gostaria de realizar outro CheckOut?");
            System.out.println("(Sistema): [1] Sim [2] Nao, retornar.");
            System.out.print("(Usuário): ");
            escolhaInterna = leitor.nextInt();
        } while (escolhaInterna != 2);
    }

    private static boolean verificaQuartosCadastrados(){
        for(Quarto quarto : quartos){
            if(quarto != null){
                return true;
            }
        }
        return false;
    }

    private static boolean verificaClienteCadastrados(){
        for(Cliente cliente : clientes){
            if(cliente != null){
                return true;
            }
        }
        return false;
    }

    private static boolean verifcaReservaCadastrada(){
        for(Reserva reserva : reservas){
            if(reserva != null){
                return true;
            }
        }
        return false;
    }

    private static void exibeQuartosCadastrados() {
        for (Quarto quarto : quartos) {
            if (quarto != null) {
                quarto.introduceRoom();
            }
        }
    }

    private static void exibeClientesCadastrados() {
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                System.out.println("Cliente: " + cliente.getName() + " | CPF: " + cliente.getCpf());
            }
        }
    }

    private static void exibeReservasCadastradas() {
        for (Reserva reserva : reservas) {
            if (reserva != null) {
                reserva.exibeReserva();
            }
        }
    }

    private static Quarto buscarQuartoPorNome(String nome){
        for (Quarto quarto : quartos) {
            if (quarto != null && quarto.getName().trim().equalsIgnoreCase(nome)) {
                return quarto;
            }
        }
        return null;
    }

    private static void buscaQuartoPorData(Date data){
        for (Quarto quarto : quartos) {
            if (quarto != null && quarto.getAvailable() && quarto.getReservationDate().equals(data)) {
                quarto.introduceRoom();
            }
        }
    }

    private static Cliente buscarClientePorNome(String nome){
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getName().trim().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    private static Reserva buscaReservaPorId(String id){
        for (Reserva reserva : reservas) {
            if (reserva != null && reserva.getId().trim().equalsIgnoreCase(id)) {
                return reserva;
            }
        }
        return null;
    }

    public static Quarto adicionarQuartoReserva(Scanner leitor){
        Quarto quartoReservado = null;
        leitor.nextLine();

        do {
            console.clear();
            System.out.println("(Sistema): Realizar reserva de quarto.\n");
            
            exibeQuartosCadastrados();

            System.out.println("\n(Sistema): Qual quarto deseja reservar?");
            System.out.print("\n(Usuario): ");
            String nomeQuarto = leitor.nextLine();

            quartoReservado = buscarQuartoPorNome(nomeQuarto);

            if(quartoReservado != null && quartoReservado.getAvailable()){
                quartoReservado.setAvailable(false);
                System.out.println("(Sistema): Quarto reservado com sucesso!\n");
                System.out.println("(Sistema): Redirecionando em 1 segundos...");
            }else{
                System.out.println("(Sistema): Quarto inexistente. Por favor, tente novamente.\n");
                System.out.println("(Sistema): Redirecionando em 2 segundos...");
                console.sleep(1000);
            }
            
        } while (quartoReservado == null);

        return quartoReservado;
    }

    public static Cliente adicionarClienteReserva(Scanner leitor){
        console.clear();
        exibeClientesCadastrados();

        System.out.println("\n(Sistema): Informe do nome do Cliente que será responsavel pela Reserva do Quarto!");
        System.out.print("(Usuario): ");
        String nomeCliente = leitor.nextLine();

        Cliente clienteEncontrado = buscarClientePorNome(nomeCliente);

        if(clienteEncontrado != null){
            return clienteEncontrado;
        }else{
            System.out.println("(Sistema): Esse Cliente nao existe, ou nao foi encontrado nos cadastros!");
            return null;
        }
    }

    private static Date solicitaDataReserva(Scanner leitor) {
        System.out.println("\n(Sistema): Por gentileza, informe a data da reserva do quarto. Formato aceitável (dd/MM/yyyy)");
        System.out.print("(Usuário): ");
        String dataReservaString = leitor.nextLine();
    
        try {
            return formatarData.parse(dataReservaString);
        } catch (Exception e) {
            System.out.println("(Sistema): Formato de data inválido. Por favor, tente novamente.");
            return null;
        }
    }
}