package ROBSON_DE_LIMA.primeirob.listas.listaSeis;

import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {
        return new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }

    public void confirmarPagamento(Pedido pedido) {
        if (verificarValidadeReserva(pedido.getDataVencimentoReserva())) {
            System.out.println("Pagamento confirmado!");
        } else {
            System.out.println("Reserva vencida, pagamento não pode ser confirmado.");
        }
    }

    private boolean verificarValidadeReserva(Date dataVencimentoReserva) {
        Date hoje = new Date();
        return !hoje.after(dataVencimentoReserva);
    }
}

