package ERICK_SCUR.primeirob.prova.src;

import java.util.Date;

public class Reserva {
    private int id;
    private Quarto quarto;
    private Date dataCheckin;
    private Date dataCheckout;
    private Cliente cliente;
    private StatusReserva status;

    public Reserva(int id, Cliente cliente, Quarto quarto, Date dataCheckin, Date dataCheckout) {
        this.id = id;
        this.quarto = quarto;
        this.cliente = cliente;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.status = StatusReserva.CONFIRMADA;
    }

    public int getId() {
        return id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Date getDataCheckin() {
        return dataCheckin;
    }

    public Date getDataCheckout() {
        return dataCheckout;
    }

    public double calcularValorReserva () {
        long diferenca = dataCheckout.getTime() - dataCheckin.getTime();
        long dias = diferenca / (1000 * 60 * 60 * 24);
        return dias * quarto.getPrecoDiaria();
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void checkout() {
        if (status == StatusReserva.CHECKOUT_REALIZADO) {
            System.out.println("Checkout já realizado");
            return;
        }

//        PS: Vou deixar essa validação comentada para testar o código sem precisar esperar a data
//        if (this.dataCheckout.after(new Date())) {
//            System.out.println("Checkout não pode ser realizado antes da data de checkout");
//            return;
//        }

        this.status = StatusReserva.CHECKOUT_REALIZADO;
    }

    public void checkin() {
        if (status == StatusReserva.CHECKIN_REALIZADO) {
            System.out.println("Checkin já realizado");
            return;
        }

//        PS: Vou deixar essa validação comentada para testar o código sem precisar esperar a data
//        if (this.dataCheckin.after(new Date())) {
//            System.out.println("Checkin não pode ser realizado antes da data de checkin");
//            return;
//        }

        this.status = StatusReserva.CHECKIN_REALIZADO;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", quarto=" + quarto + ", dataCheckin=" + dataCheckin + ", dataCheckout=" + dataCheckout + ", cliente=" + cliente + ", status=" + status + '}';
    }
}
