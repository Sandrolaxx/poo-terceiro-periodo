package GUILHERME_HENRIQUE.primeirob.prova;

import java.util.Date;

public class Reserva {
    private int numeroQuarto;
    private String cpfCliente;
    private Date dataCheckIn;
    private Date dataCheckOut;

    public Reserva(int numeroQuarto, String cpfCliente, Date dataCheckIn, Date dataCheckOut) {
        this.numeroQuarto = numeroQuarto;
        this.cpfCliente = cpfCliente;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public Date getDataCheckIn() {
        return dataCheckIn;
    }

    public Date getDataCheckOut() {
        return dataCheckOut;
    }
}
