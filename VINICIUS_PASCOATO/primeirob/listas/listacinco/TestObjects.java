package VINICIUS_PASCOATO.primeirob.listas.listacinco;

public class TestObjects {
    public static void main(String[] args) {
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor1();
        Vendedor vendedor2 = criarVendedor2();
        Cliente cliente = criarCliente();

        loja.adicionaVendedor(vendedor1);
        loja.adicionaVendedor(vendedor2);
        loja.adicionaCliente(cliente);

        loja.apresentarse();
        vendedor1.apresentarse();
        vendedor2.apresentarse();
        cliente.apresentarse();

        System.out.println("Média salarial do vendedor 1: " + vendedor1.calcularMedia());
        System.out.println("Bônus do vendedor 2: " + vendedor2.calcularBonus());

        System.out.println("Total de clientes: " + loja.contarClientes());
        System.out.println("Total de vendedores: " + loja.contarVendedores());
    }

    public static Loja criarLoja() {
        return new Loja("Myy Plant", "Myy Plant LTDA", "12.345.678/0001-99", "Centro", "Rua Principal", "CidadeX");
    }

    public static Vendedor criarVendedor1() {
        Vendedor vendedor = new Vendedor("Carlos", 30, "Myy Plant", "CidadeX", "Centro", "Rua A", 3000.0);
        vendedor.adicionaSalario(3000.0);
        vendedor.adicionaSalario(3200.0);
        vendedor.adicionaSalario(3100.0);
        return vendedor;
    }

    public static Vendedor criarVendedor2() {
        Vendedor vendedor = new Vendedor("Ana", 25, "Myy Plant", "CidadeX", "Centro", "Rua B", 2500.0);
        vendedor.adicionaSalario(2500.0);
        vendedor.adicionaSalario(2600.0);
        vendedor.adicionaSalario(2550.0);
        return vendedor;
    }

    public static Cliente criarCliente() {
        return new Cliente("João", 40, "CidadeX", "Centro", "Rua C");
    }
}
