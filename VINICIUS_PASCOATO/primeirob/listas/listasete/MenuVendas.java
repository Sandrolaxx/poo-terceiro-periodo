package primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuVendas {

    private ArrayList<Item> itensDisponiveis = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public MenuVendas() {
        itensDisponiveis.add(new Item("Vaso de Plantas", 50.00, 10));
        itensDisponiveis.add(new Item("Fertilizante", 25.00, 30));
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\nMenu de Vendas:");
            System.out.println("1. Cadastro de itens");
            System.out.println("2. Listar itens");
            System.out.println("3. Buscar item por nome");
            System.out.println("4. Criar pedido");
            System.out.println("5. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarItem(scanner);
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    buscarItemPorNome(scanner);
                    break;
                case 4:
                    criarPedido(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);
    }

    private void cadastrarItem(Scanner scanner) {
        System.out.println("Cadastro de Item:");
        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do item: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        itensDisponiveis.add(new Item(nome, preco, quantidade));
        System.out.println("Item cadastrado com sucesso!");
    }

    private void listarItens() {
        if (itensDisponiveis.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            System.out.println("Itens disponíveis:");
            for (Item item : itensDisponiveis) {
                System.out.println(item);
            }
        }
    }

    private void buscarItemPorNome(Scanner scanner) {
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;
        for (Item item : itensDisponiveis) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                System.out.println(item);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Item não encontrado.");
        }
    }

    private void criarPedido(Scanner scanner) {
        listarItens();

        System.out.print("Digite o nome do item: ");
        String nomeItem = scanner.nextLine();
        Item itemSelecionado = null;

        for (Item item : itensDisponiveis) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemSelecionado = item;
                break;
            }
        }

        if (itemSelecionado == null) {
            System.out.println("Item não encontrado.");
            return;
        }

        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (quantidade > itemSelecionado.getQuantidade()) {
            System.out.println("Quantidade indisponível em estoque.");
        } else {
            Pedido pedido = new Pedido(itemSelecionado, quantidade);
            pedidos.add(pedido);
            System.out.println("Pedido criado com sucesso!");
        }
    }

    public static void main(String[] args) {
        MenuVendas menu = new MenuVendas();
        menu.exibirMenu();
    }
}
