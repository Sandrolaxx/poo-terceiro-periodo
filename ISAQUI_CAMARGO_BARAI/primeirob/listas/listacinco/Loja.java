package ISAQUI_CAMARGO_BARAI.primeirob.listas.listacinco;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    List<Vendedor> vendedores;
    List<Cliente> clientes;

    // Construtor
    public Loja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    // Método para contar a quantidade de clientes
    public int contarClientes() {
        return clientes.size();
    }

    // Método para contar a quantidade de vendedores
    public int contarVendedores() {
        return vendedores.size();
    }

    // Método para se apresentar
    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj);
        System.out.println("Endereço: " + rua + ", " + bairro + ", " + cidade);
    }

    // Método para adicionar um vendedor
    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    // Método para adicionar um cliente
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
}
