package primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.Scanner;
import primeirob.listas.listasete.Item;

public class Menu {
    private static ArrayList<Item> itens = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar item");
            System.out.println("2. Listar itens");
            System.out.println("3. Buscar item por nome");
            System.out.println("4. Criar pedido");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
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
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private static void cadastrarItem(Scanner scanner) {
        System.out.print("Digite o ID do item: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo do item: ");
        String tipo = scanner.nextLine();
        System.out.print("Digite o valor do item: ");
        double valor = scanner.nextDouble();

        Item item = new Item(id, nome, tipo, valor);
        itens.add(item);
        System.out.println("Item cadastrado com sucesso!");
    }

    private static void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            System.out.println("Itens cadastrados:");
            for (Item item : itens) {
                item.gerarDescricao();
            }
        }
    }

    private static void buscarItemPorNome(Scanner scanner) {
        System.out.print("Digite o nome do item que deseja buscar: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                item.gerarDescricao();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Item não encontrado.");
        }
    }

    private static void criarPedido(Scanner scanner) {
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
        System.out.print("Digite a quantidade do item: ");
        int quantidade = scanner.nextInt();

        double valorTotal = itemSelecionado.getValor() * quantidade;
        System.out.println("Pedido criado: " + itemSelecionado.getNome() + " x " + quantidade + " - Valor total: R$" + valorTotal);
    }
}