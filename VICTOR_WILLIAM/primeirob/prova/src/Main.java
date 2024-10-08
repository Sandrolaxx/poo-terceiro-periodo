package VICTOR_WILLIAM.primeirob.prova.src;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(
                    "\nSistema administrativo Hotel Pedrão!\n" +
                            "O que deseja fazer?\n" +
                            "[1] - Cadastrar cliente\n" +
                            "[2] - Cadastrar quarto\n" +
                            "[3] - Listar quartos\n" +
                            "[4] - Reservar quarto para determinada data\n" +
                            "[5] - Realizar check-out do hóspede(cliente)\n" +
                            "[6] - Calcular valor total de diárias a pagar\n" +
                            "[7] - Verificar disponibilidade de quartos para determinada data\n" +
                            "[8] - Sair"
            );
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    cadastrarQuarto(scanner);
                    break;
                case 3:
                      listarQuartos();
                    break;
                case 4:
                    reservarQuarto(scanner);
                    break;
                case 5:
                    realizarCheckOut(scanner);
                    break;
                case 6:
                    calcularValorTotal(scanner);
                    break;
                case 7:
                    verificarDisponibilidade(scanner);
                    break;
                case 8:
                    System.out.println("Saindo... Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 8);
        scanner.close();
    }

    private static final int MAX_CLIENTES = 100;
    private static DadosBasicosCliente[] dadosBasicosClientes = new DadosBasicosCliente[MAX_CLIENTES];
    private static int clienteCount = 0;

    private static void cadastrarCliente(Scanner scanner) {
        if (clienteCount == MAX_CLIENTES) {
            System.out.println("Número máximo de clientes atingido!");
            return;
        }

        System.out.println("Digite o primeiro nome do cliente:");
        String primeiroNomeCliente = scanner.nextLine();

        System.out.println("Digite o segundo nome do cliente:");
        String segundoNomeCliente = scanner.nextLine();

        System.out.println("Digite a idade do cliente:");
        int idadeCliente = scanner.nextInt();

        scanner.nextLine();

        dadosBasicosClientes[clienteCount++] = new DadosBasicosCliente(primeiroNomeCliente, segundoNomeCliente, idadeCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static final int MAX_QUARTOS = 100;
    private static QuartoHotel[] quartos = new QuartoHotel[MAX_QUARTOS];
    private static int quartoCount = 0;
    private static void cadastrarQuarto(Scanner scanner) {
        if(quartoCount == MAX_QUARTOS) {
            System.out.println("Número máximo de quartos atingido!");
            return;
        }

        System.out.println("Digite o número do quarto:");
        int numeroQuarto = scanner.nextInt();

        System.out.println("Digite o tipo do quarto:");
        String tipoQuarto = scanner.nextLine();

        scanner.nextLine();

        System.out.println("Digite o valor da diária do quarto:");
        double valorDiaria = scanner.nextDouble();

        System.out.println("Digite se o quarto está disponível (true/false):");
        boolean disponivel = scanner.nextBoolean();

        scanner.nextLine();

        quartos[quartoCount++] = new QuartoHotel(numeroQuarto, tipoQuarto, valorDiaria, disponivel);
        System.out.println("Quarto cadastrado com sucesso!");
    }


    private static void listarQuartos() {
        if (quartoCount == 0) {
            System.out.println("Nenhum quarto cadastrado!");
            return;
        } else {
            for (int i = 0; i < quartoCount; i++) {
                System.out.println("Quarto " + quartos[i].getNumeroQuarto() + ": " + quartos[i].getTipoQuarto() + " - Valor da diária: R$" + quartos[i].getValorDiaria() + " - Disponível: " + quartos[i].isDisponivel());
            }
        }

    }

    private static final int MAX_RESERVAS = 100;
    private static ReservaQuartoHotel[] reservas = new ReservaQuartoHotel[MAX_RESERVAS];
    private static int reservaCount = 0;
    private static void reservarQuarto(Scanner scanner) {
        System.out.println("Numero do quarto:");
        int numeroQuarto = scanner.nextInt();

        scanner.nextLine();

        QuartoHotel quarto = null;
        for (int i = 0; i < quartoCount; i++) {
            if (quartos[i].getNumeroQuarto() == numeroQuarto && quartos[i].isDisponivel()) {
                quarto = quartos[i];
            }
        }

        if (quarto == null) {
            System.out.println("Quarto não disponível!");
            return;
        }

        System.out.println("Primeiro nome do cliente:");
        String primeiroNomeCliente = scanner.nextLine();

        System.out.println("Segundo nome do cliente:");
        String segundoNomeCliente = scanner.nextLine();

        DadosBasicosCliente dadosBasicosCliente = null;

        for (int i = 0; i < clienteCount; i++) {
            if (dadosBasicosClientes[i].getPrimeiroNomeCliente().equals(primeiroNomeCliente) && dadosBasicosClientes[i].getSegundoNomeCliente().equals(segundoNomeCliente)) {
                dadosBasicosCliente = dadosBasicosClientes[i];
                break;
            }
        }

        if (dadosBasicosCliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Data de reserva (AAAA-MM-DD):");
        LocalDate dataReserva = LocalDate.parse(scanner.nextLine());

        System.out.println("Data de check-out (AAAA-MM-DD):");
        LocalDate dataCheckOut = LocalDate.parse(scanner.nextLine());

        reservas[reservaCount++] = new ReservaQuartoHotel(dadosBasicosCliente, quarto, dataReserva, dataCheckOut);
        quarto.setDisponivel(false);

        System.out.println("Quarto reservado com sucesso!");
    }

    private static void realizarCheckOut(Scanner scanner) {
        System.out.println("Primeiro nome do cliente:");
        String primeiroNomeCliente = scanner.nextLine();

        System.out.println("Segundo nome do cliente:");
        String segundoNomeCliente = scanner.nextLine();

        DadosBasicosCliente dadosBasicosCliente = null;

        for (int i = 0; i < reservaCount; i++) {
            if (dadosBasicosClientes[i].getPrimeiroNomeCliente().equals(primeiroNomeCliente) && dadosBasicosClientes[i].getSegundoNomeCliente().equals(segundoNomeCliente)) {
                dadosBasicosCliente = dadosBasicosClientes[i];
                break;
            }
        }

        if (reservas == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        for(int i = 0; i < reservaCount; i++) {
            if (reservas[i].getDadosBasicosCliente().equals(dadosBasicosCliente)) {
                reservas[i].getQuartoHotel().setDisponivel(true);
            }
        }

        System.out.println("Check-out realizado com sucesso!");
    }

    private static void calcularValorTotal(Scanner scanner) {
        System.out.println("Primeiro nome do cliente:");
        String primeiroNomeCliente = scanner.nextLine();

        System.out.println("Segundo nome do cliente:");
        String segundoNomeCliente = scanner.nextLine();

        ReservaQuartoHotel reserva = null;

        for(int i = 0; i < reservaCount; i++) {
            if (reservas[i].getDadosBasicosCliente().getPrimeiroNomeCliente().equals(primeiroNomeCliente) && reservas[i].getDadosBasicosCliente().getSegundoNomeCliente().equals(segundoNomeCliente)) {
                reserva = reservas[i];
                break;
            }
        }

        if (reserva == null) {
            System.out.println("Reserva não encontrada!");
            return;
        }

        double valorTotal = reserva.getValorTotalReserva();
        System.out.println("Valor total a pagar: R$" + valorTotal);
        System.out.println("Valor total calculado com sucesso! E o primeiro dia vai de brinde!!");
    }

    private static void verificarDisponibilidade(Scanner scanner) {
        System.out.println("Data de reserva (AAAA-MM-DD):");
        LocalDate dataReserva = LocalDate.parse(scanner.nextLine());

        System.out.println("Data de check-out (AAAA-MM-DD):");
        LocalDate dataCheckOut = LocalDate.parse(scanner.nextLine());

        boolean disponivel = false;
        for (int i = 0; i < quartoCount; i++) {
            if (quartos[i].isDisponivel()) {
                disponivel = true;
                System.out.println("Quarto " + quartos[i].getNumeroQuarto() + " disponível!");
            }
        }
        if (!disponivel) {
            System.out.println("Nenhum quarto disponível!");
        }
    }
}


















