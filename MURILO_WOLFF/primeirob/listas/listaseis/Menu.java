package MURILO_WOLFF.primeirob.listas.listaseis;

import java.util.Date;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        ProcessaPedido processaPedido = new ProcessaPedido();

        Cliente cliente = new Cliente("João", 30, "Cascavel", "Country", "123456789");
        Vendedor vendedor = new Vendedor("Maria", 35, "Loja Myyplant", "Cascavel", "Country",
                "Manaus", 2000.0);
        String loja = "Loja Y";

        System.out.println("Criando um novo pedido...");
        Pedido pedido = processaPedido.processar(1, new Date(), cliente, vendedor, loja,
                new Date(System.currentTimeMillis() + (3 * 24 * 60 * 60 * 1000)));

        pedido.adicionarItem(new Item(1, "Planta Copo de Leite", "Planta", 50.0));
        pedido.adicionarItem(new Item(2, "Planta Girassol", "Planta", 30.0));

        pedido.gerarDescricaoVenda();
        processaPedido.confirmarPagamento(pedido, new Date());
    }
}
