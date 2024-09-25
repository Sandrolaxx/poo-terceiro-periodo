package MURILO_WOLFF.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;

public class Menu {
    public static void main(String[] args) {
        Loja loja = criarLoja();

        Vendedor vendedor1 = criarVendedor1();
        Cliente cliente = criarCliente();
        loja.adicionarVendedor(vendedor1);
        loja.adicionarCliente(cliente);

        ProcessaPedido processaPedido = new ProcessaPedido();
        ArrayList<Item> itens = criarItensTeste();
        Pedido pedido = processaPedido.processar(1, new Date(), new Date(), new Date(), cliente, vendedor1, loja);
        pedido.gerarDescricaoVenda();
    }

    public static Loja criarLoja() {
        Endereco enderecoLoja = new Endereco("PR", "Cascavel", "Country", "Rua Manaus", 42, "Loja 0");
        return new Loja("Loja MyyPlant", "LTDA", "12.345.678/0001-90", enderecoLoja);
    }

    public static Vendedor criarVendedor1() {
        Endereco enderecoVendedor = new Endereco("PR", "Toledo", "Centro", "Rua A", 12, "loja 2");
        return new Vendedor("João", 30, "Myyplant", enderecoVendedor, 2000.00);
    }

    public static Cliente criarCliente() {
        Endereco enderecoCliente = new Endereco("SP", "São Paulo", "Centro", "Rua C", 55, "Casa");
        return new Cliente("Carlos", 40, enderecoCliente);
    }

    public static Gerente criarGerente() {
        Endereco enderecoGerente = new Endereco("PR", "Cascavel", "Country", "Rua Manaus", 42, "Loja 0");
        return new Gerente("Maria", 35, "MyyPlant", enderecoGerente, 3000.00);
    }

    public static ArrayList<Item> criarItensTeste() {
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Copo de leite", "Planta", 100.00));
        itens.add(new Item(2, "Tulipa", "Planta", 50.00));
        return itens;
    }
}