
package primeirob.listas.listasete;
// Loja.java

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Loja implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private List<Funcionario> funcionarios; // Lista de funcionários
    private List<Cliente> clientes;         // Lista de clientes

    // Construtor
    public Loja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    // Métodos para adicionar funcionários e clientes
    public void adicionarFuncionario(Funcionario funcionario) {
        if (funcionario != null) {
            funcionarios.add(funcionario);
            funcionario.setLoja(this); // Atualiza a referência da loja no funcionário
        }
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
        }
    }

    // Método para apresentar-se
    public void apresentarSe() {
        System.out.println("Nome Fantasia: " + nomeFantasia);
        System.out.println("Razão Social: " + razaoSocial);
        System.out.println("CNPJ: " + cnpj);
        if (endereco != null) {
            endereco.apresentarLogradouro();
        }
        System.out.println("Número de Funcionários: " + funcionarios.size());
        System.out.println("Número de Clientes: " + clientes.size());
    }

    // Métodos para contar clientes e funcionários
    public int contarClientes() {
        return clientes.size();
    }

    public int contarFuncionarios() {
        return funcionarios.size();
    }

    // Getters e Setters

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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Loja{" +
               "nomeFantasia='" + nomeFantasia + '\'' +
               ", razaoSocial='" + razaoSocial + '\'' +
               ", cnpj='" + cnpj + '\'' +
               ", endereco=" + endereco +
               ", funcionarios=" + funcionarios.size() +
               ", clientes=" + clientes.size() +
               '}';
    }
}
