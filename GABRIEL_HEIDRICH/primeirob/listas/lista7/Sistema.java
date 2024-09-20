package lista7;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Item> itens;

    public Sistema() {
        itens = new ArrayList<>();
    }

    public void cadastrarItem(String nome, double preco) {
        Item item = new Item(nome, preco);
        itens.add(item);
        System.out.println("Item cadastrado com sucesso!");
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }

    public Item buscarItemPorNome(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        System.out.println("Item não encontrado.");
        return null;
    }

    public Pedido criarPedido(String nomeCliente, Scanner scanner) {
        Pedido pedido = new Pedido(nomeCliente);
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            System.out.print("Informe o nome do item que deseja comprar: ");
            String nomeItem = scanner.nextLine();
            Item item = buscarItemPorNome(nomeItem);

            if (item != null) {
                System.out.print("Informe a quantidade: ");
                int quantidade = Integer.parseInt(scanner.nextLine());
                pedido.adicionarItem(item, quantidade);
            }

            System.out.print("Deseja adicionar outro item ao pedido? (s/n): ");
            continuar = scanner.nextLine();
        }

        return pedido;
    }
}
