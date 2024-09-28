package MATHEUS.primeirob.prova;

import java.util.Date;

public class Quarto {
    private int numero;
    private boolean disponivel;
    private float valorDiaria;
    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    private Date diaInicioReserva;
    private Date fimReserva;

    private Cliente cliente;

    
    public Quarto(int numero,boolean disponivel,float valorDiaria){
        this.numero = numero;
        this.disponivel = disponivel;
        this.valorDiaria = valorDiaria;
    }

    public static void listarQuarto(Quarto[] quartos){
        for (Quarto quarto : quartos) {
            if (quarto != null) {
                quarto.apresntaQuarto();
            }
        }
    }

    public void apresntaQuarto(){
        String disponibildade = "Indisponivel";
        if (disponivel) {
            disponibildade = "Disponivel";
        }
        System.out.println("Quarto Numero: " + numero + "\nDisponibilidade: " + disponibildade + " Valor da diaria: " + valorDiaria );
    }

    public int getNumero() {
        return numero;
    }
    public Date getDiaInicioReserva() {
        return diaInicioReserva;
    }
    public Date getFimReserva() {
        return fimReserva;
    }
    public void setFimReserva(Date fimReserva) {
        this.fimReserva = fimReserva;
    }
    public void setDiaInicioReserva(Date diaInicioReserva) {
        this.diaInicioReserva = diaInicioReserva;
    }
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
