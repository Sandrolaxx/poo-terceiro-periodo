package segundob.aula.prova;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        Integer indiceCliente = 1;
        Integer indiceQuarto = 1;
        Integer indiceReserva = 1;
        Cliente[] clientes = new Cliente[100];
        Quarto[] quartos = new Quarto[100];
        Reserva[] reservas = new Reserva[100];

        while (true) {
            showMenu();

            Integer opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    clientes[indiceCliente] = criarCliente(indiceCliente);

                    indiceCliente++;
                    break;
                case 2:
                    quartos[indiceQuarto] = criarQuarto(indiceQuarto);

                    indiceQuarto++;
                    break;
                case 3:
                    apresentarQuartos(quartos);
                    break;
                case 4:
                    Reserva reservaCriada = criarReserva(clientes, quartos, reservas, indiceReserva);

                    if (reservaCriada == null) {
                        break;
                    }

                    reservas[indiceReserva] = reservaCriada;

                    indiceReserva++;
                    break;
                case 5:
                    realizarCheckInOut(reservas);
                    break;
                case 6:
                    verificarDisponibilidade(reservas, quartos);
                    break;
                case 7:
                    return;
            }
        }

    }

    public static void showMenu() {
        System.out.println("\n SISTEMA - HOTEL - BALA🔫");
        System.out.println("[1] CADASTRO CLIENTE ");
        System.out.println("[2] CADASTRO QUARTO ");
        System.out.println("[3] LISTAGEM QUARTO ");
        System.out.println("[4] REALIZAR RESERVA ");
        System.out.println("[5] REALIZAR CHECK-IN/CHECK-OUT ");
        System.out.println("[6] VERIFICAR DISPONIBILIDADE ");
        System.out.println("[7] SAIR ");
    }

    public static Cliente criarCliente(Integer indiceCliente) {
        input.nextLine();
        Cliente cliente = new Cliente();

        System.out.println("Informe o nome:");
        cliente.setNome(input.nextLine());

        System.out.println("Informe o documento:");
        cliente.setDocumento(input.nextLine());
        cliente.setId(indiceCliente);

        return cliente;
    }

    public static Quarto criarQuarto(Integer indiceQuarto) {
        input.nextLine();
        Quarto quarto = new Quarto();

        System.out.println("Informe a descrição:");
        quarto.setDescricao(input.nextLine());

        System.out.println("Informe o número:");
        quarto.setNumero(input.nextInt());

        System.out.println("Informe o valor da diária:");
        quarto.setValorDiario(input.nextDouble());

        quarto.setId(indiceQuarto);

        return quarto;
    }

    public static void apresentarQuartos(Quarto[] quartos) {
        System.out.println("Listagem Quartos");

        for (int i = 0; i < quartos.length; i++) {
            if (quartos[i] != null) {
                System.out.print("Id: " + quartos[i].getId() + " - ");
                System.out.print("Descrição: " + quartos[i].getDescricao() + " - ");
                System.out.print("Número: " + quartos[i].getNumero() + " - ");
                System.out.print("Valor diária: R$" + quartos[i].getValorDiario());
                System.out.println();
            }
        }
    }

    public static Reserva criarReserva(Cliente[] clientes, Quarto[] quartos, Reserva[] reservas, Integer indiceReserva)
            throws ParseException {
        System.out.println("Informe seu id de usuário:");
        Cliente clienteReserva = buscarPorId(clientes, input.nextInt());
        System.out.println("Informe seu id de quarto:");
        Quarto quartoReserva = buscarPorId(quartos, input.nextInt());

        if (clienteReserva == null) {
            System.out.println("Cliente não encontrado!");

            return null;
        }

        if (quartoReserva == null) {
            System.out.println("Quarto não encontrado!");

            return null;
        }

        Reserva reserva = new Reserva();

        input.nextLine();

        System.out.println("Informe data inicial reserva!(dd/MM/yyyy)");
        Date dataEntrada = DateUtil.ddmmyyyyToDate(input.nextLine());

        System.out.println("Informe data saida reserva!(dd/MM/yyyy)");
        Date dataSaida = DateUtil.ddmmyyyyToDate(input.nextLine());

        boolean isDataReservaValida = validarReservaQuarto(reservas, quartoReserva, dataEntrada, dataSaida);

        if (!isDataReservaValida) {
            return null;
        }

        Double valorDiariaQuarto = quartoReserva.getValorDiario();
        Double valorTotalDiaria = calcularValorTotalDiarias(dataEntrada, dataSaida, valorDiariaQuarto);

        reserva.setDataEntrada(dataEntrada);
        reserva.setDataSaida(dataSaida);
        reserva.setCliente(clienteReserva);
        reserva.setQuarto(quartoReserva);
        reserva.setId(indiceReserva);
        reserva.setTotal(valorTotalDiaria);

        return reserva;
    }

    public static Cliente buscarPorId(Cliente[] clientes, Integer idCliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].getId().equals(idCliente)) {
                return clientes[i];
            }
        }

        return null;
    }

    public static Quarto buscarPorId(Quarto[] quartos, Integer idQuarto) {
        for (int i = 0; i < quartos.length; i++) {
            if (quartos[i] != null && quartos[i].getId().equals(idQuarto)) {
                return quartos[i];
            }
        }

        return null;
    }

    public static Reserva buscarPorId(Reserva[] reservas, Integer idReserva) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null && reservas[i].getId().equals(idReserva)) {
                return reservas[i];
            }
        }

        return null;
    }

    public static boolean validarReservaQuarto(Reserva[] reservas, Quarto quarto, Date dataEntrada, Date dataSaida) {
        Reserva[] reservasPorQuarto = new Reserva[100];
        boolean quartoPossuiReserva = false;

        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null && reservas[i].getQuarto().getId().equals(quarto.getId())) {
                quartoPossuiReserva = true;

                reservasPorQuarto[i] = reservas[i];
            }
        }

        if (quartoPossuiReserva) {
            for (int i = 0; i < reservasPorQuarto.length; i++) {
                if (reservasPorQuarto[i] != null) {
                    Reserva reserva = reservasPorQuarto[i];

                    if (!dataEntrada.after(reserva.getDataSaida())) {
                        System.out.println("Já existe uma reserva nesse quarto para a data de entrada!");

                        return false;
                    }

                    if (!dataSaida.before(reserva.getDataEntrada())) {
                        System.out.println("Já existe uma reserva nesse quarto para a data de saída!");

                        return false;
                    }
                }
            }
        }

        return !quartoPossuiReserva;
    }

    public static Double calcularValorTotalDiarias(Date dataEntrada, Date dataSaida, Double diariaQuarto) {
        Integer diasEntreDatas = DateUtil.diasEntreDatas(dataSaida, dataEntrada);

        return diasEntreDatas * diariaQuarto;
    }

    public static void realizarCheckInOut(Reserva[] reservas) {
        System.out.println("Informe o id do reserva:");
        Integer idReserva = input.nextInt();

        Reserva reservaCheck = buscarPorId(reservas, idReserva);

        if (reservaCheck == null) {
            System.out.println("Reserva não encontrada para o id!");

            return;
        }

        System.out.println("Deseja Realizar: \n[1] Check-in\n[2] Check-out");
        Integer escolha = input.nextInt();
        boolean isCheckIn = escolha.equals(1);

        if (isCheckIn || escolha.equals(2)) {
            reservaCheck.setCheckIn(isCheckIn ? new Date() : null);
            reservaCheck.setCheckOut(escolha.equals(2) ? new Date() : null);

            System.out.println();
            System.out.print(isCheckIn ? "Check-In" : "Check-Out");
            System.out.print(" realizado com sucesso!");

            return;
        }

        System.out.println("Escolha inválida");
    }

    public static void verificarDisponibilidade(Reserva[] reservas, Quarto[] quartos) throws ParseException {
        System.out.println("Informe o id do quarto:");
        Integer idReserva = input.nextInt();

        Quarto quartoCheck = buscarPorId(quartos, idReserva);

        if (quartoCheck == null) {
            System.out.println("Quarto não encontrada para o id!");

            return;
        }

        input.nextLine();
        System.out.println("Informe data inicial reserva!(dd/MM/yyyy)");
        Date dataEntrada = DateUtil.ddmmyyyyToDate(input.nextLine());

        System.out.println("Informe data saida reserva!(dd/MM/yyyy)");
        Date dataSaida = DateUtil.ddmmyyyyToDate(input.nextLine());

        boolean quartoDisponivel = validarReservaQuarto(reservas, quartoCheck, dataEntrada, dataSaida);

        if (quartoDisponivel) {
            System.out.println("Quarto está disponível para a data informada!");
        }
    }

}