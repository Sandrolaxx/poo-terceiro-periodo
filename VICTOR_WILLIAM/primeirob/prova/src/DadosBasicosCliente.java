package VICTOR_WILLIAM.primeirob.prova.src;

public class DadosBasicosCliente {

    private String primeiroNomeCliente;
    private String segundoNomeCliente;
    private int idadeCliente;



    public DadosBasicosCliente(String primeiroNomeCliente, String segundoNomeCliente, int idadeCliente) {
        this.primeiroNomeCliente = primeiroNomeCliente;
        this.segundoNomeCliente = segundoNomeCliente;
        this.idadeCliente = idadeCliente;
    }



    public String getPrimeiroNomeCliente() {
        return primeiroNomeCliente;
    }

    public String getSegundoNomeCliente() {
        return segundoNomeCliente;
    }

    public int getIdadeCliente() {
        return idadeCliente;
    }


}
