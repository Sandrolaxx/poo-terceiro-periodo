package EDILSON_ALVES.primeirob.listas.listacinco;


public class TestObjects {

    public static void main(String[] args) {
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor("edilson", 21, "top", "cafelandia", "Centro", "Rua bacana", 852);
        Vendedor vendedor2 = criarVendedor("Maria", 19, "Looojinha", "São Paul", "Centro", "Rua chata", 2525);
        Cliente cliente = criarCliente("Vinicius", 40, "londrinha", "Centro", "Rua legal");

        loja.adicionarVendedor(vendedor1);
        loja.adicionarVendedor(vendedor2);
        loja.adicionarCliente(cliente);

        loja.contarClientes();
        loja.contarVendedores();
        loja.apresentarse();

        vendedor1.adicionarSalario(2100);
        vendedor1.adicionarSalario(2200);
        vendedor1.adicionarSalario(2300);

        vendedor1.apresentarse();
        System.out.println("Média dos salários: " + vendedor1.calcularMedia());
        System.out.println("Bônus: " + vendedor1.calcularBonus());
    }

    public static Loja criarLoja() {
        return new Loja("Loja A", "Razão Social A", "12345678000195", "São Paulo", "Centro", "Rua 1");
    }

    public static Vendedor criarVendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        return new Vendedor(nome, idade, loja, cidade, bairro, rua, salarioBase);
    }

    public static Cliente criarCliente(String nome, int idade, String cidade, String bairro, String rua) {
        return new Cliente(nome, idade, cidade, bairro, rua);
    }
}
