package MURILO_WOLFF.primeirob.prova.sistemahotel.entidades;

import MURILO_WOLFF.primeirob.prova.sistemahotel.servicos.Reserva;

public class Quarto {
    private int numero;
    private int andar;
    private String tipo;
    private double valorDiaria;
    private Reserva[] reservas;
    private int totalReservas;
    private boolean disponivel;

    public Quarto(int numero, int andar, String tipo, double valorDiaria) {
        this.numero = numero;
        this.andar = andar;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
        this.reservas = new Reserva[100];
        this.totalReservas = 0;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public int getAndar() {
        return andar;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public int getTotalReservas() {
        return totalReservas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void adicionarReserva(Reserva reserva) {
        if (totalReservas < 100) {
            reservas[totalReservas++] = reserva;
        } else {
            System.out.println("Capacidade máxima de reservas atingida.");
        }
    }

    public void apresentarQuarto() {
        System.out.println("Quarto: " + numero);
        System.out.println("Andar: " + andar);
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor da diária: " + valorDiaria);
    }
}