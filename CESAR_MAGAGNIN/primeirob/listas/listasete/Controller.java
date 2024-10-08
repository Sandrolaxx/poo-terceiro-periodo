package CESAR_MAGAGNIN.primeirob.listas.listasete;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements Serializable {
    private static final long serialVersionUID = 1L; // Para suporte a serialização

    private List<Pedido> pedidos;
    private List<Pessoa> pessoas; // Lista de Pessoa, que pode ser Cliente ou Funcionario
    private List<Item> itens;
    private List<Loja> lojas;
    private transient Scanner scanner; // Não precisa ser serializado

    private final String FILE_PATH = "dados"; // Caminho para o arquivo de dados

    public Controller() {
        this.pedidos = new ArrayList<>();
        this.pessoas = new ArrayList<>();
        this.itens = new ArrayList<>();
        this.lojas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        carregarDados(); // Carregar dados ao inicializar
    }

    // Método para salvar todos os dados
    public void salvarDados() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(pedidos);
            oos.writeObject(pessoas);
            oos.writeObject(itens);
            oos.writeObject(lojas);
            oos.close();
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    // Método para carregar todos os dados
    @SuppressWarnings("unchecked")
    public void carregarDados() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            pedidos = (List<Pedido>) ois.readObject();
            pessoas = (List<Pessoa>) ois.readObject();
            itens = (List<Item>) ois.readObject();
            lojas = (List<Loja>) ois.readObject();
            ois.close();
            System.out.println("Dados carregados com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum dado salvo encontrado. Iniciando com listas vazias.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }

    // Métodos para adicionar e buscar clientes, funcionários, itens, etc.

    public void cadastrarCliente(String nome, int idade, Endereco endereco) {
        Cliente cliente = new Cliente(nome, idade, endereco);
        pessoas.add(cliente);
    }

    public void cadastrarFuncionario(String nome, int idade, int cargo, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        Funcionario funcionario;
        if (cargo == 1) { 
            funcionario = new Vendedor(nome, idade, loja, endereco, salarioBase, salarioRecebido);
        } else { 
            funcionario = new Gerente(nome, idade, loja, endereco, salarioBase, salarioRecebido);
        }
        pessoas.add(funcionario);
    }

    public void cadastrarLoja(String nomeFantasia, String razaoSocial, String cnpj, Endereco endereco) {
        Loja loja = new Loja(nomeFantasia, razaoSocial, cnpj, endereco);
        lojas.add(loja);
    }

    public void criarPedido(int id, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itensPedido) {
        Pedido pedido = new Pedido(id, cliente, vendedor, itensPedido);
        pedidos.add(pedido);
    }

    public void cadastrarItem(int id, String nome, String tipo, double valor) {
        Item item = new Item(id, nome, tipo, valor);
        itens.add(item);
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Cliente && pessoa.getNome().equalsIgnoreCase(nome)) {
                return (Cliente) pessoa;
            }
        }
        return null;
    }

    public Vendedor buscarVendedorPorNome(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Vendedor && pessoa.getNome().equalsIgnoreCase(nome)) {
                return (Vendedor) pessoa;
            }
        }
        return null;
    }

    public List<Loja> getLojas() {
        return lojas;
    }

    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Cliente) {
                clientes.add((Cliente) pessoa);
            }
        }
        return clientes;
    }

    public List<Vendedor> getVendedores() {
        List<Vendedor> vendedores = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Vendedor) {
                vendedores.add((Vendedor) pessoa);
            }
        }
        return vendedores;
    }

    public List<Funcionario> getFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Funcionario) {
                funcionarios.add((Funcionario) pessoa);
            }
        }
        return funcionarios;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Item> createItens() {
        return itens;
    }

    public Item buscarItemPorNome(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    // Método para confirmar o pagamento de um pedido
    public void confirmarPagamento(int id) {
        Pedido pedido = buscarPedidoPorId(id);
        if (pedido != null) {
            // Lógica para confirmar o pagamento
            System.out.println("Pagamento confirmado para o pedido: " + pedido.getId());
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    // Método para buscar pedido por ID
    private Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    // Método para exibir o menu principal e lidar com as opções
    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastro de itens");
            System.out.println("2. Listar itens");
            System.out.println("3. Buscar item por nome");
            System.out.println("4. Criar pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome o newline

            switch (opcao) {
                case 1:
                    int id = 1; // Exemplo de valor de ID
                    String nomeitem = "Produto Exemplo";
                    String tipo = "Categoria Exemplo";
                    double valor = 100.0;
                    cadastrarItem(id, nomeitem, tipo, valor);
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    System.out.print("Digite o nome do item para buscar: ");
                    String nome = scanner.nextLine();
                    Item item = buscarItemPorNome(nome);
                    if (item != null) {
                        System.out.println("Item encontrado: " + item);
                    } else {
                        System.out.println("Item não encontrado.");
                    }
                    break;
                case 4:
                    criarPedido(); // Agora este método coleta todas as informações necessárias
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    // Método para criar um pedido coletando todas as informações necessárias
public void criarPedido() {
    try {
        System.out.print("Informe o ID do Pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a linha após o int

        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = buscarClientePorNome(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Nome do vendedor: ");
        String nomeVendedor = scanner.nextLine();
        Vendedor vendedor = buscarVendedorPorNome(nomeVendedor);
        if (vendedor == null) {
            System.out.println("Vendedor não encontrado.");
            return;
        }

        System.out.print("Nome da loja: ");
        String nomeLoja = scanner.nextLine();
        Loja loja = null;
        for (Loja l : lojas) {
            if (l.getNomeFantasia().equalsIgnoreCase(nomeLoja)) {
                loja = l;
                break;
            }
        }
        if (loja == null) {
            System.out.println("Loja não encontrada.");
            return;
        }

        List<Item> itensPedido = new ArrayList<>();
        String continuar;
        do {
            System.out.print("Nome do item que deseja adicionar ao pedido: ");
            String nomeItem = scanner.nextLine();
            Item item = buscarItemPorNome(nomeItem); 
            if (item != null) {
                itensPedido.add(item);
                System.out.println("Item adicionado ao pedido.");
            } else {
                System.out.println("Item não encontrado.");
            }

            System.out.print("Deseja adicionar outro item? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        if (!itensPedido.isEmpty()) {
            criarPedido(id, cliente, vendedor, loja, itensPedido); // Chamando o método sobrecarregado
            System.out.println("Pedido criado com sucesso!");
        } else {
            System.out.println("Nenhum item adicionado ao pedido. Pedido não criado.");
        }
    } catch (Exception e) {
        System.out.println("Erro ao criar pedido: " + e.getMessage());
        scanner.nextLine(); // Consome a linha após erro
    }
}


    // Método para listar todos os itens cadastrados
    private void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            System.out.println("\n--- Lista de Itens ---");
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }
}
