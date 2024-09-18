package EDILSON_ALVES.primeirob.listas.listaseis;


public class Pedido{
    public int id;
    public String dataCriacao;
    public String dataPagamento;
    public String dataVencimentoReserva;
    public String cliente;
    public String vendedor;
    public String Loja; 
    public Item[] itens;

    public Pedido(int id, String dataCriacao, String dataPagamento, String dataVencimentoReserva, String cliente,String vendedor, String loja, Item[] itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.Loja = loja;
        this.itens = itens;
    }
    public double calcularValorTotal(){
        double soma = 0.0;

        for (Item item : itens) {
           soma += item.getValor();
        }

        return soma;
    }



}
