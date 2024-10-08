package GABRIEL_HEIDRICH.primeirob.prova;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Hotel {
    static Cliente[] clientes = new Cliente[10];
    static Quarto[] quartos = new Quarto[10];
    static Reserva[] reservas = new Reserva[10];
    static int contadorClientes = 0;
    static int contadorQuartos = 0;
    static int contadorReservas = 0;

    public static void cadastrarCliente(String nome, String cpf) {
        clientes[contadorClientes++] = new Cliente(nome, cpf);
    }

    public static void cadastrarQuarto(int numero, double valorDiaria) {
        quartos[contadorQuartos++] = new Quarto(numero, valorDiaria);
    }

    public static void listarQuartos() {
        for (int i = 0; i < contadorQuartos; i++) {
            String status = quartos[i].isDisponivel() ? "Disponível" : "Reservado";
            System.out.println("Quarto " + quartos[i].numero + " - " + status);
        }
    }

    public static void reservarQuarto(int numeroQuarto, String cpfCliente, LocalDate dataCheckIn, int dias) {
        Cliente cliente = buscarClientePorCpf(cpfCliente);
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        if (quarto == null || !quarto.isDisponivel()) {
            System.out.println("Quarto não disponível!");
            return;
        }

        reservas[contadorReservas++] = new Reserva(cliente, quarto, dataCheckIn, dias);
        System.out.println("Reserva realizada para o cliente " + cliente.nome + " no quarto " + quarto.numero);
    }

    public static void realizarCheckOut(int numeroQuarto) {
        Reserva reserva = buscarReservaPorNumeroQuarto(numeroQuarto);

        if (reserva == null) {
            System.out.println("Reserva não encontrada!");
            return;
        }

        double total = reserva.calcularTotal();
        reserva.realizarCheckOut();
        System.out.println("Check-out realizado com sucesso.");
        System.out.println("Total a pagar: R$" + total);
    }

    public static void verificarDisponibilidadePorData(int numeroQuarto, LocalDate data) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);

        if (quarto == null) {
            System.out.println("Quarto não encontrado!");
            return;
        }

        boolean disponivel = true;
        for (int i = 0; i < contadorReservas; i++) {
            if (reservas[i].quarto.numero == numeroQuarto) {
                if (!reservas[i].verificaDisponibilidade(data)) {
                    disponivel = false;
                    break;
                }
            }
        }

        if (disponivel) {
            System.out.println("Quarto " + numeroQuarto + " está disponível na data " + data);
        } else {
            System.out.println("Quarto " + numeroQuarto + " não está disponível na data " + data);
        }
    }

    private static Cliente buscarClientePorCpf(String cpf) {
        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].cpf.equals(cpf)) {
                return clientes[i];
            }
        }
        return null;
    }

    private static Quarto buscarQuartoPorNumero(int numero) {
        for (int i = 0; i < contadorQuartos; i++) {
            if (quartos[i].numero == numero) {
                return quartos[i];
            }
        }
        return null;
    }

    private static Reserva buscarReservaPorNumeroQuarto(int numeroQuarto) {
        for (int i = 0; i < contadorReservas; i++) {
            if (reservas[i].quarto.numero == numeroQuarto) {
                return reservas[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcao;

        do {
            System.out.println("\n---- Sistema de Gerenciamento de Hotel ----");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto");
            System.out.println("3. Listar Quartos");
            System.out.println("4. Reservar Quarto");
            System.out.println("5. Realizar Check-out");
            System.out.println("6. Verificar Disponibilidade por Data");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("CPF: ");
                    String cpf = scanner.next();
                    cadastrarCliente(nome, cpf);
                    break;
                case 2:
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    System.out.print("Valor da diária: ");
                    double valorDiaria = scanner.nextDouble();
                    cadastrarQuarto(numero, valorDiaria);
                    break;
                case 3:
                    listarQuartos();
                    break;
                case 4:
                    System.out.print("Número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    System.out.print("CPF do cliente: ");
                    String cpfCliente = scanner.next();
                    System.out.print("Data de check-in (dd/MM/yyyy): ");
                    String dataCheckInStr = scanner.next();
                    LocalDate dataCheckIn = LocalDate.parse(dataCheckInStr, formatter);
                    System.out.print("Número de dias: ");
                    int dias = scanner.nextInt();
                    reservarQuarto(numeroQuarto, cpfCliente, dataCheckIn, dias);
                    break;
                case 5:
                    System.out.print("Número do quarto: ");
                    int numeroQuartoCheckout = scanner.nextInt();
                    realizarCheckOut(numeroQuartoCheckout);
                    break;
                case 6:
                    System.out.print("Número do quarto: ");
                    int numeroVerificar = scanner.nextInt();
                    System.out.print("Data (dd/MM/yyyy): ");
                    String dataStr = scanner.next();
                    LocalDate data = LocalDate.parse(dataStr, formatter);
                    verificarDisponibilidadePorData(numeroVerificar, data);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
