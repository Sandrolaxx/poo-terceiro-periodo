package VINICIUS_PASCOATO.primeirob.listas.listasete;

import java.util.ArrayList;

public class Loja {
    private String nomeFantasia;
    private Endereco endereco;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Cliente> clientes;

    public Loja(String nomeFantasia, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionaVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarInformacoes() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        endereco.apresentarLogradouro();
    }
}
