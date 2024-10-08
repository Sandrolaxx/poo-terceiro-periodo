package MURILO_WOLFF.primeirob.listas.listaseis;

import java.util.Date;

public class ProcessaPedido {
    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja) {
        return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja.getNomeFantasia());
    }

    public boolean confirmarPagamento(Pedido pedido) {
        Date hoje = new Date();
        return !verificarValidadeReserva(pedido) && hoje.before(pedido.getDataVencimentoReserva());
    }

    private boolean verificarValidadeReserva(Pedido pedido) {
        Date hoje = new Date();
        return hoje.after(pedido.getDataVencimentoReserva());
    }
}

