package primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, String cliente, String vendedor, String loja, ArrayList<Item> itens) {
        Date dataVencimentoReserva = new Date(dataCriacao.getTime() + TimeUnit.DAYS.toMillis(3));
        return new Pedido(id, dataCriacao, dataVencimentoReserva, cliente, vendedor, loja, itens);
    }

    public boolean confirmarPagamento(Pedido pedido, Date dataAtual) {
        return verificarValidadeReserva(pedido.getDataVencimentoReserva(), dataAtual);
    }

    private boolean verificarValidadeReserva(Date dataVencimentoReserva, Date dataAtual) {
        return !dataAtual.after(dataVencimentoReserva);
    }
}