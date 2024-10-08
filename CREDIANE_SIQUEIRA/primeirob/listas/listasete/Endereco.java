package CREDIANE_SIQUEIRA.primeirob.listas.listasete;

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

    // Getters e Setters para encapsulamento
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void apresentarLogradouro() {
        String logradouro = "Endereço: " + rua + ", Bairro: " + bairro + ", Cidade: " + cidade + ", Estado: " + estado;
        if (complemento != null && !complemento.isEmpty()) {
            logradouro += ", Complemento: " + complemento;
        }
        System.out.println(logradouro);
    }
}
