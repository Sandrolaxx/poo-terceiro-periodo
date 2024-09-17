package ERICK_SCUR.primeirob.listas.lista6;

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}
