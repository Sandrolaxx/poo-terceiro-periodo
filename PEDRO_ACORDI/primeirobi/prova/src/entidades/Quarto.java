package PEDRO_ACORDI.primeirobi.prova.src.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import PEDRO_ACORDI.primeirobi.prova.src.util.ArrayUtil;
import PEDRO_ACORDI.primeirobi.prova.src.util.DateUtil;

public class Quarto {

    private int numero;
    private String descricao;
    private double valorPorNoite;
    private Reserva[] reservas;

    public Quarto(int numero, String descricao, double valorPorNoite) {
        this.numero = numero;
        this.descricao = descricao;
        this.valorPorNoite = valorPorNoite;
        this.reservas = new Reserva[0];
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorPorNoite() {
        return valorPorNoite;
    }

    public void setValorPorNoite(double valorPorNoite) {
        this.valorPorNoite = valorPorNoite;
    }

    private boolean isDisponivelNaData(Date data) {
        for(int i = 0; i<reservas.length; i++) {
            if( data.after(reservas[i].getInicio()) && data.before(reservas[i].getFim()) ) {
                return false;
            }
        }
        return true;
    }

    private boolean isDisponivelNoPeriodo(Date inicio, Date fim){
        Date dataAtual = new Date(inicio.getTime());
        while(dataAtual.before(fim)) {
            if(!isDisponivelNaData(dataAtual)) {
                return false;
            }
            dataAtual = new Date(dataAtual.getTime() + DateUtil.DIA);
        }
        return true;
    }

    public boolean reservarQuarto(Reserva reserva) {
        if(!isDisponivelNoPeriodo(reserva.getInicio(), reserva.getFim())) return false;

        this.reservas = ArrayUtil.adicionar(reservas, reserva);
        return true;
    }

    public void listarReservas(){
        if(this.reservas.length == 0){
            System.out.println("Nenhuma reserva encontrada");
            return;
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("-------- R E S E R V A S --------");
        for (int i = 0; i < reservas.length; i++) {
            System.out.println( Integer.toString(i+1)
                    .concat(". ")
                    .concat(reservas[i].getCliente().getNome()+": "+
                            formato.format(reservas[i].getInicio())
                            +" - " +
                            formato.format(reservas[i].getFim()))
            );
        }
        System.out.println("-------- F I M --------");
    }

    public void removerReserva(int numero){
        reservas[numero-1] = null;
    }

    public Reserva encontrarReserva(int numero){
        return reservas[numero-1];
    }

    public double calcularValorReserva(Reserva reserva) {
        Date inicio = reserva.getInicio();
        Date fim = reserva.getFim();
        long diferencaMilissegundos = fim.getTime() - inicio.getTime();

        long numeroDeNoites = diferencaMilissegundos / DateUtil.DIA;

        return numeroDeNoites * valorPorNoite;
    }

}
