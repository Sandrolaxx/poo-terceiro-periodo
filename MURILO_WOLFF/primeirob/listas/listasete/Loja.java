package MURILO_WOLFF.primeirob.listas.listasete;

public class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private Vendedor[] vendedores;
    private Cliente[] clientes;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco,
                Vendedor[] vendedores, Cliente[] clientes) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.vendedores = vendedores;
        this.clientes = clientes;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Vendedor[] getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedor[] vendedores) {
        this.vendedores = vendedores;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int contarClientes() {
        return clientes.length;
    }

    public int contarVendedores() {
        return vendedores.length;
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("CNPJ: " + cnpj);
        endereco.apresentarLogradouro();
    }
}