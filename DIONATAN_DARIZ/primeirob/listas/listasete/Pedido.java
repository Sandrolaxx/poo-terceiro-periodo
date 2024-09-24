package DIONATAN_DARIZ.primeirob.listas.listasete;

public class Pedido {
    private String nomeCliente;
    private Item item;
    private int quantidade;

    public Pedido(String nomeCliente, Item item, int quantidade) {
        this.nomeCliente = nomeCliente;
        this.item = item;
        this.quantidade = quantidade;
    }

    public double calcularTotal() {
        return item.getPreco() * quantidade;
    }

    public String toString() {
        return "Cliente: " + nomeCliente + ", Item: " + item.getNome() + ", Quantidade: " + quantidade + ", Total: R$ " + calcularTotal();
    }
}
