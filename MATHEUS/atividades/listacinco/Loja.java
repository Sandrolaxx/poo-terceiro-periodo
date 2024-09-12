
class Loja {
    public String nomeFantasia;
    public String razaoSocial;
    public String cnpj;
    public Vendedor[] vendedores;
    public Cliente[] clientes;
    public Endereco endereco;

    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco){
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public void apresentarse(){
        System.out.println("Nome Fantasia: " + nomeFantasia + "\nRaz" + razaoSocial + "\nCNPJ: " + cnpj);
        this.endereco.apresentarse();
    }
}