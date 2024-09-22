package JOAO_VITOR_NOVAK_GAVA.primeirob.listaCinco.main;

import JOAO_VITOR_NOVAK_GAVA.primeirob.listaCinco.Cliente;
import JOAO_VITOR_NOVAK_GAVA.primeirob.listaCinco.Loja;
import JOAO_VITOR_NOVAK_GAVA.primeirob.listaCinco.Vendedor;

public class TestObject{
    public static void main(String[] args) {
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor1();
        Vendedor vendedor2 = criarVendedor2();
        Cliente cliente = criarCliente();

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente);

        loja.apresentarse();
        System.out.println("Quantidade de Vendedores: " + loja.contarVendedores());
        System.out.println("Quantidade de Clientes: " + loja.contarClientes());

        vendedor1.apresentarse();
        vendedor2.apresentarse();
        cliente.apresentarse();
    }

    public static Loja criarLoja() {
        return new Loja("Loja ABC", "ABC Comércio LTDA", "12.345.678/0001-99", "São Paulo", "Centro", "Rua Principal, 123");
    }

    public static Vendedor criarVendedor1() {
        Vendedor vendedor = new Vendedor("João", 30, "Loja ABC", "São Paulo", "Centro", "Rua Secundária, 456", 2000.0);
        vendedor.adicionarSalario(2100.0);
        vendedor.adicionarSalario(2200.0);
        vendedor.adicionarSalario(2300.0);
        return vendedor;
    }

    public static Vendedor criarVendedor2() {
        Vendedor vendedor = new Vendedor("Maria", 28, "Loja ABC", "São Paulo", "Bela Vista", "Rua Terciária, 789", 2500.0);
        vendedor.adicionarSalario(2600.0);
        vendedor.adicionarSalario(2700.0);
        vendedor.adicionarSalario(2800.0);
        return vendedor;
    }

    public static Cliente criarCliente() {
        return new Cliente("Carlos", "Alameda das Flores, 321", "São Paulo", "Jardins", 35);
    }
}
