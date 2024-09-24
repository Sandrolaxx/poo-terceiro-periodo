package ENZO_PRADO.primeirob.listas.listasete;

public class Endereco {

    private String estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String complemento;
    private String rua;

   
    public Endereco(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.rua = rua;
    }

   
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    
    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getRua() {
        return rua;
    }

   
    void apresentarLogradouro() {
        System.out.println("Estado: ".concat(estado)
                          .concat(", Cidade: ").concat(cidade)
                          .concat(", Bairro: ").concat(bairro)
                          .concat(", Rua: ").concat(rua)
                          .concat(", Numero: ") + numero +
                          (", Complemento: ").concat(complemento));
    }
}
