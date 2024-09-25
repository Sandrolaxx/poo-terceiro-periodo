package MURILO_WOLFF.primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static List<Item> listaItens = new ArrayList<>();
    private static Loja loja1;
    private static Vendedor vendedor1;
    private static Cliente cliente1;

    public static void main(String[] args) {
        inicializarDados();

        Scanner leitor = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarItem(leitor);
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    buscarItemPorNome(leitor);
                    break;
                case 4:
                    criarPedido(leitor);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        leitor.close();
    }

    private static void inicializarDados() {
        Endereco enderecoLoja = new Endereco("SP", "São Paulo", "Centro", "123", "Rua das Flores");
        Endereco enderecoVendedor = new Endereco("SP", "São Paulo", "Mooca", "456", "Rua A");
        Endereco enderecoCliente = new Endereco("SP", "São Paulo", "Jardins", "789", "Avenida Paulista");

        vendedor1 = new Vendedor("João Silva", 30, enderecoVendedor, "Myy Plant Centro", 2500.00);
        vendedor1.setSalarioRecebido(0, 2500.00);
        vendedor1.setSalarioRecebido(1, 2600.00);
        vendedor1.setSalarioRecebido(2, 2550.00);

        cliente1 = new Cliente("Maria Oliveira", 25, enderecoCliente);

        Vendedor[] vendedores = {vendedor1};
        Cliente[] clientes = {cliente1};
        loja1 = new Loja("Myy Plant Centro", "Myy Plant LTDA", "12.345.678/0001-90",
                enderecoLoja, vendedores, clientes);

        listaItens.add(new Item(1, "Violeta Africana", "Planta", 25.00));
        listaItens.add(new Item(2, "Vasinho de Cerâmica", "Acessório", 15.00));
    }

    private static void exibirMenu() {
        System.out.println("\n===== Menu Myy Plant =====");
        System.out.println("1 - Cadastrar Item");
        System.out.println("2 - Listar Itens");
        System.out.println("3 - Buscar Item por Nome");
        System.out.println("4 - Criar Pedido");
        System.out.println("5 - Sair");
        System.out.print("Digite a opção desejada: ");
    }

    private static void cadastrarItem(Scanner leitor) {
        System.out.print("ID do Item: ");
        int id = leitor.nextInt();
        leitor.nextLine();
        System.out.print("Nome do Item: ");
        String nome = leitor.nextLine();
        System.out.print("Tipo do Item: ");
        String tipo = leitor.nextLine();
        System.out.print("Valor do Item: ");
        double valor = leitor.nextDouble();

        Item novoItem = new Item(id, nome, tipo, valor);
        listaItens.add(novoItem);
        System.out.println("Item cadastrado com sucesso!");
    }

    private static void listarItens() {
        if (listaItens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            System.out.println("===== Lista de Itens =====");
            for (Item item : listaItens) {
                item.gerarDescricao();
            }
        }
    }

    private static void buscarItemPorNome(Scanner leitor) {
        System.out.print("Digite o nome do item: ");
        String nomeBuscado = leitor.nextLine();

        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeBuscado)) {
                item.gerarDescricao();
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }

    private static void criarPedido(Scanner leitor) {
        listarItens();
        System.out.print("Digite o ID do item que deseja comprar: ");
        int idItem = leitor.nextInt();
        System.out.print("Digite a quantidade: ");
        int quantidade = leitor.nextInt();

        Item itemSelecionado = null;
        for (Item item : listaItens) {
            if (item.getId() == idItem) {
                itemSelecionado = item;
                break;
            }
        }

        if (itemSelecionado != null) {
            Item[] itensPedido = {itemSelecionado};
            ProcessaPedido processador = new ProcessaPedido();
            Pedido novoPedido = processador.processar(1, cliente1, vendedor1, loja1, itensPedido);
            novoPedido.gerarDescricaoVenda();
        } else {
            System.out.println("Item não encontrado.");
        }
    }
}