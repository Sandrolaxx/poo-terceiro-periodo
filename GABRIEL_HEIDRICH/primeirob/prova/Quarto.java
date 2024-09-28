package GABRIEL_HEIDRICH.primeirob.prova;

public class Quarto {
    int numero;
    boolean disponivel;
    double valorDiaria;

    public Quarto(int numero, double valorDiaria) {
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;  // Quarto começa como disponível
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void reservar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }
}
