package ROBSON_DE_LIMA.primeirob.listas.listaSeis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu {
    public static void main(String[] args) {
        // Criação de instâncias de teste
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "123", "Apto 1");
        Cliente cliente = new Cliente("João", 30, endereco, "joao@mail.com");
        Vendedor vendedor = new Vendedor("Maria", 35, endereco, 3000.0);
        Item item1 = new Item(1, "Planta 1", "Flor", 20.0);
        Item item2 = new Item(2, "Planta 2", "Cacto", 30.0);
        List<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);

        ProcessaPedido processaPedido = new ProcessaPedido();
        Pedido pedido = processaPedido.processar(1, new Date(), null, new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000), cliente, vendedor, "Myy Plant", itens);

        processaPedido.confirmarPagamento(pedido);
        pedido.gerarDescricaoVenda();
    }
}

