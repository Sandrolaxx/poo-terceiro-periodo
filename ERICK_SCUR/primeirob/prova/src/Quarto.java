package ERICK_SCUR.primeirob.prova.src;

public class Quarto {
    private int numero;
    private int andar;
    private double precoDiaria;

    public Quarto(int numero, int andar, double precoDiaria) {
        this.numero = numero;
        this.andar = andar;
        this.precoDiaria = precoDiaria;
    }

    public int getNumero() {
        return numero;
    }

    public int getAndar() {
        return andar;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", andar=" + andar +
                ", precoDiaria=" + precoDiaria +
                '}';
    }
}
