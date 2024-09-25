package primeirob.listas.lista5;

import java.util.ArrayList;
import java.util.List;

class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private double salarioBase;
    private List<Double> salariosRecebidos;

    public Vendedor(String nome, int idade, String loja, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();
        // Adiciona alguns salários recebidos
        this.salariosRecebidos.add(3000.0);
        this.salariosRecebidos.add(3200.0);
        this.salariosRecebidos.add(3100.0);
    }

    public String getNome() {
        return nome;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return salariosRecebidos.size() > 0 ? soma / salariosRecebidos.size() : 0;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

// Classe Cliente
class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

// Classe Loja
class Loja {
    private String nomeFantasia;
    private String cnpj;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;

    public Loja(String nomeFantasia, String cnpj) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.vendedores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void contarClientes() {
        System.out.println("Número de clientes: " + clientes.size());
    }

    public void contarVendedores() {
        System.out.println("Número de vendedores: " + vendedores.size());
    }

    public void apresentarse() {
        System.out.println("Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj);
    }
}
