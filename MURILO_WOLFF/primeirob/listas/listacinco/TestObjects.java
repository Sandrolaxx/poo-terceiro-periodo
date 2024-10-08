package MURILO_WOLFF.primeirob.listas.listacinco;

public class TestObjects {
    public static void main(String[] args) {
        Loja loja = criarLoja();

        Vendedor vendedor1 = criarVendedor1();
        Vendedor vendedor2 = criarVendedor2();

        Cliente cliente = criarCliente();

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente);

        loja.apresentarse();

        vendedor1.apresentarse();
        vendedor2.apresentarse();

        cliente.apresentarse();
    }

    public static Loja criarLoja() {
        return new Loja("Loja Exemplo", "Exemplo Ltda", "12.345.678/0001-90", "São Paulo", "Centro", "Rua Exemplo");
    }

    public static Vendedor criarVendedor1() {
        Vendedor vendedor = new Vendedor("João", 30, "Loja Exemplo", "São Paulo", "Centro", "Rua A", 2000.00);
        vendedor.adicionarSalario(2200.00);
        vendedor.adicionarSalario(2300.00);
        vendedor.adicionarSalario(2400.00);
        return vendedor;
    }

    public static Vendedor criarVendedor2() {
        Vendedor vendedor = new Vendedor("Maria", 25, "Loja Exemplo", "São Paulo", "Centro", "Rua B", 2500.00);
        vendedor.adicionarSalario(2600.00);
        vendedor.adicionarSalario(2700.00);
        vendedor.adicionarSalario(2800.00);
        return vendedor;
    }

    public static Cliente criarCliente() {
        return new Cliente("Carlos", 40, "São Paulo", "Centro", "Rua C");
    }
}


