package CESAR_MAGAGNIN.primeirob.prova;

//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
import java.util.Scanner;

public class SistemaDeReserva {
 //   private List<Hotel> lojas = new ArrayList<>();
  //  private List<Hospede> hospede = new ArrayList<>();
 //   private List<Quartos> quartos = new ArrayList<>();
 //   private List<Reserva> reservas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

  //  public class CalculadoraLojaPlantas {
    //    private static final Scanner scanner = new Scanner(System.in);
     //   private static final List<String> registroVendas = new ArrayList<>();
    
     public static void main(String[] args) {
        int opcao = 0;
            while (opcao != 7) {
                System.out.println("Escolha uma opção:");
                System.out.println("[1] - Cadastrar Hospede");
                System.out.println("[2] - Cadastrar Quarto");
                System.out.println("[3] - Listar Quartos");
                System.out.println("[4] - Reservar Quarto");
                System.out.println("[5] - Calcular diarias");
                System.out.println("[6] - Realizar Check-out");
                System.out.println("[7] - Sair");
                opcao = scanner.nextInt();
    
                switch (opcao) {
                    case 1:
                        cadastrarHospede(null, opcao, null);
                        break;
                    case 2:
                        cadastrarQuarto(opcao, null, null, opcao);
                        break;
                    case 3:
                        listarQuartos();
                        break;
                    case 4:
                        reservarQuarto();
                        break;
                    case 5:
                        calcularDiarias(opcao, opcao);
                        break;
                    case 6:
                        realizarChekout();
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }
            scanner.close();
        }

    private static void cadastrarQuarto(int numeroQuarto, String nome, String tipo, double valorDiaria) {
        System.out.println("Numero do quarto: ");
        numeroQuarto = scanner.nextInt();
        System.out.println("Nome do quarto:");
        nome = scanner.next();
        System.out.println("Tipo do quarto");
        tipo = scanner.next();
        System.out.println("Valor da diária");
        valorDiaria = scanner.nextDouble();
        System.out.println("Hospede criado com sucesso!\n" + "Nome: " + nome);
        }

    private static void cadastrarHospede(String nome, int idade, String sexo) {
        System.out.println("Nome do hospede: ");
        nome = scanner.next();
        System.out.println("Idade do Hospede:");
        idade = scanner.nextInt();
        System.out.println("Sexo do Hospede");
        sexo = scanner.next();
        System.out.println("Hospede criado com sucesso!\n" + "Nome: " + nome);
    }
    private static void calcularDiarias(float invalid, int qtd) {
       System.out.println("Qual valor diária: ");
       invalid = scanner.nextFloat();
       System.out.println("Quantas diárias: ");
       qtd = scanner.nextInt();
       System.out.println("Valor total das diárias: R$ " + (qtd * invalid) + "\n");

    }

    private static void realizarChekout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'realizarChekout'");
    }

    private static void reservarQuarto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservarQuarto'");
    }

    private static void listarQuartos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarQuartos'");
    }
}
