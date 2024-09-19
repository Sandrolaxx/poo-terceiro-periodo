package ROBSON_DE_LIMA.primeirob.listas.listaSeis;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String numero;
    private String rua;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String numero, String rua, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.rua = rua;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", Bairro: " + bairro + ", Cidade: " + cidade + ", Estado: " + estado + ", Complemento: " + complemento);
    }
}
