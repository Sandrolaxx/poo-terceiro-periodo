package Arquivos.prova;

public class cadastroQuarto {
    
    private String numero;
    private String tipo;
    private boolean reservado;

    public cadastroQuarto (String numero, String tipo){

        this.numero = numero;
        this.tipo = tipo;

    }
    public String getnumero(){
        return numero;
    }
    public String gettipo(){
        return tipo;
    }

    public boolean isreservado() {
        return reservado;
    }

    public void Reservar() {
        this.reservado = true;
    }

    public void chekout() {
        this.reservado = false;
    }


}
