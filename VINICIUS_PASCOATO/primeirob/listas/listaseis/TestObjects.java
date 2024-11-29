package primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;

public class TestObjects {

    public static Loja criarLoja() {
        Endereco enderecoLoja = new Endereco("SP", "São Paulo", "Centro", "123", "Apt 1");
        return new Loja("Myy Plant", enderecoLoja);
    }

    public static Vendedor criarVendedor1() {
        Endereco enderecoVendedor = new Endereco("SP", "São Paulo", "Centro", "456", "Apt 2");
        Vendedor vendedor = new Vendedor("Carlos", 30, enderecoVendedor, 3000.0);
        vendedor.adicionaSalario(3000.0);
        vendedor.adicionaSalario(3200.0);
        vendedor.adicionaSalario(3100.0);
        return vendedor;
    }

    public static Vendedor criarVendedor2() {
        Endereco enderecoVendedor = new Endereco("SP", "São Paulo", "Centro", "789", "Apt 3");
        Vendedor vendedor = new Vendedor("Ana", 25, enderecoVendedor, 2500.0);
        vendedor.adicionaSalario(2500.0);
        vendedor.adicionaSalario(2600.0);
        vendedor.adicionaSalario(2550.0);
        return vendedor;
    }

    public static Cliente criarCliente() {
        Endereco enderecoCliente = new Endereco("SP", "São Paulo", "Centro", "321", "Apt 4");
        return new Cliente("João", 40, enderecoCliente);
    }
}

