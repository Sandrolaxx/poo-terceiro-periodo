package ISAQUI_CAMARGO_BARAI.primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static ArrayList<Item> itens = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Cadastrar item");
            System.out.println("2. Listar itens");
            System.out.println("3. Buscar item por nome");
            System.out.println("4. Criar pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarItem();
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    buscarItemPorNome();
                    break;
                case 4:
                    criarPedido();
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void cadastrarItem() {
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do item: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir quebra de linha

        Item item = new Item(nome, preco);
        itens.add(item);
        System.out.println("Item cadastrado com sucesso!");
    }

    private static void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            System.out.println("\nItens cadastrados:");
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }

    private static void buscarItemPorNome() {
        System.out.print("Digite o nome do item que deseja buscar: ");
        String nomeBusca = scanner.nextLine();
        boolean encontrado = false;

        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.println(item);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Item não encontrado.");
        }
    }

    private static void criarPedido() {
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        
        System.out.print("Digite o nome do item que deseja comprar: ");
        String nomeItem = scanner.nextLine();
        
        Item itemSelecionado = null;
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemSelecionado = item;
                break;
            }
        }

        if (itemSelecionado == null) {
            System.out.println("Item não encontrado.");
            return;
        }

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        Pedido pedido = new Pedido(nomeUsuario, itemSelecionado, quantidade);
        pedidos.add(pedido);
        System.out.println("Pedido criado com sucesso!");
        System.out.println(pedido);
    }
}
