import java.security.PublicKey;
import java.util.Date;

public class Pedido {
    public int id;
    public Date dataCriacao;
    public Date dataPagamento;
    public Date dataVencimentoReserva;
    public Cliente cliente;
    public Vendedor vendedor;
    public Loja loja;
    public Item[] itens;

    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
                  Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    public float calcularValorTotal(){
        float valorTotal = 0;
        for(Item item : itens){
            valorTotal += item.valor;
        }
        return valorTotal;
    }


}
