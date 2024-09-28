package GABRIEL_HEIDRICH.primeirob.prova;

import java.time.LocalDate;

public class Reserva {
    Cliente cliente;
    Quarto quarto;
    LocalDate dataCheckIn;
    LocalDate dataCheckOut;

    public Reserva(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, int dias) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckIn.plusDays(dias); 
        quarto.reservar();
    }

    public double calcularTotal() {
        return quarto.valorDiaria * (dataCheckOut.toEpochDay() - dataCheckIn.toEpochDay());
    }

    public void realizarCheckOut() {
        quarto.liberar();
    }

    public boolean verificaDisponibilidade(LocalDate data) {
        return data.isBefore(dataCheckIn) || data.isAfter(dataCheckOut);
    }
}
