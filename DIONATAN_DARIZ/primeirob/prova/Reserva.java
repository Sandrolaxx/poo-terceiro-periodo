package DIONATAN_DARIZ.primeirob.prova;

import java.util.Date;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;

    public Reserva(Cliente cliente, Quarto quarto, Date dataEntrada, Date dataSaida) {
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public double calcularValorTotal() {
        long diferenca = dataSaida.getTime() - dataEntrada.getTime();
        int numeroDiarias = (int) (diferenca / (1000 * 60 * 60 * 24));
        return numeroDiarias * quarto.getPrecoDiaria();
    }

    public boolean conflitoDeDatas(Date dataEntrada, Date dataSaida) {
        return (this.dataEntrada.before(dataSaida) && this.dataSaida.after(dataEntrada));
    }
}
