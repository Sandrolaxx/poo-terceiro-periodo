package MURILO_WOLFF.primeirob.prova.sistemahotel.servicos;

import MURILO_WOLFF.primeirob.prova.sistemahotel.entidades.Cliente;
import MURILO_WOLFF.primeirob.prova.sistemahotel.entidades.Quarto;
import java.util.Date;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;
    private int id;

    public Reserva(Cliente cliente, Quarto quarto, Date dataEntrada, Date dataSaida, int id) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getId() {
        return id;
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

    public void valorTotal() {
        long diferenca = dataSaida.getTime() - dataEntrada.getTime();
        long dias = diferenca / (1000 * 60 * 60 * 24);
        double valorTotal = dias * quarto.getValorDiaria();
        System.out.println("Valor total da reserva: R$ " + valorTotal);
    }

    public boolean realizarReserva(Disponibilidade disponibilidade) {
        if (disponibilidade.verificarDisponibilidade(quarto, dataEntrada, dataSaida)) {
            quarto.adicionarReserva(this);
            System.out.println("Reserva realizada com sucesso para o cliente " + cliente.getNome());
            return true;
        } else {
            System.out.println("Quarto indisponível.");
            return false;
        }
    }
}