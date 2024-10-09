package primeirob.listas.listacinco;

public class Calculadora {
    public static void main(String[] args) {
        Loja loja = TestObjects.criarLoja();
        Vendedor vendedor1 = TestObjects.criarVendedor("Carlos", 30, loja, "Centro", "Centro", "Rua 1", 3000.0);
        Vendedor vendedor2 = TestObjects.criarVendedor("Ana", 25, loja, "Centro", "Centro", "Rua 2", 3500.0);
        Cliente cliente1 = TestObjects.criarCliente("Mariana", 28, "Centro", "Centro", "Rua 3");
        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente1);
        loja.apresentarse();
        System.out.println("Número de Vendedores: " + loja.contarVendedores());
        System.out.println("Número de Clientes: " + loja.contarClientes());
        vendedor1.apresentarse();
        System.out.printf("Média de Salários: %.2f%n", vendedor1.calcularMedia());
        System.out.printf("Bônus: %.2f%n", vendedor1.calcularBonus());
        cliente1.apresentarse();
    }
}

