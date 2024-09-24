package JOAO_VITOR_SOUZA.primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.List;


class Item {
    private String nome;
    private int quantidade;

    public Item(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item: " + nome + ", Quantidade: " + quantidade;
    }
}


class Pedido {
    private String nomeUsuario;
    private Item item;
    private int quantidade;

    public Pedido(String nomeUsuario, Item item, int quantidade) {
        this.nomeUsuario = nomeUsuario;
        this.item = item;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Pedido de " + nomeUsuario + ": " + item.getNome() + ", Quantidade: " + quantidade;
    }
}


class SistemaPlantas {
    private List<Item> itens;
    private List<Pedido> pedidos;

    public SistemaPlantas() {
        this.itens = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void cadastrarItem(String nome, int quantidade) {
        Item novoItem = new Item(nome, quantidade);
        itens.add(novoItem);
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
        return null;
    }

    
    public void criarPedido(String nomeUsuario, String nomeItem, int quantidade) {
        Item itemEncontrado = buscarItemPorNome(nomeItem);
        if (itemEncontrado != null) {
            if (itemEncontrado.getQuantidade() >= quantidade) {
                Pedido novoPedido = new Pedido(nomeUsuario, itemEncontrado, quantidade);
                pedidos.add(novoPedido);
                itemEncontrado.setQuantidade(itemEncontrado.getQuantidade() - quantidade);
                System.out.println("Pedido criado com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente no estoque.");
            }
        } else {
            System.out.println("Item não encontrado.");
        }
    }
}