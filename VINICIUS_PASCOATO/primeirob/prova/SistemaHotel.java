package VINICIUS_PASCOATO.primeirob.prova;
import java.util.Date;

public class SistemaHotel {
    private QuartoReserva[] quartos = new QuartoReserva[100];
    private Reserva[] reservas = new Reserva[100];
    private int totalReservas = 0;
    private int totalQuartosCadastrados = 0;

    public void cadastrarCliente(Hospede cliente) {
        System.out.println("Cliente cadastrado: " + cliente);
    }

    public void cadastrarQuarto(QuartoReserva quarto) {
        if (totalQuartosCadastrados < quartos.length) {
            quartos[totalQuartosCadastrados] = quarto;
            totalQuartosCadastrados++;
        } else {
            System.out.println("Não há mais quartos no hotel");
        }
    }

    public void listarQuartos() {
        if (totalQuartosCadastrados == 0) {
            System.out.println("Nenhum quarto cadastrado.");
        } else {
            for (int i = 0; i < totalQuartosCadastrados; i++) {
                System.out.println(quartos[i]);
            }
        }
    }

    public boolean reservarQuarto(Hospede cliente, int numeroQuarto, Date dataEntrada, Date dataSaida,
            double valorDiaria) {
        if (numeroQuarto <= 0 || numeroQuarto > totalQuartosCadastrados) {
            System.out.println("Quarto inválido.");
            return false;
        }

        QuartoReserva quarto = quartos[numeroQuarto - 1];
        if (!quarto.isDisponivel()) {
            System.out.println("Quarto não disponível.");
            return false;
        }

        reservas[totalReservas] = new Reserva(cliente, quarto, dataEntrada, dataSaida, valorDiaria);
        totalReservas++;
        return true;
    }

    public void realizarCheckOut(Hospede cliente) {
        for (int i = 0; i < totalReservas; i++) {
            if (reservas[i] != null && reservas[i].getCliente().getCpf().equals(cliente.getCpf())) {
                reservas[i].getQuarto().setDisponivel(true);
                double total = reservas[i].calcularTotalDiarias();
                System.out.println("Check-out realizado com sucesso. Total a pagar: R$ " + total);
                reservas[i] = null;
                return;
            }
        }
        System.out.println("Reserva não encontrada, esse cliente não existe.");
    }

    public boolean verificarDisponibilidade(int numeroQuarto, Date data) {
        if (numeroQuarto <= 0 || numeroQuarto > totalQuartosCadastrados) {
            return false;
        }
        QuartoReserva quarto = quartos[numeroQuarto - 1];
        return quarto.isDisponivel();
    }

    public void calcularTotalDiarias(Hospede cliente) {
        for (int i = 0; i < totalReservas; i++) {
            if (reservas[i] != null && reservas[i].getCliente().getCpf().equals(cliente.getCpf())) {
                double total = reservas[i].calcularTotalDiarias();
                System.out.println("Total de diárias a pagar: R$ " + total);
                return;
            }
        }
        System.out.println("Reserva não encontrada, esse cliente não existe.");
    }
}
