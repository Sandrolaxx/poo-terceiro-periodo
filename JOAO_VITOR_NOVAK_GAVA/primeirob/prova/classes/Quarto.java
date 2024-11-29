package JOAO_VITOR_NOVAK_GAVA.primeirob.prova.classes;

import java.util.Date;

public class Quarto {
    private int numero;
    private double valorDiaria;
    private boolean disponibilidade;
    private Date checkin;
    private Date checkout;

    public Quarto(int numero, double valorDiaria) {
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.disponibilidade = true;
        this.checkin = null;
        this.checkout = null;
    }

    public int getNumero() {
        return numero;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void reservar(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.disponibilidade = false;
    }

    public void liberar() {
        this.checkin = null;
        this.checkout = null;
        this.disponibilidade = true;
    }

    public long calcularDias() {
        if (checkin == null || checkout == null) {
            return 0;
        }
        long diferençaDias = checkout.getTime() - checkin.getTime();
        return diferençaDias / (1000 * 60 * 60 * 24);
    }

    public double calcularValorTotal() {
        return calcularDias() * valorDiaria;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + ", valor diária: R$" + valorDiaria + ", Disponível: " + (disponibilidade? "Disponível" : "Indisponível");
    }
}
