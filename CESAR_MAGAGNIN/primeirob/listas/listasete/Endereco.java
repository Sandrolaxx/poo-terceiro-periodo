package CESAR_MAGAGNIN.primeirob.listas.listasete;

import java.io.Serializable;

public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;

    // Construtor
    public Endereco(String rua, int numero, String bairro, String cidade, String estado, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }

    // Método para apresentar o logradouro
    public void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", " + numero + ", " + bairro + ", " + cidade + ", " + estado + ". " + complemento);
    }

    // Getters e Setters

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    // Método toString (opcional, para facilitar a exibição do endereço)
    @Override
    public String toString() {
        return "Endereço: " + rua + ", " + numero + ", " + bairro + ", " + cidade + ", " + estado + ". " + complemento;
    }
}
