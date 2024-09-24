package DIONATAN_DARIZ.primeirob.listas.listaseis;

import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
                            Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
        Pedido novoPedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
        System.out.println("Pedido criado com sucesso!");
        return novoPedido;
    }

    public boolean confirmarPagamento(Pedido pedido) {
        if (verificarValidadeReserva(pedido)) {
            System.out.println("Pagamento confirmado para o pedido ID: " + pedido.getId());
            return true;
        } else {
            System.out.println("Não foi possível confirmar o pagamento. A reserva está vencida.");
            return false;
        }
    }

    private boolean verificarValidadeReserva(Pedido pedido) {
        Date dataAtual = new Date();
        if (dataAtual.before(pedido.getDataVencimentoReserva())) {
            return true;
        } else {
            return false;
        }
    }
}
