package VINICIUS_PASCOATO.primeirob.listas.listasete;

import java.util.Date;
import java.util.ArrayList;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Date dataVencimentoReserva, Loja loja, Cliente cliente, Vendedor vendedor, Item item, int quantidade) {
        ArrayList<Item> itens = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            itens.add(item);
        }

        return new Pedido(id, dataCriacao, null, dataVencimentoReserva, loja, cliente, vendedor, itens);
    }

    public boolean confirmarPagamento(Pedido pedido) {
        Date hoje = new Date();
        if (!verificarValidadeReserva(pedido.getDataVencimentoReserva(), hoje)) {
            System.out.println("Reserva vencida, pagamento não confirmado.");
            return false;
        }
        pedido.setDataPagamento(hoje);
        System.out.println("Pagamento confirmado para o pedido ID: " + pedido.getId());
        return true;
    }

    private boolean verificarValidadeReserva(Date dataVencimentoReserva, Date dataAtual) {
        return !dataAtual.after(dataVencimentoReserva);
    }
}
