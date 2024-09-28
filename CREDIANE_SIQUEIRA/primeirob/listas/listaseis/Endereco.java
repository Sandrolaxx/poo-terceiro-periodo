package CREDIANE_SIQUEIRA.primeirob.listas.listaseis;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        String logradouro = "Endereço: " + rua + ", Bairro: " + bairro + ", Cidade: " + cidade + ", Estado: " + estado;
        if (!complemento.isEmpty()) {
            logradouro += ", Complemento: " + complemento;
        }
        System.out.println(logradouro);
    }
}
