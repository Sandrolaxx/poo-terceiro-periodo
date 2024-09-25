package ISAQUI_CAMARGO_BARAI.primeirob.listas.listacinco;

import java.util.Arrays;

public class TestObjects {

    public static void main(String[] args) {
        // Criando instâncias de uma loja, dois vendedores e um cliente
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor1();
        Vendedor vendedor2 = criarVendedor2();
        Cliente cliente1 = criarCliente();

        // Adicionando vendedores e cliente à loja
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);

        // Exibindo informações da loja, vendedores e cliente
        loja.apresentarse();
        vendedor1.apresentarse();
        vendedor2.apresentarse();
        cliente1.apresentarse();

        // Exibindo quantidade de clientes e vendedores
        System.out.println("Quantidade de vendedores: " + loja.contarVendedores());
        System.out.println("Quantidade de clientes: " + loja.contarClientes());
    }

    // Método estático para criar uma loja
    public static Loja criarLoja() {
        return new Loja("Loja de Plantas", "Plantas Ltda.", "12.345.678/0001-99", "São Paulo", "Centro", "Rua das Flores");
    }

    // Método estático para criar o primeiro vendedor
    public static Vendedor criarVendedor1() {
        return new Vendedor("Carlos", 30, "Loja de Plantas", "São Paulo", "Centro", "Rua das Palmeiras", 1500.0, Arrays.asList(1500.0, 1600.0, 1700.0));
    }

    // Método estático para criar o segundo vendedor
    public static Vendedor criarVendedor2() {
        return new Vendedor("Ana", 25, "Loja de Plantas", "São Paulo", "Centro", "Rua das Magnólias", 1600.0, Arrays.asList(1600.0, 1650.0, 1700.0));
    }

    // Método estático para criar um cliente
    public static Cliente criarCliente() {
        return new Cliente("Mariana", 28, "São Paulo", "Centro", "Rua das Violetas");
    }
}
