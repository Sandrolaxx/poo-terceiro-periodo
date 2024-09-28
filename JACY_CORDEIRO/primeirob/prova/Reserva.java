package JACY_CORDEIRO.primeirob.prova;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private int dias;

    public Reserva(Cliente cliente, Quarto quarto, int dias) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente.getNome() +
                ", quarto=" + quarto.getNumero() +
                ", dias=" + dias +
                '}';
    }
}
