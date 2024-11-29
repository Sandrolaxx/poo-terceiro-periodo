package primeirob.listas.listaseis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Pedido> pedidos;
    private List<Pessoa> pessoas; // Lista de Pessoa, que pode ser Cliente ou Funcionario
    private List<Loja> lojas;
    private ProcessaPedido processaPedido;

    public Controller() {
        pedidos = new ArrayList<>();
        pessoas = new ArrayList<>();
        lojas = new ArrayList<>();
        processaPedido = new ProcessaPedido();

        // Carregar dados
        try {
            pedidos = DataManager.carregarPedidos("pedidos.dat");
            pessoas = DataManager.carregarPessoas("pessoas.dat");
            lojas = DataManager.carregarLojas("lojas.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }

        // Dados de teste (opcional)
        if (lojas.isEmpty()) {
            Endereco enderecoLoja = new Endereco("Av. Principal", 1000, "Centro", "São Paulo", "SP", "Loja 1");
            Loja loja = new Loja("Myy Plant", "Myy Plant Comércio de Plantas Ltda", "12.345.678/0001-90", enderecoLoja);
            lojas.add(loja);

            Endereco enderecoFuncionario = new Endereco("Rua das Flores", 123, "Bairro", "São Paulo", "SP", "");
            double[] salarioRecebido = {3000.0, 3100.0, 3200.0};
            Vendedor vendedor = new Vendedor("João Silva", 30, loja, enderecoFuncionario, 3000.0, salarioRecebido);
            pessoas.add(vendedor);
            loja.adicionarFuncionario(vendedor);

            Endereco enderecoCliente = new Endereco("Rua das Palmeiras", 456, "Jardins", "São Paulo", "SP", "");
            Cliente cliente = new Cliente("Carlos Pereira", 40, enderecoCliente);
            pessoas.add(cliente);
            loja.adicionarCliente(cliente);
        }
    }

    // Métodos para as funcionalidades
    public void cadastrarCliente(String nome, int idade, Endereco endereco) {
        Cliente cliente = new Cliente(nome, idade, endereco);
        pessoas.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void cadastrarFuncionario(String nome, int idade, int cargo, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        Funcionario funcionario;
        if (cargo == 1) {
            funcionario = new Vendedor(nome, idade, loja, endereco, salarioBase, salarioRecebido);
        } else if (cargo == 2) {
            funcionario = new Gerente(nome, idade, loja, endereco, salarioBase, salarioRecebido);
        } else {
            throw new IllegalArgumentException("Cargo inválido.");
        }
        pessoas.add(funcionario);
        loja.adicionarFuncionario(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void cadastrarLoja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        Loja loja = new Loja(nomeFantasia, razaoSocial, cnpj, endereco);
        lojas.add(loja);
        System.out.println("Loja cadastrada com sucesso!");
    }

    public void criarPedido(int id, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        Pedido pedido = processaPedido.processar(id, cliente, vendedor, loja, itens);
        pedidos.add(pedido);
        System.out.println("Pedido criado com sucesso!");
        pedido.gerarDescricaoVenda();
    }

    public void confirmarPagamento(int id) {
        Pedido pedido = encontrarPedidoPorId(id);
        if (pedido != null) {
            processaPedido.confirmarPagamento(pedido);
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Cliente) {
                clientes.add((Cliente) p);
            }
        }
        return clientes;
    }

    public List<Funcionario> getFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Funcionario) {
                funcionarios.add((Funcionario) p);
            }
        }
        return funcionarios;
    }

    public List<Loja> getLojas() {
        return lojas;
    }

    public List<Vendedor> getVendedores() {
        List<Vendedor> vendedores = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p instanceof Vendedor) {
                vendedores.add((Vendedor) p);
            }
        }
        return vendedores;
    }

    public Pedido encontrarPedidoPorId(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void salvarDados() {
        try {
            DataManager.salvarPedidos(pedidos, "pedidos.dat");
            DataManager.salvarPessoas(pessoas, "pessoas.dat");
            DataManager.salvarLojas(lojas, "lojas.dat");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public List<Item> createItens() {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Orquídea", "Flor", 50.0));
        itens.add(new Item(2, "Samambaia", "Planta", 30.0));
        itens.add(new Item(3, "Cacto", "Planta", 20.0));
        // Adicione mais itens se desejar
        return itens;
    }
}
