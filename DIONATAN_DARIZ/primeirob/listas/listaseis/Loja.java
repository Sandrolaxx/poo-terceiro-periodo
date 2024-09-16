package DIONATAN_DARIZ.primeirob.listas.listaseis;

public class Loja {
    private String nome;
    private String nomeFantasia;
    private String cnpj;
    private Endereco endereco;

    public Loja(String nome, String nomeFantasia, String cnpj, Endereco endereco) {
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
