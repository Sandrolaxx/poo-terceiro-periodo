package DIONATAN_DARIZ.primeirob.prova;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        do {
            System.out.println("Menu do Hotel:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto");
            System.out.println("3. Listar Quartos");
            System.out.println("4. Reservar Quarto");
            System.out.println("5. Realizar Check-out");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do Cliente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Telefone do Cliente: ");
                    String telefone = scanner.nextLine();
                    hotel.cadastrarCliente(nome, cpf, telefone);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Número do Quarto: ");
                    int numero = scanner.nextInt();
                    System.out.print("Preço da Diária: ");
                    double precoDiaria = scanner.nextDouble();
                    hotel.cadastrarQuarto(numero, precoDiaria);
                    System.out.println("Quarto cadastrado com sucesso!");
                    break;

                case 3:
                    hotel.listarQuartos();
                    break;

                case 4:
                    System.out.print("Número do Quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("CPF do Cliente para a reserva: ");
                    String cpfReserva = scanner.nextLine();
                    Cliente cliente = null;

                    for (int i = 0; i < hotel.getClientes().length; i++) {
                        if (hotel.getClientes()[i] != null && hotel.getClientes()[i].getCpf().equals(cpfReserva)) {
                            cliente = hotel.getClientes()[i];
                            break;
                        }
                    }

                    if (cliente == null) {
                        System.out.println("Cliente não encontrado!");
                    } else {
                        System.out.print("Data de Entrada (dd/MM/yyyy): ");
                        String entradaStr = scanner.nextLine();
                        Date dataEntrada = formatoData.parse(entradaStr);

                        System.out.print("Data de Saída (dd/MM/yyyy): ");
                        String saidaStr = scanner.nextLine();
                        Date dataSaida = formatoData.parse(saidaStr);

                        hotel.reservarQuarto(numeroQuarto, cliente, dataEntrada, dataSaida);
                    }
                    break;

                case 5:
                    System.out.print("Número do Quarto para check-out: ");
                    int numeroCheckOut = scanner.nextInt();
                    hotel.realizarCheckOut(numeroCheckOut);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
