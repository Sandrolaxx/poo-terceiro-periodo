package JACY_CORDEIRO.primeirob.listas.listaseis;

import java.util.Date;
import java.util.List;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {
        return new Pedido(id, dataCriacao, cliente, vendedor, loja, itens);
    }

    public void confirmarPagamento(Pedido pedido) {
        if (verificarValidadeReserva(pedido)) {
            pedido.setDataPagamento(new Date());
            System.out.println("Pagamento confirmado.");
        } else {
            System.out.println("Reserva expirada. Pagamento não pode ser confirmado.");
        }
    }

    private boolean verificarValidadeReserva(Pedido pedido) {
        Date dataAtual = new Date();
        return dataAtual.before(pedido.getDataVencimentoReserva());
    }
}

