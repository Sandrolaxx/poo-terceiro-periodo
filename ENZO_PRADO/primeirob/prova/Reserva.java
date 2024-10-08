package ENZO_PRADO.primeirob.prova;

import java.util.Date;

public class Reserva {

    private Cliente cliente;
    private Quarto quarto;
    private Date  dataEntrada;
    private Date  dataSaida;
    
    public Reserva( Cliente cliente, Quarto quarto, Date dataEntrada, Date dataSaida){
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
    }


    private long calcularDiarias(Date dataInicio, Date dataFinal){
        long diferencaMilissegundos = dataFinal.getTime() - dataInicio.getTime();
            return diferencaMilissegundos / (1000 * 60 * 60 * 24); 
    }

    public boolean checkout(Date dataSaida, Date dataEntrada){
        double total;
        long diasHospedados = calcularDiarias(dataEntrada, dataSaida);
        total = diasHospedados * quarto.getValor();

        System.out.println(" valor total da hospedagem é: R$ " + total);
        quarto.setDisponivel(true);
        return true;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Quarto getQuarto(){
        return quarto;
    }

    public Date getDataSaida(){
        return dataSaida;
    }
    public Date getDataEntrada(){
        return dataEntrada;
    }

}
