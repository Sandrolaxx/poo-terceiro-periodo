package MARCUS_PENSO.primeirob.prova;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private int dias;
    private boolean checkOut;

    public Reserva(Cliente cliente, Quarto quarto, int dias) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dias = dias;
        this.checkOut = false; 
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public int getDias() {
        return dias;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void realizarCheckOut() {
        this.checkOut = true;
        this.quarto.setDisponivel(true); 
    }

    public double calcularTotal(double valorDiaria) {
        return dias * valorDiaria;
    }
}
