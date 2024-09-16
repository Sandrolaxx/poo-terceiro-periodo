package DIONATAN_DARIZ.primeirob.listas.listaseis;

import java.util.Date;

public class ProcessaPedido {

    public void processar(Pedido pedido) {
        System.out.println("Pedido processado com sucesso!");
        pedido.gerarDescricaoVenda();
    }

    public void confirmarPagamento(Pedido pedido) {
        if (verificarValidadeReserva(pedido)) {
            System.out.println("Pagamento confirmado!");
        } else {
            System.out.println("Reserva vencida. Não é possível confirmar o pagamento.");
        }
    }

    private boolean verificarValidadeReserva(Pedido pedido) {
        Date hoje = new Date();
        return hoje.before(pedido.getDataVencimentoReserva());
    }
}
