package ENZO_PRADO.primeirob.listas.listasete;

import java.util.ArrayList;

public class Loja {

    private Endereco endereco;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;

    private ArrayList<Vendedor> vendedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Gerente> gerentes = new ArrayList<>();

    public Loja(Endereco endereco, String nomeFantasia, String razaoSocial, String cnpj) {
        this.endereco = endereco;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    void apresentarse() {
        System.out.println("Nome fantasia: " + nomeFantasia + "\nCNPJ: " + cnpj);
        endereco.apresentarLogradouro();
    }

    void contarClientes() {
        System.out.println("A quantidade de clientes da loja são: " + clientes.size());
    }

    void contarVendedores() {
        System.out.println("A quantidade de vendedores da loja são: " + vendedores.size());
    }
    
    void contarGerentes() {
        System.out.println("A quantidade de gerentes da loja são: " + gerentes.size());
    }

    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public void adicionarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        } else {
            System.out.println("Cliente já cadastrado.");
        }
    }

    public void adicionarVendedor(Vendedor vendedor) {
        if (!vendedores.contains(vendedor)) {
            vendedores.add(vendedor);
        } else {
            System.out.println("Vendedor já cadastrado.");
        }
    }

    public void adicionarGerente(Gerente gerente) {
        if (!gerentes.contains(gerente)) {
            gerentes.add(gerente);
        } else {
            System.out.println("Gerente já cadastrado.");
        }
    }

    @Override
    public String toString() {
        return "Loja{" +
                "nomeFantasia='" + nomeFantasia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
