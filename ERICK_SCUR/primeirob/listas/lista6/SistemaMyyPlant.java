package ERICK_SCUR.primeirob.listas.lista6;

import javax.swing.*;
import java.util.*;

public class SistemaMyyPlant {

    private List<Loja> lojas = new ArrayList<>();
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Gerente> gerentes = new ArrayList<>();
    private List<Item> itens = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        SistemaMyyPlant sistema = new SistemaMyyPlant();
        sistema.exibirMenu();
    }

    public void exibirMenu() {
        String[] opcoes = {"Criar Loja", "Criar Vendedor", "Criar Cliente", "Criar Gerente", "Criar Item", "Criar Pedido", "Consultar Entidades", "Sair"};
        boolean continuar = true;

        while (continuar) {
            String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Menu", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (opcao == null || opcao.equals("Sair")) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
            } else {
                switch (opcao) {
                    case "Criar Loja":
                        criarLoja();
                        break;
                    case "Criar Vendedor":
                        criarVendedor();
                        break;
                    case "Criar Cliente":
                        criarCliente();
                        break;
                    case "Criar Gerente":
                        criarGerente();
                        break;
                    case "Criar Item":
                        criarItem();
                        break;
                    case "Criar Pedido":
                        criarPedido();
                        break;
                    case "Consultar Entidades":
                        exibirMenuConsulta();
                        break;
                }
            }
        }
    }

    public void exibirMenuConsulta() {
        String[] opcoes = {"Consultar Lojas", "Consultar Vendedores", "Consultar Clientes", "Consultar Gerentes", "Consultar Itens", "Consultar Pedidos", "Voltar"};
        boolean continuar = true;

        while (continuar) {
            String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opção de consulta:", "Menu de Consulta", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (opcao == null || opcao.equals("Voltar")) {
                continuar = false;
            } else {
                switch (opcao) {
                    case "Consultar Lojas":
                        consultarLojas();
                        break;
                    case "Consultar Vendedores":
                        consultarVendedores();
                        break;
                    case "Consultar Clientes":
                        consultarClientes();
                        break;
                    case "Consultar Gerentes":
                        consultarGerentes();
                        break;
                    case "Consultar Itens":
                        consultarItens();
                        break;
                    case "Consultar Pedidos":
                        consultarPedidos();
                        break;
                }
            }
        }
    }

    private void criarLoja() {
        String nomeFantasia = obterInputTexto("Nome Fantasia da Loja");
        String razaoSocial = obterInputTexto("Razão Social da Loja");
        String cnpj = obterInputTexto("CNPJ da Loja");
        Endereco endereco = obterEndereco();

        Loja loja = new Loja(nomeFantasia, razaoSocial, cnpj, endereco);
        lojas.add(loja);
        JOptionPane.showMessageDialog(null, "Loja criada com sucesso!\n" + "Nome Fantasia: " + loja.getNomeFantasia());
    }

    private void criarVendedor() {
        String nome = obterInputTexto("Nome do Vendedor");
        int idade = obterInputNumero("Idade do Vendedor");
        Endereco endereco = obterEndereco();
        double salarioBase = obterInputDouble("Salário Base do Vendedor");

        Loja loja = lojas.isEmpty() ? null : lojas.get(0);

        if (loja == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma loja foi criada ainda!");
            return;
        }

        Vendedor vendedor = new Vendedor(nome, idade, loja, endereco, salarioBase);
        vendedores.add(vendedor);
        JOptionPane.showMessageDialog(null, "Vendedor criado com sucesso!\n" + "Nome: " + vendedor.nome);
    }

    private void criarCliente() {
        String nome = obterInputTexto("Nome do Cliente");
        int idade = obterInputNumero("Idade do Cliente");
        Endereco endereco = obterEndereco();

        Cliente cliente = new Cliente(nome, idade, endereco);
        clientes.add(cliente);
        JOptionPane.showMessageDialog(null, "Cliente criado com sucesso!\n" + "Nome: " + cliente.nome);
    }

    private void criarGerente() {
        String nome = obterInputTexto("Nome do Gerente");
        int idade = obterInputNumero("Idade do Gerente");
        Endereco endereco = obterEndereco();
        double salarioBase = obterInputDouble("Salário Base do Gerente");

        Loja loja = lojas.isEmpty() ? null : lojas.get(0);

        if (loja == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma loja foi criada ainda!");
            return;
        }

        Gerente gerente = new Gerente(nome, idade, loja, endereco, salarioBase);
        gerentes.add(gerente);
        JOptionPane.showMessageDialog(null, "Gerente criado com sucesso!\n" + "Nome: " + gerente.nome);
    }

    private void criarItem() {
        int id = obterInputNumero("ID do Item");
        String nome = obterInputTexto("Nome do Item");
        String tipo = obterInputTexto("Tipo do Item");
        double valor = obterInputDouble("Valor do Item");

        Item item = new Item(id, nome, tipo, valor);
        itens.add(item);
        item.gerarDescricao();
        JOptionPane.showMessageDialog(null, "Item criado com sucesso!");
    }

    private void criarPedido() {
        Cliente cliente = criarClienteInterno();
        Vendedor vendedor = criarVendedorInterno();
        List<Item> itensDoPedido = new ArrayList<>(itens);

        if (itensDoPedido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum item foi criado ainda!");
            return;
        }

        Date dataCriacao = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dataCriacao);
        c.add(Calendar.DATE, 5);
        Date dataVencimento = c.getTime();

        Loja loja = vendedor.getLoja();
        Pedido pedido = new Pedido(1, dataCriacao, null, dataVencimento, cliente, vendedor, loja, itensDoPedido);
        pedidos.add(pedido);

        pedido.gerarDescricaoVenda();
        JOptionPane.showMessageDialog(null, "Pedido criado com sucesso!\n" + "Valor total: " + pedido.calcularValorTotal());
    }

    private void consultarLojas() {
        if (lojas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma loja criada.");
        } else {
            lojas.forEach(loja -> JOptionPane.showMessageDialog(null, "Loja: " + loja.getNomeFantasia()));
        }
    }

    private void consultarVendedores() {
        if (vendedores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum vendedor criado.");
        } else {
            vendedores.forEach(vendedor -> JOptionPane.showMessageDialog(null, "Vendedor: " + vendedor.nome));
        }
    }

    private void consultarClientes() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum cliente criado.");
        } else {
            clientes.forEach(cliente -> JOptionPane.showMessageDialog(null, "Cliente: " + cliente.nome));
        }
    }

    private void consultarGerentes() {
        if (gerentes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum gerente criado.");
        } else {
            gerentes.forEach(gerente -> JOptionPane.showMessageDialog(null, "Gerente: " + gerente.nome));
        }
    }

    private void consultarItens() {
        if (itens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum item criado.");
        } else {
            itens.forEach(item -> JOptionPane.showMessageDialog(null, "Item: " + item.getNome()));
        }
    }

    private void consultarPedidos() {
        if (pedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum pedido criado.");
        } else {
            pedidos.forEach(pedido -> JOptionPane.showMessageDialog(null, "Pedido ID: " + pedido.getId() + "\nValor Total: " + pedido.calcularValorTotal()));
        }
    }

    private Endereco obterEndereco() {
        String estado = obterInputTexto("Estado");
        String cidade = obterInputTexto("Cidade");
        String bairro = obterInputTexto("Bairro");
        String numero = obterInputTexto("Número");
        String complemento = JOptionPane.showInputDialog("Complemento (opcional)");

        return new Endereco(estado, cidade, bairro, numero, complemento == null ? "" : complemento);
    }

    private int obterInputNumero(String mensagem) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                String input = JOptionPane.showInputDialog(mensagem);
                valor = Integer.parseInt(input);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número inteiro.");
            }
        }

        return valor;
    }

    private double obterInputDouble(String mensagem) {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                String input = JOptionPane.showInputDialog(mensagem);
                valor = Double.parseDouble(input);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número válido.");
            }
        }

        return valor;
    }

    private String obterInputTexto(String mensagem) {
        String input = "";
        boolean valido = false;

        while (!valido) {
            input = JOptionPane.showInputDialog(mensagem);
            if (input != null && !input.trim().isEmpty()) {
                valido = true;
            } else {
                JOptionPane.showMessageDialog(null, "Entrada inválida. O campo não pode estar vazio.");
            }
        }

        return input;
    }

    private Cliente criarClienteInterno() {
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "123", "Apto 10");
        return new Cliente("Carlos", 40, endereco);
    }

    private Vendedor criarVendedorInterno() {
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "456", "");
        Loja loja = new Loja("Myy Plant", "Myy Plant LTDA", "00.123.456/0001-78", endereco);
        return new Vendedor("João", 25, loja, endereco, 2500.0);
    }
}