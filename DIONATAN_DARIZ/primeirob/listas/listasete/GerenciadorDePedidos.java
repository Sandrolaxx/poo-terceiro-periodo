package DIONATAN_DARIZ.primeirob.listas.listasete;

import java.util.ArrayList;

public class GerenciadorDePedidos {
    private ArrayList<Pedido> pedidos;

    public GerenciadorDePedidos() {
        pedidos = new ArrayList<>();
    }

    public void criarPedido(String nomeCliente, Item item, int quantidade) {
        pedidos.add(new Pedido(nomeCliente, item, quantidade));
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido feito.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }
}
