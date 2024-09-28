package JOAO_QUEIROZ.primeirob.prova;

public class Quarto {
    
    private int numero;
    private boolean disponivel;
    private double valorDiaria;

    public Quarto(int numero, double valorDiaria) {
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public double getValorDiaria() {
        return valorDiaria;
    }
}