import java.util.Date;

public class Pedido {
    private int id;
    
    private Date dataCriacao;
    private Date dataPagamento;
    
    private Date dataVencimentoReserva; 
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private Item[] itens;

    public Pedido(int id, Date dataCriacao, Date dataVencimentoReserva,
                  Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    public float calcularValorTotal(){
        float valorTotal = 0;
        for(Item item : itens){
            valorTotal += item.getValor();
        }
        return valorTotal;
    }
    public void geraDescricaoVenda() {
        System.out.println("Id do pedido: "+ id +"\nData de criação do peidio: " + Uteis.dataFormatada(dataCriacao) + "\nvalor total: " + calcularValorTotal());
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }
    public Date getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public int getId() {
        return id;
    }
}
