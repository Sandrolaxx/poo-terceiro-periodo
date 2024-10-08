package CREDIANE_SIQUEIRA.primeirob.listas.listacinco;

public class TestObjects {
    public static void main(String[] args) {
        
        Vendedor vendedorUm = new Vendedor();

        vendedorUm.nome = "Camila";
        vendedorUm.idade = 35;
        vendedorUm.loja = "Florisbela";
        vendedorUm.cidade = "Bela Vista";
        vendedorUm.bairro = "Via Bela";
        vendedorUm.rua = "Luna Maria da Silva";
        vendedorUm.salarioBase = 1000.0;
        vendedorUm.salarioRecebido = new Double[] {1000.0, 2000.0, 3000.0};

        vendedorUm.apresentarse();

        Vendedor vendedorDois = new Vendedor();
        
        vendedorDois.nome = "Claudia";
        vendedorDois.idade = 40;
        vendedorDois.loja = "Florisbela";
        vendedorDois.cidade = "Bela Vista";
        vendedorDois.bairro = "Via Bela";
        vendedorDois.rua = "Luna Maria da Silva";
        vendedorDois.salarioBase = 500.0;
        vendedorDois.salarioRecebido = new Double[] {500.0, 1500.0, 2000.0};

        vendedorDois.apresentarse();

        Cliente clienteUm = new Cliente();

        clienteUm.nome = "Laura";
        clienteUm.idade = 25;
        clienteUm.cidade = "Bela Vista";
        clienteUm.bairro = "Via Bela";
        clienteUm.rua = "João Garcia";

        clienteUm.apresentarse();

        Cliente clienteDois = new Cliente();

        clienteDois.nome = "Maria";
        clienteDois.idade = 32;
        clienteDois.cidade = "Bela Vista";
        clienteDois.bairro = "Via Bela";
        clienteDois.rua = "Clarice Lispector";

        clienteDois.apresentarse();

        Loja loja = new Loja();

        loja.nomeFantasia = "Java Floricultura";
        loja.razaoSocial = "Java Floricultura. LTDA";
        loja.cnpj = "549.542.625/0001-51";
        loja.cidade = "Bela Vista";
        loja.bairro = "Via Bela";
        loja.rua = "Luna Maria da Silva";

        loja.apresentarse();


        loja.adicionarVendedor(vendedorUm, 0);
        loja.adicionarVendedor(vendedorDois, 1);
        loja.adicionarCliente(clienteUm, 0);
        loja.adicionarCliente(clienteDois, 1);

        loja.contarVendedor(vendedorUm);
        loja.contarVendedor(vendedorDois);
        loja.contarCliente(clienteUm);
        loja.contarCliente(clienteDois);

    }
}
