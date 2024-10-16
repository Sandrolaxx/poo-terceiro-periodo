package primeirob.listas.listacinco;

public class TestObjects {
    static Loja criarLoja() {
        Loja loja = new Loja();
        loja.nomeFantasia = "Myy Plant";
        loja.razaoSocial = "Myy Plant Ltda";
        loja.cnpj = "12.345.678/0001-99";
        loja.cidade = "Cascavel";
        loja.bairro = "Região do lago";
        loja.rua = "Rua 25 de agosto, 285";
        return loja;
    }

    static Vendedor criarVendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, Double salarioBase) {
        Vendedor vendedor = new Vendedor();
        vendedor.nome = nome;
        vendedor.idade = idade;
        vendedor.loja = loja;
        vendedor.cidade = cidade;
        vendedor.bairro = bairro;
        vendedor.rua = rua;
        vendedor.salarioBase = salarioBase;
        vendedor.salarioRecebido.add(salarioBase);
        vendedor.salarioRecebido.add(salarioBase + 100);
        vendedor.salarioRecebido.add(salarioBase + 200);
        return vendedor;
    }

    static Cliente criarCliente(String nome, int idade, String cidade, String bairro, String rua) {
        Cliente cliente = new Cliente();
        cliente.nome = nome;
        cliente.idade = idade;
        cliente.cidade = cidade;
        cliente.bairro = bairro;
        cliente.rua = rua;
        return cliente;
    }
}
