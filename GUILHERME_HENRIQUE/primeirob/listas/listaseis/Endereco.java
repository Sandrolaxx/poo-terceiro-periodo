package GUILHERME_HENRIQUE.primeirob.listas.listaseis;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String complemento;
    public String apresentarLogradouro;

    public Endereco(String estado, String cidade, String bairro, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + numero + ", " + bairro + ", " + cidade + ", " + estado + " - " + complemento);
    }
}
