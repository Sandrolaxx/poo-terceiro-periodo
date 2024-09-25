package ISAQUI_CAMARGO_BARAI.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "Rua A", 123, "Apto 1");
        Gerente gerente = new Gerente("Carlos", 45, "Loja A", endereco, 5000.0);

        gerente.apresentarse();
        System.out.println("Média dos salários: " + gerente.calcularMedia());
        System.out.println("Bônus: " + gerente.calcularBonus());

        Item item1 = new Item(1, "Produto A", "Tipo X", 100.0);
        Item item2 = new Item(2, "Produto B", "Tipo Y", 200.0);
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);

        ProcessaPedido processaPedido = new ProcessaPedido();
        Pedido pedido = processaPedido.processar(1, new Date(), new Date(System.currentTimeMillis() + (3 * 24 * 60 * 60 * 1000)), "Cliente X", "Vendedor Y", "Loja A", itens);

        pedido.gerarDescricaoVenda();
        processaPedido.confirmarPagamento(pedido);
    }
}
