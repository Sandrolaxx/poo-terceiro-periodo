package ISAQUI_CAMARGO_BARAI.primeirob.listas.listaseis;

import java.util.Date;
import java.util.ArrayList;

class ProcessaPedido {

    Pedido processar(int id, Date dataCriacao, Date dataVencimentoReserva, String cliente, String vendedor, String loja, ArrayList<Item> itens) {
        Pedido pedido = new Pedido(id, dataCriacao, dataVencimentoReserva, cliente, vendedor, loja);
        pedido.itens = itens;
        return pedido;
    }

    boolean confirmarPagamento(Pedido pedido) {
        Date dataAtual = new Date();
        if(verificarValidadeReserva(pedido.dataVencimentoReserva, dataAtual)) {
            pedido.dataPagamento = dataAtual;
            System.out.println("Pagamento confirmado!");
            return true;
        } else {
            System.out.println("A reserva venceu, pagamento não pode ser confirmado.");
            return false;
        }
    }

    private boolean verificarValidadeReserva(Date dataVencimentoReserva, Date dataAtual) {
        return dataAtual.before(dataVencimentoReserva);
    }
}