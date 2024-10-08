package TIAGO_SOARES.primeirob.prova.classes;

import java.util.Date;
import java.util.UUID;

public class Quarto {
    private Integer id;
    private String name;
    private Date reservationDate;
    private Boolean available;
    private double valueDay;

    public Quarto(String name) {
        this.id = UUID.randomUUID().hashCode();
        this.valueDay = 100.0;
        this.name = name;
        this.available = true;
        this.reservationDate = new Date();
    }

    public Integer getNumber() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public double getValueDay() {
        return valueDay;
    }

    public void introduceRoom(){
        System.out.println("=== Quarto ===");
        System.out.println("ID: " + getNumber());
        System.out.println("Nome: " + getName());
        System.out.println("Valor diaria: " + getValueDay());
        System.out.println("Disponivel?: " + (available ? "Sim" : "Nao"));
    }
}
