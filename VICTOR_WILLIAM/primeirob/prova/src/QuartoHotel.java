package VICTOR_WILLIAM.primeirob.prova.src;

public class QuartoHotel {
    private int numeroQuarto;
    private String tipoQuarto;
    private double valorDiaria;
    private boolean disponivel;

    public QuartoHotel(int numeroQuarto, String tipoQuarto, double valorDiaria, boolean disponivel) {
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
