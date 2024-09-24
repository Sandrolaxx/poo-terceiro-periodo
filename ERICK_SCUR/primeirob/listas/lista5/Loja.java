package ERICK_SCUR.primeirob.listas.lista5;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Loja {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String cidade;
    private String bairro;
    private String rua;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void adicionaVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void contarClientes() {
        JOptionPane.showMessageDialog(null, "Quantidade de clientes: " + clientes.size());
    }

    public void contarVendedores() {
        JOptionPane.showMessageDialog(null, "Quantidade de vendedores: " + vendedores.size());
    }

    public void apresentarse() {
        JOptionPane.showMessageDialog(null, "Nome Fantasia: " + nomeFantasia + "\nCNPJ: " + cnpj + "\nEndereço: " + cidade + ", " + bairro + ", " + rua);
    }
}
