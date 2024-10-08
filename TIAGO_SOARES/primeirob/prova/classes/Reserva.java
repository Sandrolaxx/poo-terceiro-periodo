package TIAGO_SOARES.primeirob.prova.classes;

import java.util.Date;
import java.util.UUID;

public class Reserva {
    private String id;
    private Date date;
    private double value;
    private Cliente cliente;
    private Quarto quarto;

    public Reserva(Quarto quarto, Date date, double value, Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.value = value;
        this.cliente = cliente;
        this.quarto = quarto;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public double getValue() {
        return value;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public void exibeReserva() {
        System.out.println("=== Reserva ===");
        System.out.println("ID: " + getId());
        System.out.println("Data: " + getDate());
        System.out.println("Valor: R$" + getValue());
        System.out.println("Cliente: " + getCliente().getName());
        System.out.println("Quarto: " + getQuarto().getName());
    }
}
