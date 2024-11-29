package primeirob.listas.listaSeis;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        System.out.printf("Endereço: %s, %s, %s, %s, %s - %s%n", rua, numero, bairro, cidade, estado, complemento);
    }
}
