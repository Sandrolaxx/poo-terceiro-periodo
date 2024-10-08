package VINICIUS_PASCOATO.primeirob.prova;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaHotel hotel = new SistemaHotel();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Sistema Hotel Pascoato ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto");
            System.out.println("3. Listar Quartos");
            System.out.println("4. Reservar Quarto");
            System.out.println("5. Verificar Disponibilidade de Quarto");
            System.out.println("6. Realizar Check-out");
            System.out.println("7. Calcular Total de Diárias");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    Hospede cliente = new Hospede(nome, cpf);
                    hotel.cadastrarCliente(cliente);
                    break;

                case 2:
                    System.out.print("Digite o número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o tipo do quarto: ");
                    String tipoQuarto = scanner.nextLine();

                    System.out.print("Digite o preço do quarto: ");
                    double preco = scanner.nextDouble();

                    hotel.cadastrarQuarto(new QuartoReserva(numeroQuarto, tipoQuarto, preco));
                    System.out.println("Quarto cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("\nQuartos disponíveis:");
                    hotel.listarQuartos();
                    break;

                case 4:
                    System.out.print("Digite o nome do cliente: ");
                    nome = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");
                    cpf = scanner.nextLine();

                    cliente = new Hospede(nome, cpf);

                    System.out.print("\nEscolha o número do quarto que deseja reservar: ");
                    numeroQuarto = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite a data de entrada: Ex: (25/06/2001): ");
                    String dataEntradaStr = scanner.nextLine();

                    System.out.print("Digite a data de saída: ");
                    String dataSaidaStr = scanner.nextLine();

                    System.out.print("Digite o valor da diária: ");
                    double valorDiaria = scanner.nextDouble();
                    scanner.nextLine();

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dataEntrada = sdf.parse(dataEntradaStr);
                        Date dataSaida = sdf.parse(dataSaidaStr);

                        if (hotel.reservarQuarto(cliente, numeroQuarto, dataEntrada, dataSaida, valorDiaria)) {
                            System.out.println("\nReserva realizada.");
                        } else {
                            System.out.println("\nFalha ao realizar a reserva.");
                        }
                    } catch (Exception e) {
                        System.out.println("Verifique o formato da data.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o número do quarto para verificar se está disponível: ");
                    int quartoVerificar = scanner.nextInt();
                    scanner.nextLine();

                    boolean disponivel = hotel.verificarDisponibilidade(quartoVerificar, new Date());
                    System.out.println("Quarto " + quartoVerificar + " disponível: " + (disponivel ? "Sim" : "Não"));
                    break;

                case 6:
                    System.out.print("Digite o nome do cliente para realização do check-out: ");
                    nome = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");
                    cpf = scanner.nextLine();

                    cliente = new Hospede(nome, cpf);
                    hotel.realizarCheckOut(cliente);
                    break;

                case 7:
                    System.out.print("Digite o nome do cliente para calcular o total de diárias: ");
                    nome = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");
                    cpf = scanner.nextLine();

                    cliente = new Hospede(nome, cpf);
                    hotel.calcularTotalDiarias(cliente);
                    break;

                case 8:
                    System.out.println("Sistema do hotel desligando");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
