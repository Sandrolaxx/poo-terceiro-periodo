//package poo-terceiro-periodo.JACY_CORDEIRO.primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int id;
    private Date data;
    private Cliente cliente;
    private Vendedor vendedor;
    private String loja;
    private ArrayList<Item> itens = new ArrayList<>();

    public Pedido(int id, Date data, Cliente cliente, Vendedor vendedor, String loja) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public String gerarDescricaoVenda() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Pedido ID: ").append(id)
            .append("\nData: ").append(data)
            .append("\nCliente: ").append(cliente.getNome())
            .append("\nVendedor: ").append(vendedor.getNome())
            .append("\nLoja: ").append(loja)
            .append("\nItens:\n");

        for (Item item : itens) {
            descricao.append("- ").append(item.getNome()).append(" (R$ ").append(item.getPreco()).append(")\n");
        }

        return descricao.toString();
    }
}
