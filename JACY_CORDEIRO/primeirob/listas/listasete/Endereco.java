//package poo_terceiro_periodo.JACY_CORDEIRO.primeirob.listas.listasete;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String numero;
    private String complemento;
    private String rua;

    // Construtor da classe Endereco
    public Endereco(String estado, String cidade, String bairro, String numero, String complemento, String rua) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.rua = rua;
    }

    // Método para apresentar o logradouro de forma formatada
    public void apresentarLogradouro() {
        System.out.println("Endereço: " + rua + ", " + numero + " - " + bairro + ", " + cidade + ", " + estado
                           + (complemento.isEmpty() ? "" : " - " + complemento)); // Adiciona o complemento se não estiver vazio
    }

    // Métodos get para dicionários
    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getRua() {
        return rua;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
