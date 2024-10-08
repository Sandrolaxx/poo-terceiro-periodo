package CESAR_MAGAGNIN.primeirob.provaeu;

public class Endereco {
    private String rua;
    private String numero; // pode conter letra
    private String bairro;
    private String cidade;
    private String estado;
    
    public Endereco(String rua, String numero, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        }        

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", " + numero + ", " + bairro + ", " + cidade + " - " + estado);
    }
}

