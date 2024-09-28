package PEDRO_ACORDI.primeirobi.prova.src.entidades;

import java.util.Date;

public class Reserva {
    private Date inicio;
    private Date fim;
    private Cliente cliente;

    public Reserva(Date inicio, Date fim, Cliente cliente) {
        this.inicio = inicio;
        this.fim = fim;
        this.cliente = cliente;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFim() {
        return fim;
    }

    public Cliente getCliente() {
        return cliente;
    }


}
