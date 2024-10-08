package VINICIUS_PASCOATO.primeirob.prova;
import java.util.Date;

public class Reserva {
    private Hospede cliente;
    private QuartoReserva quarto;
    private Date dataEntrada;
    private Date dataSaida;
    private double valorDiaria;

    public Reserva(Hospede cliente, QuartoReserva quarto, Date dataEntrada, Date dataSaida, double valorDiaria) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorDiaria = valorDiaria;
        this.quarto.setDisponivel(false);
    }

    public Hospede getCliente() {
        return cliente;
    }

    public QuartoReserva getQuarto() {
        return quarto;
    }

    public double calcularTotalDiarias() {
        long dias = (dataSaida.getTime() - dataEntrada.getTime()) / (1000 * 60 * 60 * 24);
        return dias * valorDiaria;
    }
}
