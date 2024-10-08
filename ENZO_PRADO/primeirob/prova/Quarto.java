package ENZO_PRADO.primeirob.prova;

public class Quarto {

    private int numero;

    private int tipoQuarto;

    private double valor;

    private int qtdCama;


    private boolean disponivel = true;

    public Quarto(int numero, int tipoQuarto, int qtdCama, double valor){
        this.numero = numero;
        this.tipoQuarto = tipoQuarto;
        this.qtdCama = qtdCama;
        this.valor = valor;
    }
    

    public int getNumero(){
        return numero;
    }

    public int getTipodeDoQuarto(){
        return tipoQuarto;
    }

    public int getQtdCama(){
        return qtdCama;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    public double getValor(){
    return valor;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setTipoQuarto(int tipoQuarto){

        this.tipoQuarto = tipoQuarto;
    }

    public void setQtdCama(int qtdCama){
        this.qtdCama = qtdCama;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public void setValor(double valor){
        this.valor = valor;
    }


}
