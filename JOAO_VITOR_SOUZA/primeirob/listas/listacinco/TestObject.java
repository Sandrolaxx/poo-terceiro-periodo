package JOAO_VITOR_SOUZA.primeirob.listas.listacinco;

import java.util.ArrayList;

public class TestObject {

    public static void main(String[] args) {
        // Criar vendedores
        Vendedor vendedorUm = criarVendedor("Roberto", 30, "Myy Plant", "Cascavel", "14 de Novembro", "", 1200.00, new Double[]{1200.00, 1000.00, 5000.00});
        Vendedor vendedorDois = criarVendedor("Carlos", 40, "Myy Plant", "Cascavel", "14 de Novembro", "", 1500.00, new Double[]{1300.00, 1100.00, 5100.00});

        // Criar clientes
        Cliente clienteUm = criarCliente("Ana", "25", "Cascavel", "Centro", "Rua Paraná");
        Cliente clienteDois = criarCliente("Bruno", "30", "Cascavel", "Centro", "Rua São Paulo");

        // Criar loja
        Loja loja = criarLoja("Myy Plant", "Dona Gabrielinha Comércio de Plantas e Jardinagem Ltda", "50.138.228/0001-10", "Cascavel", "Centro", "Avenida Tancredo Neves");

        // Adicionar vendedores à loja
        loja.vendedores = new Vendedor[]{vendedorUm, vendedorDois};

        // Inicializar e adicionar clientes à loja
        loja.clientes = new ArrayList<>(); // Corrigido para ArrayList
        loja.clientes.add(clienteUm);
        loja.clientes.add(clienteDois);

        // Apresentar informações da loja
        loja.apresentarse();
        
        // Apresentar informações dos vendedores
        for (Vendedor vendedor : loja.vendedores) {
            vendedor.apresentarse();
            System.out.println("Média dos Salários Recebidos: " + String.format("%.2f", vendedor.calcularMedia()));
            System.out.println("Bônus: " + String.format("%.2f", vendedor.calcularBonus()));
        }
        
        // Apresentar informações dos clientes
        for (Cliente cliente : loja.clientes) {
            cliente.apresentarse();
        }
    }

    // Métodos estáticos para criar instâncias
    public static Vendedor criarVendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, Double salarioBase, Double[] salarioRecebido) {
        return new Vendedor(nome, idade, loja, cidade, bairro, rua, salarioBase, salarioRecebido);
    }

    public static Loja criarLoja(String nomeFantasia, String razaoSocial, String cnpj, String cidade, String bairro, String rua) {
        Loja loja = new Loja();
        loja.nomeFantasia = nomeFantasia;
        loja.razaoSocial = razaoSocial;
        loja.cnpj = cnpj;
        loja.cidade = cidade;
        loja.bairro = bairro;
        loja.rua = rua;
        loja.clientes = new ArrayList<>(); // Inicializa a lista de clientes
        return loja;
    }

    public static Cliente criarCliente(String nome, String idade, String cidade, String bairro, String rua) {
        Cliente cliente = new Cliente();
        cliente.nome = nome;
        cliente.idade = idade;
        cliente.cidade = cidade;
        cliente.bairro = bairro;
        cliente.rua = rua;
        return cliente;
    }
}
