package ERICK_SCUR.primeirob.listas.lista7;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        String[] opcoes = {"Cadastro de Itens", "Listar Itens", "Buscar Item por Nome", "Criar Pedido (dados usuário)", "Consultar Entidades", "Sair"};
        boolean continuar = true;

        while (continuar) {
            String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Menu", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (opcao == null || opcao.equals("Sair")) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Encerrando o sistema.");
            } else {
                switch (opcao) {
                    case "Cadastro de Itens":
                        cadastrarItem();
                        break;
                    case "Listar Itens":
                        listarItens();
                        break;
                    case "Buscar Item por Nome":
                        buscarItemPorNome();
                        break;
                    case "Criar Pedido (dados usuário)":
                        criarPedidoComItem();
                        break;
                }
            }
        }
    }

    private void cadastrarItem() {
        int id = obterInputNumero("ID do Item");
        String nome = obterInputTexto("Nome do Item");
        String tipo = obterInputTexto("Tipo do Item");
        double valor = obterInputDouble("Valor do Item");

        Item item = new Item(id, nome, tipo, valor);
        itens.add(item);
        JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!");
    }

    private void listarItens() {
        if (itens.size() < 2) {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar pelo menos 2 itens.");
        } else {
            StringBuilder listaItens = new StringBuilder("Itens cadastrados:\n");
            for (Item item : itens) {
                listaItens.append("ID: ").append(item.getId()).append(", Nome: ").append(item.getNome()).append(", Tipo: ").append(item.getTipo()).append(", Valor: ").append(item.getValor()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaItens.toString());
        }
    }

    private void buscarItemPorNome() {
        String nomeBusca = obterInputTexto("Digite o nome do item que deseja buscar:");
        boolean encontrado = false;

        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeBusca)) {
                item.gerarDescricao();
                encontrado = true;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Item não encontrado.");
        }
    }

    private void criarPedidoComItem() {
        if (itens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum item cadastrado. Cadastre um item primeiro.");
            return;
        }

        String nomeCliente = obterInputTexto("Nome do cliente:");
        Cliente cliente = new Cliente(nomeCliente, 30, new Endereco("SP", "São Paulo", "Centro", "123", ""));

        int idItem = obterInputNumero("Digite o ID do item que deseja comprar:");
        Item itemSelecionado = null;

        for (Item item : itens) {
            if (item.getId() == idItem) {
                itemSelecionado = item;
                break;
            }
        }

        if (itemSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Item não encontrado.");
            return;
        }

        int quantidade = obterInputNumero("Digite a quantidade do item desejado:");

        List<Item> itensDoPedido = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            itensDoPedido.add(itemSelecionado);
        }

        Pedido pedido = getPedido(cliente, itensDoPedido);
        pedidos.add(pedido);

        JOptionPane.showMessageDialog(null, "Pedido criado com sucesso! Valor total: " + pedido.calcularValorTotal());
    }

    private Pedido getPedido(Cliente cliente, List<Item> itensDoPedido) {
        Date dataCriacao = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dataCriacao);
        c.add(Calendar.DATE, 5);
        Date dataVencimento = c.getTime();

        Loja loja = lojas.isEmpty() ? new Loja("Myy Plant", "Myy Plant LTDA", "00.123.456/0001-78", new Endereco("SP", "São Paulo", "Centro", "123", "")) : lojas.get(0);

        Pedido pedido = new Pedido(1, dataCriacao, null, dataVencimento, cliente, vendedores.isEmpty() ? null : vendedores.get(0), loja, itensDoPedido);
        return pedido;
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
}