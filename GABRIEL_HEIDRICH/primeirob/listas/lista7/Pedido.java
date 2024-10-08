package lista7;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private String nomeCliente;
    private Map<Item, Integer> itensPedido;

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.itensPedido = new HashMap<>();
    }

    public void adicionarItem(Item item, int quantidade) {
        itensPedido.put(item, quantidade);
    }

    public void mostrarPedido() {
        System.out.println("Pedido de: " + nomeCliente);
        double total = 0;
        for (Map.Entry<Item, Integer> entry : itensPedido.entrySet()) {
            Item item = entry.getKey();
            int quantidade = entry.getValue();
            double subtotal = item.getPreco() * quantidade;
            total += subtotal;
            System.out.println(item.getNome() + " - Quantidade: " + quantidade + " - Subtotal: R$ " + subtotal);
        }
        System.out.println("Total do pedido: R$ " + total);
    }
}
