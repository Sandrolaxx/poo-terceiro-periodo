package JOAO_VITOR_SOUZA.primeirob.listas.listaseis;

import java.util.Date;

public class ProcessaPedido {
    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, String loja) {
        return new Pedido(id, cliente, vendedor, loja, null); 
    }

    public boolean confirmarPagamento(Pedido pedido) {
        Date hoje = new Date();
       
        return !hoje.after(pedido.getDataVencimentoReserva());
    }
}

