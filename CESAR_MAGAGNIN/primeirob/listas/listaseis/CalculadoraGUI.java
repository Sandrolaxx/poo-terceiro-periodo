package primeirob.listas.listaseis;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class CalculadoraGUI extends JFrame {

    private Controller controller;

    public CalculadoraGUI() {
        controller = new Controller();
        initialize();
    }

    private void initialize() {
        setTitle("Sistema de Pedidos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Criar a barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Menu Cadastrar
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuItemCadastrarCliente = new JMenuItem("Cadastro Cliente");
        JMenuItem menuItemCadastrarFuncionario = new JMenuItem("Cadastro Funcionário");
        JMenuItem menuItemCadastrarLoja = new JMenuItem("Cadastro Loja");

        menuCadastrar.add(menuItemCadastrarCliente);
        menuCadastrar.add(menuItemCadastrarFuncionario);
        menuCadastrar.add(menuItemCadastrarLoja);

        // Menu Exibir
        JMenu menuExibir = new JMenu("Exibir");
        JMenuItem menuItemListarClientes = new JMenuItem("Listar Clientes");
        JMenuItem menuItemListarFuncionarios = new JMenuItem("Listar Funcionários");

        menuExibir.add(menuItemListarClientes);
        menuExibir.add(menuItemListarFuncionarios);

        // Menu Pedidos
        JMenu menuPedidos = new JMenu("Pedidos");
        JMenuItem menuItemNovoPedido = new JMenuItem("Novo Pedido");
        JMenuItem menuItemListarPedidos = new JMenuItem("Listar Pedidos");
        JMenuItem menuItemConfirmarPagamento = new JMenuItem("Confirmar Pagamento de Pedido");

        menuPedidos.add(menuItemNovoPedido);
        menuPedidos.add(menuItemListarPedidos);
        menuPedidos.add(menuItemConfirmarPagamento);

        // Menu Sair
        JMenu menuSair = new JMenu("Sair");
        JMenuItem menuItemSair = new JMenuItem("Sair");
        menuSair.add(menuItemSair);

        // Adicionar menus à barra de menu
        menuBar.add(menuCadastrar);
        menuBar.add(menuExibir);
        menuBar.add(menuPedidos);
        menuBar.add(menuSair);

        // Configurar a barra de menu
        setJMenuBar(menuBar);

        // Painel principal (pode ser usado para exibir informações)
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // Adicionar ActionListeners aos itens de menu

        // Cadastrar
        menuItemCadastrarCliente.addActionListener(e -> cadastrarCliente());
        menuItemCadastrarFuncionario.addActionListener(e -> cadastrarFuncionario());
        menuItemCadastrarLoja.addActionListener(e -> cadastrarLoja());

        // Exibir
        menuItemListarClientes.addActionListener(e -> listarClientes());
        menuItemListarFuncionarios.addActionListener(e -> listarFuncionarios());

        // Pedidos
        menuItemNovoPedido.addActionListener(e -> criarPedido());
        menuItemListarPedidos.addActionListener(e -> listarPedidos());
        menuItemConfirmarPagamento.addActionListener(e -> confirmarPagamento());

        // Sair
        menuItemSair.addActionListener(e -> {
            controller.salvarDados();
            System.exit(0);
        });
    }

    private void cadastrarCliente() {
        JTextField txtNome = new JTextField();
        JTextField txtIdade = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome do Cliente:"));
        panel.add(txtNome);
        panel.add(new JLabel("Idade:"));
        panel.add(txtIdade);

        int result = JOptionPane.showConfirmDialog(this, panel, "Cadastrar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String nome = txtNome.getText();
                int idade = Integer.parseInt(txtIdade.getText());
                Endereco endereco = criarEndereco();
                if (endereco != null) {
                    controller.cadastrarCliente(nome, idade, endereco);
                    JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Cadastro cancelado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Idade inválida.");
            }
        }
    }

    private Endereco criarEndereco() {
        JTextField txtRua = new JTextField();
        JTextField txtNumero = new JTextField();
        JTextField txtBairro = new JTextField();
        JTextField txtCidade = new JTextField();
        JTextField txtEstado = new JTextField();
        JTextField txtComplemento = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Rua:"));
        panel.add(txtRua);
        panel.add(new JLabel("Número:"));
        panel.add(txtNumero);
        panel.add(new JLabel("Bairro:"));
        panel.add(txtBairro);
        panel.add(new JLabel("Cidade:"));
        panel.add(txtCidade);
        panel.add(new JLabel("Estado:"));
        panel.add(txtEstado);
        panel.add(new JLabel("Complemento:"));
        panel.add(txtComplemento);

        int result = JOptionPane.showConfirmDialog(this, panel, "Endereço", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String rua = txtRua.getText();
                int numero = Integer.parseInt(txtNumero.getText());
                String bairro = txtBairro.getText();
                String cidade = txtCidade.getText();
                String estado = txtEstado.getText();
                String complemento = txtComplemento.getText();
                return new Endereco(rua, numero, bairro, cidade, estado, complemento);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número inválido.");
                return null;
            }
        } else {
            return null;
        }
    }

    private void cadastrarFuncionario() {
        JTextField txtNome = new JTextField();
        JTextField txtIdade = new JTextField();
        String[] cargos = {"Vendedor", "Gerente"};
        JComboBox<String> comboCargo = new JComboBox<>(cargos);

        List<Loja> lojas = controller.getLojas();
        if (lojas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma loja cadastrada.");
            return;
        }
        String[] lojasNomes = lojas.stream().map(Loja::getNomeFantasia).toArray(String[]::new);
        JComboBox<String> comboLoja = new JComboBox<>(lojasNomes);

        JTextField txtSalarioBase = new JTextField();
        JTextField txtSalarioMes1 = new JTextField();
        JTextField txtSalarioMes2 = new JTextField();
        JTextField txtSalarioMes3 = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome do Funcionário:"));
        panel.add(txtNome);
        panel.add(new JLabel("Idade:"));
        panel.add(txtIdade);
        panel.add(new JLabel("Cargo:"));
        panel.add(comboCargo);
        panel.add(new JLabel("Loja:"));
        panel.add(comboLoja);
        panel.add(new JLabel("Salário Base:"));
        panel.add(txtSalarioBase);
        panel.add(new JLabel("Salário Mês 1:"));
        panel.add(txtSalarioMes1);
        panel.add(new JLabel("Salário Mês 2:"));
        panel.add(txtSalarioMes2);
        panel.add(new JLabel("Salário Mês 3:"));
        panel.add(txtSalarioMes3);

        int result = JOptionPane.showConfirmDialog(this, panel, "Cadastrar Funcionário", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String nome = txtNome.getText();
                int idade = Integer.parseInt(txtIdade.getText());
                int cargo = comboCargo.getSelectedIndex() + 1;
                Loja loja = lojas.get(comboLoja.getSelectedIndex());
                Endereco endereco = criarEndereco();
                double salarioBase = Double.parseDouble(txtSalarioBase.getText());
                double[] salarioRecebido = new double[3];
                salarioRecebido[0] = Double.parseDouble(txtSalarioMes1.getText());
                salarioRecebido[1] = Double.parseDouble(txtSalarioMes2.getText());
                salarioRecebido[2] = Double.parseDouble(txtSalarioMes3.getText());
                controller.cadastrarFuncionario(nome, idade, cargo, loja, endereco, salarioBase, salarioRecebido);
                JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Dados numéricos inválidos.");
            }
        }
    }

    private void cadastrarLoja() {
        JTextField txtNomeFantasia = new JTextField();
        JTextField txtRazaoSocial = new JTextField();
        JTextField txtCNPJ = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nome Fantasia:"));
        panel.add(txtNomeFantasia);
        panel.add(new JLabel("Razão Social:"));
        panel.add(txtRazaoSocial);
        panel.add(new JLabel("CNPJ:"));
        panel.add(txtCNPJ);

        int result = JOptionPane.showConfirmDialog(this, panel, "Cadastrar Loja", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String nomeFantasia = txtNomeFantasia.getText();
            String razaoSocial = txtRazaoSocial.getText();
            String cnpj = txtCNPJ.getText();
            Endereco endereco = criarEndereco();
            if (endereco != null) {
                controller.cadastrarLoja(nomeFantasia, razaoSocial, cnpj, endereco);
                JOptionPane.showMessageDialog(this, "Loja cadastrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Cadastro cancelado.");
            }
        }
    }

    private void criarPedido() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Informe o ID do Pedido:");
            if (idStr == null) return; // Cancelado
            int id = Integer.parseInt(idStr);

            List<Cliente> clientes = controller.getClientes();
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado.");
                return;
            }
            String[] clientesNomes = clientes.stream().map(Cliente::getNome).toArray(String[]::new);
            String clienteSelecionado = (String) JOptionPane.showInputDialog(this, "Selecione o Cliente:", "Cliente", JOptionPane.PLAIN_MESSAGE, null, clientesNomes, clientesNomes[0]);
            if (clienteSelecionado == null) return; // Cancelado
            Cliente cliente = clientes.get(java.util.Arrays.asList(clientesNomes).indexOf(clienteSelecionado));

            List<Vendedor> vendedores = controller.getVendedores();
            if (vendedores.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum vendedor cadastrado.");
                return;
            }
            String[] vendedoresNomes = vendedores.stream().map(Vendedor::getNome).toArray(String[]::new);
            String vendedorSelecionado = (String) JOptionPane.showInputDialog(this, "Selecione o Vendedor:", "Vendedor", JOptionPane.PLAIN_MESSAGE, null, vendedoresNomes, vendedoresNomes[0]);
            if (vendedorSelecionado == null) return; // Cancelado
            Vendedor vendedor = vendedores.get(java.util.Arrays.asList(vendedoresNomes).indexOf(vendedorSelecionado));

            Loja loja = vendedor.getLoja();

            List<Item> itensDisponiveis = controller.createItens();
            JList<String> listItens = new JList<>(itensDisponiveis.stream().map(item -> item.getNome() + " - R$ " + item.getValor()).toArray(String[]::new));
            listItens.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            JScrollPane scrollPane = new JScrollPane(listItens);
            int result = JOptionPane.showConfirmDialog(this, scrollPane, "Selecione os Itens (Ctrl+Click para múltiplos)", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                int[] selectedIndices = listItens.getSelectedIndices();
                if (selectedIndices.length == 0) {
                    JOptionPane.showMessageDialog(this, "Nenhum item selecionado.");
                    return;
                }
                List<Item> itensSelecionados = new java.util.ArrayList<>();
                for (int idx : selectedIndices) {
                    itensSelecionados.add(itensDisponiveis.get(idx));
                }
                controller.criarPedido(id, cliente, vendedor, loja, itensSelecionados);
                JOptionPane.showMessageDialog(this, "Pedido criado com sucesso!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private void confirmarPagamento() {
        String idStr = JOptionPane.showInputDialog(this, "Informe o ID do Pedido a confirmar pagamento:");
        if (idStr == null) return; // Cancelado
        try {
            int id = Integer.parseInt(idStr);
            controller.confirmarPagamento(id);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private void listarPedidos() {
        List<Pedido> pedidos = controller.getPedidos();
        if (pedidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum pedido cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Pedido pedido : pedidos) {
                sb.append("ID: ").append(pedido.getId())
                  .append(", Cliente: ").append(pedido.getCliente().getNome())
                  .append(", Valor Total: R$ ").append(pedido.getValorTotal()).append("\n");
            }
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(this, scrollPane, "Lista de Pedidos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void listarClientes() {
        List<Cliente> clientes = controller.getClientes();
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Cliente cliente : clientes) {
                sb.append("Nome: ").append(cliente.getNome())
                  .append(", Idade: ").append(cliente.getIdade()).append("\n");
            }
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(this, scrollPane, "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void listarFuncionarios() {
        List<Funcionario> funcionarios = controller.getFuncionarios();
        if (funcionarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum funcionário cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Funcionario funcionario : funcionarios) {
                sb.append("Nome: ").append(funcionario.getNome())
                  .append(", Cargo: ").append(funcionario.getClass().getSimpleName()).append("\n");
            }
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(this, scrollPane, "Lista de Funcionários", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraGUI gui = new CalculadoraGUI();
            gui.setVisible(true);
        });
    }
}
