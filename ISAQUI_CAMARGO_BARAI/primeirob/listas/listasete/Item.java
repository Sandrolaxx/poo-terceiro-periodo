package ISAQUI_CAMARGO_BARAI.primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.Scanner;

// Classe Item encapsula os detalhes de um item.
class Item {
    private String nome;
    private double preco;

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Item: " + nome + ", Preço: " + preco;
    }
}

// Classe Pedido encapsula os detalhes de um pedido.
class Pedido {
    private String usuario;
    private Item item;
    private int quantidade;

    public Pedido(String usuario, Item item, int quantidade) {
        this.usuario = usuario;
        this.item = item;
        this.quantidade = quantidade;
    }

    public double calcularTotal() {
        return item.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return "Pedido de " + usuario + ": " + quantidade + " x " + item.getNome() + " - Total: R$ " + calcularTotal();
    }
}
