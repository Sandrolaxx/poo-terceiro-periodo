package GUILHERME_HENRIQUE.primeirob.listas.listacinco;

public class TestObjects {
    public static void main(String[] args) {
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor("Carlos", 30, "Loja A", 3000);
        Vendedor vendedor2 = criarVendedor("Ana", 25, "Loja B", 2500);
        Cliente cliente = criarCliente("João", 40, "São Paulo", "Centro", "Rua C");

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente);

        loja.apresentarse();
        System.out.println("Total de Vendedores: " + loja.contarVendedores());
        System.out.println("Total de Clientes: " + loja.contarClientes());

        vendedor1.apresentarse();
        System.out.println("Média Salarial de " + vendedor1.getNome() + ": " + vendedor1.calcularMedia());
        System.out.println("Bônus de " + vendedor1.getNome() + ": " + vendedor1.calcularBonus());

        vendedor2.apresentarse();
        System.out.println("Média Salarial de " + vendedor2.getNome() + ": " + vendedor2.calcularMedia());
        System.out.println("Bônus de " + vendedor2.getNome() + ": " + vendedor2.calcularBonus());

        cliente.apresentarse();
    }

    public static Loja criarLoja() {
        return new Loja("Myy Plant", "Gabrielinha LTDA", "12.345.678/0001-90", "São Paulo", "Centro", "Rua Principal");
    }

    public static Vendedor criarVendedor(String nome, int idade, String loja, double salarioBase) {
        return new Vendedor(nome, idade, loja, salarioBase);
    }

    public static Cliente criarCliente(String nome, int idade, String cidade, String bairro, String rua) {
        return new Cliente(nome, idade, cidade, bairro, rua);
    }
}
