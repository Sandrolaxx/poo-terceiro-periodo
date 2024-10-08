package JOAO_QUEIROZ.primeirob.prova;

import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public Reserva(Cliente cliente, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Quarto getQuarto() {
        return quarto;
    }
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    public LocalDate getDataSaida() {
        return dataSaida;
    }
    public long calcularDiarias() {
        return java.time.temporal.ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    }
    public double calcularTotalAPagar() {
        return calcularDiarias() * quarto.getValorDiaria();
    }
}
