package JACY_CORDEIRO.primeirob.prova;

public class Quarto {
    private int numero;
    private String tipo;
    private double precoDiaria;

    public Quarto(int numero, String tipo, double precoDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiaria = precoDiaria;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", precoDiaria=" + precoDiaria +
                '}';
    }
}
