
class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Vendedor[] vendedores;
    private Cliente[] clientes;
    private Endereco endereco;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco){
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public void apresentarse(){
        System.out.println("Nome Fantasia: " + nomeFantasia + "\nRaz" + razaoSocial + "\nCNPJ: " + cnpj);
        this.endereco.apresentarLogradouro();
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
}