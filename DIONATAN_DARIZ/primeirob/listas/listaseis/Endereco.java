package DIONATAN_DARIZ.primeirob.listas.listaseis;

public class Endereco {
    private String rua;
    private String bairro;
    private String estado;
    private String complemento;
    private int numero;

    public Endereco(String rua, String bairro, String estado, String complemento, int numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.estado = estado;
        this.complemento = complemento;
        this.numero = numero;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", " + numero + " - " + bairro + ", " + estado + " (" + complemento + ")");
    }
}
