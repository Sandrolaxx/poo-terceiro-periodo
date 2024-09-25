package EDILSON_ALVES.primeirob.listas.listaseis;

import java.util.Date;

public class Menu {
    public static void main(String[] args) {
        // Inicializando endereços
        Endereco endereco1 = new Endereco("Paraná", "Cafelandia", "Pioneiro", 12, "Casa");
        Endereco endereco2 = new Endereco("Santa Catarina", "Cascavel", "Sete", 772, "Casa");

        // Criando um gerente
        Gerente gerente = new Gerente("Edilson", 19, "Alegria", endereco1, 123, new double[]{1500, 1600, 1700});
        
        // Criando itens
        Item item1 = new Item(1, "Caneta", "Bic", 15.00);
        Item item2 = new Item(2, "Caderno", "Espiral", 25.00);
        
        // Criando um array de itens para o pedido
        Item[] itens = {item1, item2};

        // Criando um pedido
        Pedido pedido = new Pedido(1, new Date(), new Date(), new Date(), "Cliente Exemplo", "Vendedor Exemplo", "Loja Exemplo", itens);
        
        // Imprimindo detalhes do pedido
        pedido.imprime();

        // Processando o pedido
        ProcessaPedido processador = new ProcessaPedido();
        processador.processar();
    }
}
