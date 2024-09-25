package ROBSON_DE_LIMA.primeirob.listas.listaCinco;
public class TestObjects {

    public static void main(String[] args) {
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor1();
        Vendedor vendedor2 = criarVendedor2();
        Cliente cliente = criarCliente();

        // Apresentação da Loja
        loja.apresentarse();

        // Adicionando vendedores e cliente à loja
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente);

        // Apresentação dos vendedores e cliente
        vendedor1.apresentarse();
        vendedor2.apresentarse();
        cliente.apresentarse();

        // Exibindo contagem de vendedores e clientes
        System.out.println("Quantidade de Vendedores: " + loja.contarVendedores());
        System.out.println("Quantidade de Clientes: " + loja.contarClientes());

        // Exemplo de cálculo de média salarial e bônus
        vendedor1.adicionarSalario(2000);
        vendedor1.adicionarSalario(2200);
        vendedor1.adicionarSalario(2400);

        System.out.println("Média Salarial de " + vendedor1.nome + ": " + vendedor1.calcularMedia());
        System.out.println("Bônus de " + vendedor1.nome + ": " + vendedor1.calcularBonus());
    }

    public static Loja criarLoja() {
        return new Loja("Myy Plant", "Myy Plant Comércio de Plantas LTDA", "12.345.678/0001-90", "São Paulo", "Centro", "Rua das Flores, 100");
    }

    public static Vendedor criarVendedor1() {
        return new Vendedor("João", 30, "Myy Plant", "São Paulo", "Centro", "Rua das Flores, 100", 2000);
    }

    public static Vendedor criarVendedor2() {
        return new Vendedor("Maria", 25, "Myy Plant", "São Paulo", "Centro", "Rua das Árvores, 200", 2500);
    }

    public static Cliente criarCliente() {
        return new Cliente("Carlos", 40, "São Paulo", "Jardim", "Rua das Palmeiras, 300");
    }
}

