package DIONATAN_DARIZ.primeirob.listas.listasete;

import java.util.ArrayList;

public class GerenciadorDeItens {
    private ArrayList<Item> itens;

    public GerenciadorDeItens() {
        itens = new ArrayList<>();
    }

    public void cadastrarItem(String nome, double preco) {
        itens.add(new Item(nome, preco));
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            for (Item item : itens) {
                System.out.println("Nome: " + item.getNome() + ", Preço: R$ " + item.getPreco());
            }
        }
    }

    public Item buscarItemPorNome(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }
}
