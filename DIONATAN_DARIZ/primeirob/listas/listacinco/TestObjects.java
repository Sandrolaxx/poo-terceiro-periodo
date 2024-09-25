package DIONATAN_DARIZ.primeirob.listas.listacinco;

public class TestObjects {

    public static void main(String[] args) {
        Loja loja = criarLoja();
        Vendedor vendedorUm = criarVendedor("Pedro", 26, 3000.00, "Flor do Campo");
        Vendedor vendedorDois = criarVendedor("Joaquim", 56, 3200.00, "Flor do Campo");
        Cliente cliente = criarCliente("Ana", "30", "Laranjeiras do Sul", "São Francisco", "Rua das Palmeiras");

        loja.vendedores[0] = vendedorUm;
        loja.vendedores[1] = vendedorDois;
        loja.clientes[0] = cliente;

        loja.apresentarse();

        System.out.println("Quantidade de vendedores: " + loja.contarVendedores());
        System.out.println("Quantidade de clientes: " + loja.contarClientes());

        vendedorUm.apresentarse();
        vendedorDois.apresentarse();
        cliente.apresentarse();

        vendedorUm.calcularBonus();
        vendedorDois.calcularBonus();
    }

    public static Loja criarLoja() {
        Loja loja = new Loja();
        loja.nome = "Flor do Campo";
        loja.fantasia = "Flor do Campo LTDA";
        loja.cnpj = "50.422.035/0001-97";
        loja.cidade = "Laranjeiras do Sul";
        loja.bairro = "Centro";
        loja.rua = "Rua dos Campos";
        loja.vendedores = new Vendedor[10];
        loja.clientes = new Cliente[20];
        return loja;
    }

    public static Vendedor criarVendedor(String nome, int idade, double salarioBase, String loja) {
        Vendedor vendedor = new Vendedor();
        vendedor.nome = nome;
        vendedor.idade = idade;
        vendedor.salarioBase = salarioBase;
        vendedor.loja = loja;
        inicializarSalarioRecebido(vendedor, salarioBase);
        return vendedor;
    }

    public static void inicializarSalarioRecebido(Vendedor vendedor, double salarioBase) {
        vendedor.salarioRecebido[0] = salarioBase;
        vendedor.salarioRecebido[1] = salarioBase * 1.1;
        vendedor.salarioRecebido[2] = salarioBase * 1.2;
    }

    public static Cliente criarCliente(String nome, String idade, String cidade, String bairro, String rua) {
        Cliente cliente = new Cliente();
        cliente.nome = nome;
        cliente.idade = idade;
        cliente.cidade = cidade;
        cliente.bairro = bairro;
        cliente.rua = rua;
        return cliente;
    }
}
