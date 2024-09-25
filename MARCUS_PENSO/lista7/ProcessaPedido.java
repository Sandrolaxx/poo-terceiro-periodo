package MARCUS_PENSO.lista7;
import java.util.ArrayList;
import java.util.Date;
public class ProcessaPedido {
    public Pedido processar(int id, Date dataCriacao, Cliente cliente, Vendedor vendedor, Loja loja, ArrayList<Item> itens) {
        Date dataVencimentoReserva = new Date(dataCriacao.getTime() + 3 * 24 * 60 * 60 * 1000); // Reserva vence em 3 dias
        return new Pedido(id, dataCriacao, null, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }
    public boolean confirmarPagamento(Pedido pedido, Date dataAtual) {
        return !dataAtual.after(pedido.getDataVencimentoReserva());
    }
}