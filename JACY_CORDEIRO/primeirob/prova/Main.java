package JACY_CORDEIRO.primeirob.prova;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto");
            System.out.println("3. Realizar Reserva");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Quartos");
            System.out.println("6. Listar Reservas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    hotel.cadastrarCliente(nome, cpf, telefone, email);
                    break;

                case 2:
                    System.out.print("Número do Quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Tipo do Quarto: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço da Diária: ");
                    double precoDiaria = scanner.nextDouble();
                    hotel.cadastrarQuarto(numero, tipo, precoDiaria);
                    break;

                case 3:
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    Cliente cliente = hotel.encontrarCliente(nomeCliente);
                    if (cliente != null) {
                        System.out.print("Número do Quarto: ");
                        int numeroQuarto = scanner.nextInt();
                        Quarto quarto = hotel.encontrarQuarto(numeroQuarto);
                        if (quarto != null) {
                            System.out.print("Número de Dias: ");
                            int dias = scanner.nextInt();
                            hotel.realizarReserva(cliente, quarto, dias);
                        } else {
                            System.out.println("Quarto não encontrado.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    hotel.listarClientes();
                    break;

                case 5:
                    hotel.listarQuartos();
                    break;

                case 6:
                    hotel.listarReservas();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break; // <- Adding break here to terminate the default case properly.
            }
        } while (option != 0);

        scanner.close();
    }
}
