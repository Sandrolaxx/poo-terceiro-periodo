import java.util.Date;

public final class ProcessaPedido {
    public static Pedido processar( Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {

        Long diaEmMs = 86400000l;
        Date dataCriacao = new Date();
        Long msAtual = dataCriacao.getTime();
        Date dataVencimento = new Date(msAtual + (diaEmMs * 3));
        int id = Testaobjeto.ids; 
        Pedido pedido = new Pedido(id, dataCriacao, dataVencimento , cliente, vendedor, loja, itens);
        Testaobjeto.ids = Testaobjeto.ids + 1;
        return pedido;
    }

    public static boolean confirmarPagamento(Pedido pedido) {
        Date dataPagamento = new Date();
        if (verificarValidadeReserva(dataPagamento, pedido.dataVencimentoReserva)) {
            pedido.dataPagamento = dataPagamento;
            return true;
        }

        return false;
    }

    private static boolean verificarValidadeReserva(Date atual,Date reserva){
        return reserva.after(atual);
    }
        


}
