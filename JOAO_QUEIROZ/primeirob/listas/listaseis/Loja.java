package primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private String razaoSocial;
    private String nomeFantasia;
    private List<Vendedor> vendedor;
    private List<Cliente> cliente;

    public Loja(String cnpj, String rua, String bairro, String razaoSocial, String cidade, String nomeFantasia) {
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.nomeFantasia = nomeFantasia;
        this.rua = rua;
        this.bairro = bairro;
        this.razaoSocial = razaoSocial;
        this.vendedor = new ArrayList<>();
        this.cliente = new ArrayList<>();
    }

    public String getcidade() {
        return cidade;
    }
    
    public String getnomeFantasia() {
        return nomeFantasia;
    }
    

    public String getcnpj() {
        return cnpj;
    }

    public String getrua() {
        return rua;
    }

    public String isbairro() {
        return bairro;
    }

    public String getrazaoSocial(

    ) {
        return razaoSocial;

    }

    public void adicionarVendedor(Vendedor vendedores) {
        vendedor.add(vendedores);
    }

    public void adicionarCliente(Cliente clientes) {
        cliente.add(clientes);
    }

    public int contarClientes() {
        return cliente.size();
    }

    public int contarVendedores() {
        return vendedor.size();
    }


    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj + ", Endereço: " + cidade + ", " + bairro + ", " + rua);
    }
}