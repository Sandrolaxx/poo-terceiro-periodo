package CESAR_MAGAGNIN.primeirob.listas.listaseis;
// Calculadora.java

import java.util.*;
import java.io.IOException;

public class Calculadora {
    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Loja> lojas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static ProcessaPedido processaPedido = new ProcessaPedido();

    public static void main(String[] args) {
        try {
            // Carregar dados persistidos
            pedidos = DataManager.carregarPedidos("pedidos.dat");
            clientes = DataManager.carregarClientes("clientes.dat");
            funcionarios = DataManager.carregarFuncionarios("funcionarios.dat");
            lojas = DataManager.carregarLojas("lojas.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }

        int opcao = 0;

        do {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    criarPedido();
                    break;
                case 2:
                    confirmarPagamento();
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    listarFuncionarios();
                    break;
                case 6:
                    cadastrarCliente();
                    break;
                case 7:
                    cadastrarFuncionario();
                    break;
                case 8:
                    cadastrarLoja();
                    break;
                case 9:
                    System.out.println("Saindo do sistema.");
                    // Salvar dados antes de sair
                    salvarDados();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 9);
    }

    // Método para exibir o menu
    private static void exibirMenu() {
        System.out.println("=== Sistema de Pedidos ===");
        System.out.println("[1] - Criar Pedido");
        System.out.println("[2] - Confirmar Pagamento de Pedido");
        System.out.println("[3] - Listar Pedidos");
        System.out.println("[4] - Listar Clientes");
        System.out.println("[5] - Listar Funcionários");
        System.out.println("[6] - Cadastrar Cliente");
        System.out.println("[7] - Cadastrar Funcionário");
        System.out.println("[8] - Cadastrar Loja");
        System.out.println("[9] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Métodos de cadastro
    private static void cadastrarCliente() {
        try {
            System.out.print("Nome do Cliente: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());

            Endereco endereco = criarEndereco();
            if (endereco == null) {
                System.out.println("Endereço inválido. Cadastro cancelado.");
                return;
            }

            Cliente cliente = new Cliente(nome, idade, endereco);
            clientes.add(cliente);

            System.out.println("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    private static void cadastrarFuncionario() {
        try {
            System.out.print("Nome do Funcionário: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());

            System.out.print("Cargo (1- Vendedor, 2- Gerente): ");
            int cargo = Integer.parseInt(scanner.nextLine());

            Loja loja = selecionarLoja();
            if (loja == null) {
                System.out.println("Loja não encontrada.");
                return;
            }

            Endereco endereco = criarEndereco();
            if (endereco == null) {
                System.out.println("Endereço inválido. Cadastro cancelado.");
                return;
            }

            System.out.print("Salário Base: ");
            double salarioBase = Double.parseDouble(scanner.nextLine());

            double[] salarioRecebido = new double[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Salário recebido mês " + (i + 1) + ": ");
                salarioRecebido[i] = Double.parseDouble(scanner.nextLine());
            }

            Funcionario funcionario;
            if (cargo == 1) {
                funcionario = new Vendedor(nome, idade, loja, endereco, salarioBase, salarioRecebido);
            } else if (cargo == 2) {
                funcionario = new Gerente(nome, idade, loja, endereco, salarioBase, salarioRecebido);
            } else {
                System.out.println("Cargo inválido.");
                return;
            }

            funcionarios.add(funcionario);
            loja.adicionarFuncionario(funcionario);

            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    private static void cadastrarLoja() {
        try {
            System.out.print("Nome Fantasia: ");
            String nomeFantasia = scanner.nextLine();

            System.out.print("Razão Social: ");
            String razaoSocial = scanner.nextLine();

            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();

            Endereco endereco = criarEndereco();
            if (endereco == null) {
                System.out.println("Endereço inválido. Cadastro cancelado.");
                return;
            }

            Loja loja = new Loja(nomeFantasia, razaoSocial, cnpj, endereco);
            lojas.add(loja);

            System.out.println("Loja cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar loja: " + e.getMessage());
        }
    }

    private static Endereco criarEndereco() {
        try {
            System.out.print("Rua: ");
            String rua = scanner.nextLine();

            System.out.print("Número: ");
            int numero = Integer.parseInt(scanner.nextLine());

            System.out.print("Bairro: ");
            String bairro = scanner.nextLine();

            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();

            System.out.print("Estado: ");
            String estado = scanner.nextLine();

            System.out.print("Complemento: ");
            String complemento = scanner.nextLine();

            return new Endereco(rua, numero, bairro, cidade, estado, complemento);
        } catch (Exception e) {
            System.out.println("Erro ao criar endereço: " + e.getMessage());
            return null;
        }
    }

    // Métodos para criar pedido, confirmar pagamento, listar pedidos, clientes, funcionários

    private static void criarPedido() {
        try {
            System.out.print("Informe o ID do Pedido: ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id <= 0) {
                System.out.println("ID deve ser um número positivo.");
                return;
            }

            Cliente cliente = selecionarCliente();
            if (cliente == null) {
                System.out.println("Cliente não encontrado.");
                return;
            }

            Vendedor vendedor = selecionarVendedor();
            if (vendedor == null) {
                System.out.println("Vendedor não encontrado.");
                return;
            }

            Loja loja = vendedor.getLoja();
            if (loja == null) {
                System.out.println("Vendedor não está associado a nenhuma loja.");
                return;
            }

            List<Item> itens = selecionarItens();
            if (itens.isEmpty()) {
                System.out.println("Nenhum item selecionado.");
                return;
            }

            Pedido pedido = processaPedido.processar(id, cliente, vendedor, loja, itens);
            pedidos.add(pedido);

            System.out.println("Pedido criado com sucesso!");
            pedido.gerarDescricaoVenda();
        } catch (Exception e) {
            System.out.println("Erro ao criar pedido: " + e.getMessage());
        }
    }

    private static void confirmarPagamento() {
        try {
            System.out.print("Informe o ID do Pedido a confirmar pagamento: ");
            int id = Integer.parseInt(scanner.nextLine());
            Pedido pedido = encontrarPedidoPorId(id);
            if (pedido != null) {
                processaPedido.confirmarPagamento(pedido);
            } else {
                System.out.println("Pedido não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao confirmar pagamento: " + e.getMessage());
        }
    }

    private static void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
        } else {
            System.out.println("=== Lista de Pedidos ===");
            for (Pedido pedido : pedidos) {
                System.out.println("ID: " + pedido.getId() + ", Cliente: " + pedido.getCliente().getNome() + ", Valor Total: R$ " + pedido.getValorTotal());
            }
        }
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("=== Lista de Clientes ===");
            for (Cliente cliente : clientes) {
                System.out.println("Nome: " + cliente.getNome() + ", Idade: " + cliente.getIdade());
            }
        }
    }

    private static void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("=== Lista de Funcionários ===");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario.getNome() + ", Cargo: " + funcionario.getClass().getSimpleName());
            }
        }
    }

    // Métodos auxiliares
    private static Pedido encontrarPedidoPorId(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private static Cliente selecionarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente primeiro.");
            return null;
        }
        System.out.println("Selecione um cliente pelo número:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + clientes.get(i).getNome());
        }
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            if (opcao < 1 || opcao > clientes.size()) {
                System.out.println("Opção inválida.");
                return null;
            }
            return clientes.get(opcao - 1);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
            return null;
        }
    }

    private static Vendedor selecionarVendedor() {
        List<Vendedor> vendedores = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f instanceof Vendedor) {
                vendedores.add((Vendedor) f);
            }
        }
        if (vendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado.");
            return null;
        }
        System.out.println("Selecione um vendedor pelo número:");
        for (int i = 0; i < vendedores.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + vendedores.get(i).getNome());
        }
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            if (opcao < 1 || opcao > vendedores.size()) {
                System.out.println("Opção inválida.");
                return null;
            }
            return vendedores.get(opcao - 1);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
            return null;
        }
    }

    private static List<Item> selecionarItens() {
        List<Item> itensDisponiveis = createItens();
        List<Item> itensSelecionados = new ArrayList<>();
        System.out.println("Selecione os itens pelo número (digite 0 para finalizar):");
        for (int i = 0; i < itensDisponiveis.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + itensDisponiveis.get(i).getNome() + " - R$ " + itensDisponiveis.get(i).getValor());
        }
        while (true) {
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 0) {
                    break;
                }
                if (opcao < 1 || opcao > itensDisponiveis.size()) {
                    System.out.println("Opção inválida.");
                } else {
                    itensSelecionados.add(itensDisponiveis.get(opcao - 1));
                    System.out.println("Item adicionado.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }
        return itensSelecionados;
    }

    private static Loja selecionarLoja() {
        if (lojas.isEmpty()) {
            System.out.println("Nenhuma loja cadastrada. Cadastre uma loja primeiro.");
            return null;
        }
        System.out.println("Selecione uma loja pelo número:");
        for (int i = 0; i < lojas.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + lojas.get(i).getNomeFantasia());
        }
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            if (opcao < 1 || opcao > lojas.size()) {
                System.out.println("Opção inválida.");
                return null;
            }
            return lojas.get(opcao - 1);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
            return null;
        }
    }

    private static void salvarDados() {
        try {
            DataManager.salvarPedidos(pedidos, "pedidos.dat");
            DataManager.salvarClientes(clientes, "clientes.dat");
            DataManager.salvarFuncionarios(funcionarios, "funcionarios.dat");
            DataManager.salvarLojas(lojas, "lojas.dat");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    // Métodos para criar itens de teste
    private static List<Item> createItens() {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Orquídea", "Flor", 50.0));
        itens.add(new Item(2, "Samambaia", "Planta", 30.0));
        itens.add(new Item(3, "Cacto", "Planta", 20.0));
        // Adicione mais itens se desejar
        return itens;
    }

    // Bloco estático para inicializar dados de teste (opcional)
    static {
        // Você pode inicializar alguns dados de teste aqui, se desejar
        // Por exemplo, criar uma loja padrão:
        Endereco enderecoLoja = new Endereco("Av. Principal", 1000, "Centro", "São Paulo", "SP", "Loja 1");
        Loja loja = new Loja("Myy Plant", "Myy Plant Comércio de Plantas Ltda", "12.345.678/0001-90", enderecoLoja);
        lojas.add(loja);

        // Criar um vendedor padrão
        Endereco enderecoFuncionario = new Endereco("Rua das Flores", 123, "Bairro", "São Paulo", "SP", "");
        double[] salarioRecebido = {3000.0, 3100.0, 3200.0};
        Vendedor vendedor = new Vendedor("João Silva", 30, loja, enderecoFuncionario, 3000.0, salarioRecebido);
        funcionarios.add(vendedor);
        loja.adicionarFuncionario(vendedor);

        // Criar um cliente padrão
        Endereco enderecoCliente = new Endereco("Rua das Palmeiras", 456, "Jardins", "São Paulo", "SP", "");
        Cliente cliente = new Cliente("Carlos Pereira", 40, enderecoCliente);
        clientes.add(cliente);
        loja.adicionarCliente(cliente);
    }
}
