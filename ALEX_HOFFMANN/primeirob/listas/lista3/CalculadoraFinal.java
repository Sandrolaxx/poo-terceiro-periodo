package ALEX_HOFFMANN.primeirob.listas.lista3;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraFinal {

    public static void main(String[] args) {
        // Criando a loja
        Loja myyPlant = new Loja("Myy Plant", "Myy Plant Comércio de Plantas LTDA", "12.345.678/0001-90",
                "São Paulo", "Centro", "Rua da Flores, 123");

        // Criando os vendedores
        Vendedor vendedor1 = new Vendedor("João Silva", 30, myyPlant, "São Paulo", "Centro", "Rua da Flores, 123", 2500);
        vendedor1.salarioRecebido.add(2500.0);
        vendedor1.salarioRecebido.add(2700.0);
        vendedor1.salarioRecebido.add(2800.0);

        Vendedor vendedor2 = new Vendedor("Maria Santos", 28, myyPlant, "São Paulo", "Centro", "Rua das Flores, 456", 2800);
        vendedor2.salarioRecebido.add(2800.0);
        vendedor2.salarioRecebido.add(3000.0);
        vendedor2.salarioRecebido.add(3200.0);

        // Criando o cliente
        Cliente cliente1 = new Cliente("Pedro Oliveira", 35, "São Paulo", "Centro", "Rua das Flores, 789");

        // Adicionando vendedores e clientes à loja
        myyPlant.vendedores.add(vendedor1);
        myyPlant.vendedores.add(vendedor2);
        myyPlant.clientes.add(cliente1);

        // Apresentação da loja
        myyPlant.apresentarse();

        // Apresentação dos vendedores
        System.out.println("\nVendedores:");
        for (Vendedor vendedor : myyPlant.vendedores) {
            vendedor.apresentarse();
            System.out.printf("Salário base: R$ %.2f\n", vendedor.salarioBase);
            System.out.printf("Média dos salários recebidos: R$ %.2f\n", vendedor.calcularMedia());
            System.out.printf("Bônus: R$ %.2f\n", vendedor.calcularBonus());
        }

        // Apresentação do cliente
        System.out.println("\nClientes:");
        cliente1.apresentarse();

        // Contagem de clientes e vendedores
        System.out.printf("\nQuantidade de clientes: %d\n", myyPlant.contarClientes());
        System.out.printf("Quantidade de vendedores: %d\n", myyPlant.contarVendedores());
    }
}

class Vendedor {
    String nome;
    int idade;
    Loja loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
    }

    public void apresentarse() {
        System.out.printf("Olá, meu nome é %s, tenho %d anos e trabalho na loja %s.\n", nome, idade, loja.nomeFantasia);
    }

    public double calcularMedia() {
        if (salarioRecebido.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}

class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public void apresentarse() {
        System.out.printf("Meu nome é %s, tenho %d anos.\n", nome, idade);
    }
}

class Loja {
    String nomeFantasia;
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    List<Vendedor> vendedores;
    List<Cliente> clientes;

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

    public int contarClientes() {
        return clientes.size();
    }

    public int contarVendedores() {
        return vendedores.size();
    }

    public void apresentarse() {
        System.out.printf("A loja %s (CNPJ: %s) está localizada em %s, %s, %s.\n", nomeFantasia, cnpj, cidade, bairro, rua);
    }
}
