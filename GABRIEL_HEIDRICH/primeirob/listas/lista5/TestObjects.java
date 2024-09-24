package lista5;

public class TestObjects {

    public static void main(String[] args) {
        Vendedor vendedor1 = new Vendedor("Sandro", 28, 3000.0, new double[]{3000.0, 3100.0, 3200.0});
        Vendedor vendedor2 = new Vendedor("Marcelo", 51, 3500.0, new double[]{3500.0, 3600.0, 3700.0});

        Cliente cliente1 = new Cliente("Enzo", 15, "Cascavel", "Country", "Rua Victor Meirelles");
        
        Loja loja = new Loja("Myy Plant", "15.763.678/0001-70", new Vendedor[]{vendedor1, vendedor2}, new Cliente[]{cliente1});

        loja.apresentarSe();
        System.out.println("Quantidade de Clientes: " + loja.contarClientes());
        System.out.println("Quantidade de Vendedores: " + loja.contarVendedores());

        vendedor1.apresentarSe();
        System.out.println("Média de salários: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());

        vendedor2.apresentarSe();
        System.out.println("Média de salários: " + vendedor2.calcularMedia());
        System.out.println("Bônus: " + vendedor2.calcularBonus());

        cliente1.apresentarSe();
    }
}
