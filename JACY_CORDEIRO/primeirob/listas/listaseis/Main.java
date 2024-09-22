package JACY_CORDEIRO.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando um Gerente
        Gerente gerente = new Gerente();
        gerente.setNome("João Silva");
        gerente.setIdade(45);
        gerente.setLoja("Loja Centro");
        gerente.setSalarioBase(5000);
        gerente.apresentarSe();
        System.out.println("Média Salarial: " + gerente.calcularMedia());
        System.out.println("Bônus: " + gerente.calcularBonus());

        // Criando um Endereço
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", 123, "Apto 101");

        // Criando um Cliente
        Cliente cliente = new Cliente("Cliente A", "123.456.789-00", endereco);

        // Criando um Vendedor
        Vendedor vendedor = new Vendedor("Vendedor B", 30, "Loja Centro");

        // Criando Itens
        Item item1 = new Item(1, "Produto A", "Eletrônico", 1000);
        Item item2 = new Item(2, "Produto B", "Móvel", 1500);
        List<Item> itens = new ArrayList<>();
        itens.add(item1);
        itens.add(item2);

        // Criando um Pedido
        ProcessaPedido processador = new ProcessaPedido();
        Pedido pedido = processador.processar(1, new Date(), cliente, vendedor, "Loja Centro", itens);
        pedido.gerarDescricaoVenda();

        // Confirmar Pagamento
        processador.confirmarPagamento(pedido);
    }
}
