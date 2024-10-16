import java.util.Date;
import java.util.Scanner;

public class Main {

  static  GerenciarHotel hotel = new GerenciarHotel(100, 100, 100);
   static Scanner scanner = new Scanner(System.in);
     public static void main(String[] args) {
        
        int opcao;

        do {
            System.out.println("\n--- Menu Hotel ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto");
            System.out.println("3. Fazer Reserva");
            System.out.println("4. Realizar check-out");
            System.out.println("5. Verificar Disponibilidade");
            System.out.println("6. Listar quartos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    cadastrarClienteMenu();
                    break;
                    
                case 2:
                    cadastrarQuartoMenu();
                    break;

                case 3:
                   fazerReservaMenu();
                    break;

                case 4: 
                   
                    fazerCheckoutMenu();
                    break;

                case 5:
                    verificarDisponibilidadeMenu();
                    break;

                case 6:
                   hotel.exibirQuartos();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }


    public static void cadastrarClienteMenu(){
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a idade co cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        System.out.println("Digite o sexo do cliente [1]H / [2]M: ");
        int sexo = scanner.nextInt();
        hotel.cadastrarCliente(nome, idade, cpf, sexo);

    }

    public static void cadastrarQuartoMenu(){
        System.out.println("Digite o numero do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o tipo do quarto[1]comum / [2] suite: ");
        int tipoquarto = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a quantidade de camas do quarto: ");
        int qtdCamas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o valor do quarto: ");
        double valor = scanner.nextDouble();
        hotel.cadastrarQuarto(numero, tipoquarto, qtdCamas, valor);
    }
    
    public static void fazerReservaMenu(){
        System.out.println("Digite o CPF do cliente");
        String cpf = scanner.nextLine();
        Cliente clienteReserva = hotel.buscarClienteCPF(cpf);
        if(clienteReserva != null){
            System.out.println("Digite o numero do quarto: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        Quarto quartorReserva = hotel.buscarQuartoNumero(numero);
        if (quartorReserva != null) {
             System.out.print("Digite a data de entrada (dd/mm/yyyy): ");
            String dataEntrada= scanner.nextLine();  
            System.out.print("Digite a data de saida(dd/mm/yyyy): ");
            String dataSaida= scanner.nextLine();                   
            Date dataEntradaP = parseData(dataSaida);
            Date dataSaidaP =parseData(dataSaida);
            hotel.fazerReserva(clienteReserva, quartorReserva, dataEntradaP, dataSaidaP);
        }else{
            System.out.println("Quarto não encontrado");
        }
        }else{
            System.out.println("Cliente não encontrado");
        }
        

    }
    public static void fazerCheckoutMenu(){
        System.out.println("Digite o numero do quarto: ");
        int numerosair = scanner.nextInt();
        Quarto quartosair = hotel.buscarQuartoNumero(numerosair);
        if(quartosair != null){
            boolean sucesso = hotel.fazerCheckout(quartosair, numerosair);
            if (sucesso) {
                System.out.println("Checkout realizado com sucesso.");
            } else {
                System.out.println("Erro ao realizar checkout.");
            }
        } else {
            System.out.println("Quarto não encontrado");
        }
    }

    public static void verificarDisponibilidadeMenu(){
            System.out.println("Digite o numero do quarto: ");
            int numeroq = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite a data de entrada: ");
            String dataEntrada= scanner.nextLine();  
            Date dataEntradaP = parseData(dataEntrada);
            hotel.verificarDisponibilidade(numeroq, dataEntradaP);
    }


    private static Date parseData(String dataStr) {
        String[] partes = dataStr.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]) - 1; // Meses começam em 0
        int ano = Integer.parseInt(partes[2]) - 1900; // Anos são contados desde 1900
        return new Date(ano, mes, dia);
    }

}
   
