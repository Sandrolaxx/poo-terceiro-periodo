package ERICK_SCUR.primeirob.prova.src;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Cliente[] clientes = new Cliente[100];
    private static Quarto[] quartos = new Quarto[100];
    private static Reserva[] reservas = new Reserva[100];

    private static Scanner scanner = new Scanner(System.in);
    private static int ultimoIdCliente = 0;
    private static int ultimoNumeroQuarto = 0;
    private static int ultimoIdReserva = 0;

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("""
                    Escolha uma opção:
                    1- Cadastrar Cliente
                    2- Listar clientes
                    3- Cadastrar Quarto
                    4- Listar Quartos
                    5- Reservar Quarto
                    6- Listar Reservas
                    7- Calcular Valor Reserva
                    8- Verificar Disponibilidade Quarto
                    9- Realizar Checkin Hospede
                    10- Realizar Checkout Hospede
                    0- Sair do Sistema
            """);

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    cadastrarQuarto();
                    break;
                case 4:
                    listarQuartos();
                    break;
                case 5:
                    reservarQuarto();
                    break;
                case 6:
                    listarReservas();
                    break;
                case 7:
                    calcularValorReserva();
                    break;
                case 8:
                    verificarDisponibilideQuarto();
                    break;
                case 9:
                    realizarCheckinHospede();
                    break;
                case 10:
                    realizarCheckoutHospede();
                    break;
            }
        } while(opcao != 0);
    }

    private static void listarReservas() {
        for (int i = 0; i < ultimoIdReserva; i++) {
            System.out.println(reservas[i] + "\n");
        }
    }

    private static void listarClientes() {
        for (int i = 0; i < ultimoIdCliente; i++) {
            System.out.println(clientes[i] + "\n");
        }
    }

    private static void reservarQuarto() {
        System.out.println("Informe o id do cliente: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = clientes[idCliente];

        if (cliente == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        System.out.println("Informe o numero do quarto: ");
        int idQuarto = scanner.nextInt();
        Quarto quarto = quartos[idQuarto];

        if (quarto == null) {
            System.out.println("Quarto não encontrado");
            return;
        }

        Date dataCheckin = coletarData("Informe a data de checkin: ");
        Date dataCheckout = coletarData("Informe a data de checkout: ");

        if (!verificarReservaDisponivel(quarto.getNumero(), dataCheckin, dataCheckout)) {
            System.out.println("Quarto indisponivel na data");
            return;
        }

        Reserva reserva = new Reserva(ultimoIdReserva, cliente, quarto, dataCheckin, dataCheckout);
        reservas[ultimoIdReserva] = reserva;

        ultimoIdReserva++;
    }

    private static void realizarCheckoutHospede() {
        System.out.println("Informe o id da reserva: ");
        int idReserva = scanner.nextInt();
        Reserva reserva = reservas[idReserva];

        if (reserva == null) {
            System.out.println("Reserva não encontrada");
            return;
        }

        reserva.checkout();
    }

    private static void realizarCheckinHospede() {
        System.out.println("Informe o id da reserva: ");
        int idReserva = scanner.nextInt();
        Reserva reserva = reservas[idReserva];

        if (reserva == null) {
            System.out.println("Reserva não encontrada");
            return;
        }

        reserva.checkin();
    }

    private static Date coletarData(String mensagem) {
        boolean dataValida = false;
        do {
            System.out.println(mensagem);
            String dataInput = scanner.nextLine();
            try {
                Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataInput);
                if (data.after(new Date())) {
                    dataValida = true;
                } else {
                    System.out.println("Data deve ser maior que a data atual");
                }

                return data;
            } catch (Exception e) {
                System.out.println("Data invalida");
            }
        } while (!dataValida);

        return null;
    }

    private static void calcularValorReserva() {
        System.out.println("Informe o id da reserva: ");
        int idReserva = scanner.nextInt();
        Reserva reserva = reservas[idReserva];

        if (reserva == null) {
            System.out.println("Reserva não encontrada");
            return;
        }

        double valor = reserva.calcularValorReserva();
        System.out.println("Valor da reserva: " + valor);
    }

    private static void verificarDisponibilideQuarto() {
        System.out.println("Informe o id do cliente: ");
        int idCliente = scanner.nextInt();

        System.out.println("Informe o numero do quarto: ");
        int numeroQuarto = scanner.nextInt();

        Date dataCheckin = coletarData("Informe a data de checkin: ");
        Date dataCheckout = coletarData("Informe a data de checkout: ");

        if (verificarReservaDisponivel(numeroQuarto, dataCheckin, dataCheckout)) {
            System.out.println("Quarto disponivel");
        } else {
            System.out.println("Quarto indisponivel");
        }
    }

    private static boolean verificarReservaDisponivel(int numeroQuarto, Date dataCheckin, Date dataCheckout) {
        for (int i = 0; i < ultimoIdReserva; i++) {
            Reserva reserva = reservas[i];
            if (reserva.getQuarto().getNumero() == numeroQuarto) {
                if (dataCheckin.after(reserva.getDataCheckin()) && dataCheckin.before(reserva.getDataCheckout())) {
                    return false;
                }
                if (dataCheckout.after(reserva.getDataCheckin()) && dataCheckout.before(reserva.getDataCheckout())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void cadastrarCliente() {
        System.out.println("Cadastro de Cliente");
        System.out.println("Informe o nome: ");
        String nome = scanner.next();
        System.out.println("Informe o CPF: ");
        String cpf = scanner.next();
        System.out.println("Informe o telefone: ");
        String telefone = scanner.next();

        int id = ultimoIdCliente;

        Cliente cliente = new Cliente(id, nome, cpf, telefone);
        clientes[id] = cliente;

        ultimoIdCliente++;
    }

    private static void cadastrarQuarto() {
        System.out.println("Cadastro de Quarto");
        System.out.println("Informe o andar: ");
        int andar = scanner.nextInt();
        System.out.println("Informe o valor da diária: ");
        double valorDiaria = scanner.nextDouble();

        int numero = ultimoNumeroQuarto;
        Quarto quarto = new Quarto(numero, andar, valorDiaria);
        quartos[numero] = quarto;

        ultimoNumeroQuarto++;
    }

    private static void listarQuartos() {
        for (int i = 0; i < ultimoNumeroQuarto; i++) {
            System.out.println(quartos[i] + "\n");
        }
    }
}
