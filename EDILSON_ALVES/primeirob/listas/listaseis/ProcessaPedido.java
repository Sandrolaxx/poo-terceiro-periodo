package EDILSON_ALVES.primeirob.listas.listaseis;

public class ProcessaPedido {


    public Pedido processar(){
        Item item1 = new Item(15, "caneta", "inteiro", 15);
        Item item2 = new Item(20, "lapis", "fisico", 20);
        Item item3 = new Item(15, "borracha", "siringueira", 25);
        Item[] items = {item1,item2,item3};

        Pedido pedido = new Pedido(items);

        for (Item item : items) {
           item.pedido.imprime();
        }

        return pedido;
    }
}
