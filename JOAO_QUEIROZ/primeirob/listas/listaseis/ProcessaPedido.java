package listas.listaseis;

import java.util.Date;

public class ProcessaPedido {

    public void processar(Pedido pedido) {
        pedido.gerarDescricaoVenda();
    }

    public boolean confirmarPagamento(Pedido pedido) {
        if (verificarValidadeReserva(pedido)) {
            System.out.println("Pagamento confirmado.");
            return true;
        } else {
            System.out.println("Reserva vencida. Pagamento não confirmado.");
            return false;
        }
    }

    private boolean verificarValidadeReserva(Pedido pedido) {
        Date dataAtual = new Date();
        return dataAtual.before(pedido.dataVencimentoReserva);
    }
}
