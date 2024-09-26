package MURILO_WOLFF.primeirob.listas.listasete;

import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
        Date dataAtual = new Date();
        return new Pedido(id, dataAtual, cliente, vendedor, loja, itens);
    }

    public boolean confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();
        if (verificarValidadeReserva(pedido, dataAtual)) {
            pedido.setDataPagamento(dataAtual);
            System.out.println("Pagamento confirmado com sucesso!");
            return true;
        } else {
            System.out.println("Reserva vencida. Não foi possível confirmar o pagamento.");
            return false;
        }
    }

    private boolean verificarValidadeReserva(Pedido pedido, Date dataAtual) {
        return dataAtual.before(pedido.getDataVencimentoReserva());
    }
}