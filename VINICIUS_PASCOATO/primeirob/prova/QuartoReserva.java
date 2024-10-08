package VINICIUS_PASCOATO.primeirob.prova;
public class QuartoReserva {
    private int numero;
    private String tipo;
    private double precoPadrao;
    private boolean disponivel;

    public QuartoReserva(int numero, String tipo, double precoPadrao) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoPadrao = precoPadrao;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoPadrao() {
        return precoPadrao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + " - Tipo: " + tipo + " - Preço: R$ " + precoPadrao + " - Disponível: "
                + (disponivel ? "Sim" : "Não");
    }
}
