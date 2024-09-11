package MARCUS_PENSO.Lista5;

public class TestObjects {

    public static void main(String[] args) {
        Loja loja = criarLoja();  // Criando loja
        loja.apresentarse();

        System.out.println("Quantidade de Vendedores: " + loja.contarVendedores());
        System.out.println("Quantidade de Clientes: " + loja.contarClientes());

        // Exibir informações dos vendedores e calcular bônus e média de salários
        for (Vendedor vendedor : loja.vendedores) {
            vendedor.apresentarse();
            System.out.println("Média dos salários: " + vendedor.calcularMedia());
            System.out.println("Bônus: " + vendedor.calcularBonus());
        }

        // Exibir informações do cliente
        loja.clientes[0].apresentarse();
    }

    // Método para criar a loja
    public static Loja criarLoja() {
        Vendedor[] vendedores = {criarVendedor1(), criarVendedor2()};
        Cliente[] clientes = {criarCliente()};
        return new Loja("Myy Plant", "Gabrielinha Comércio de Plantas Ltda", "12.345.678/0001-99", "Centro", "Comercial", "Rua Principal, 123", vendedores, clientes);
    }

    // Criando vendedores
    public static Vendedor criarVendedor1() {
        double[] salarios = {2200, 2100, 2300};
        return new Vendedor("João", 30, "Myy Plant", "Centro", "Comercial", "Rua Principal, 123", 2000, salarios);
    }

    public static Vendedor criarVendedor2() {
        double[] salarios = {1850, 1900, 2000};
        return new Vendedor("Maria", 25, "Myy Plant", "Centro", "Comercial", "Rua Principal, 123", 1800, salarios);
    }

    // Criando cliente
    public static Cliente criarCliente() {
        return new Cliente("Pedro", 35, "Centro", "Comercial", "Rua Secundária, 456");
    }
}
