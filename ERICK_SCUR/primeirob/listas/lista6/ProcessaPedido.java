package ERICK_SCUR.primeirob.listas.lista6;

import javax.swing.*;
import java.util.Date;
import java.util.List;

class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }

    public void confirmarPagamento(Pedido pedido) {
        if (verificarValidadeReserva(pedido)) {
            JOptionPane.showMessageDialog(null, "Pagamento confirmado!");
        } else {
            JOptionPane.showMessageDialog(null, "Reserva vencida. Pagamento não confirmado.");
        }
    }

    private boolean verificarValidadeReserva(Pedido pedido) {
        Date dataAtual = new Date();
        return dataAtual.before(pedido.getDataVencimentoReserva());
    }
}
