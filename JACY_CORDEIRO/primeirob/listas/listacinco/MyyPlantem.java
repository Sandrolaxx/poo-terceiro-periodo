package JACY_CORDEIRO.primeirob.listas.listacinco;

public class MyyPlantem {
    public static void main(String[] args) {
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor1();
        Vendedor vendedor2 = criarVendedor2();
        Cliente cliente = criarCliente();

        // Adiciona vendedores e clientes à loja
        loja.vendedores.add(vendedor1);
        loja.vendedores.add(vendedor2);
        loja.clientes.add(cliente);

        // Exibe informações da loja
        loja.apresentarse();

        // Exibe informações dos vendedores
        System.out.println("\n--- Vendedor 1 ---");
        vendedor1.apresentarse();
        vendedor1.printSalarios();
        System.out.println("Média Salarial: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());

        System.out.println("\n--- Vendedor 2 ---");
        vendedor2.apresentarse();
        vendedor2.printSalarios();
        System.out.println("Média Salarial: " + vendedor2.calcularMedia());
        System.out.println("Bônus: " + vendedor2.calcularBonus());

        // Exibe informações do cliente
        System.out.println("\n--- Cliente ---");
        cliente.apresentarse();
    }

    // Método para criar uma loja
    public static Loja criarLoja() {
        return new Loja("Myy Plant", "Gabrielinha Plantas LTDA", "12.345.678/0001-99", "Cascavel", "Centro", "Rua das Flores");
    }

    // Método para criar o primeiro vendedor
    public static Vendedor criarVendedor1() {
        Vendedor vendedor = new Vendedor("Carlos", 30, "Myy Plant", "Cascavel", "Centro", "Rua das Rosas", 3000.0);
        vendedor.adicionarSalario(3200.0, 0);
        vendedor.adicionarSalario(3000.0, 1);
        vendedor.adicionarSalario(3100.0, 2);
        return vendedor;
    }

    // Método para criar o segundo vendedor
    public static Vendedor criarVendedor2() {
        Vendedor vendedor = new Vendedor("Mariana", 28, "Myy Plant", "Cascavel", "Centro", "Rua dos Girassóis", 3500.0);
        vendedor.adicionarSalario(3600.0, 0);
        vendedor.adicionarSalario(3550.0, 1);
        vendedor.adicionarSalario(3500.0, 2);
        return vendedor;
    }

    // Método para criar um cliente
    public static Cliente criarCliente() {
        return new Cliente("João", 45, "Cascavel", "Centro", "Rua das Palmeiras");
    }
}
