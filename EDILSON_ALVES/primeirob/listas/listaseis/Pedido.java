package EDILSON_ALVES.primeirob.listas.listaseis;


public class Pedido{
    public int id;
    public int dataCriacao;
    public int dataVencimentoReserva;
    public int dataPagamento;
    public String cliente;
    public String vendedor;
    public String Loja; 
    public Item[] itens;

    public Pedido(Item[] itens){
        this.itens = itens;
    }
    public void imprime(){
        System.out.println(this.itens);
    }

    public Pedido(int id, int dataCriacao, int dataPagamento, int dataVencimentoReserva, String cliente,String vendedor, String loja, Item[] itens) {
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
