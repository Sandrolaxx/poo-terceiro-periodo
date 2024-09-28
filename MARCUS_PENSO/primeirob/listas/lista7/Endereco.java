package MARCUS_PENSO.lista7;

public class Endereco {
    private String rua;
    private String cidade;
    private String bairro;

    public Endereco(String rua, String bairro, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", Bairro: " + bairro + ", Cidade: " + cidade);
    }
}
