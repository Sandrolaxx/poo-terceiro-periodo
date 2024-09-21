package ROBSON_DE_LIMA.primeirob.listas.listaSeis;


import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int idPedido, Date dataCriacao, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        Pedido pedido = new Pedido(idPedido, dataCriacao, cliente, vendedor, loja);
        for (Item item : itens) {
            pedido.adicionarItem(item);
        }
        pedido.gerarDescricaoVenda();
        return pedido;
    }

    public boolean confirmarPagamento(Pedido pedido) {
        return verificarValidadeReserva(pedido);
    }

    private boolean verificarValidadeReserva(Pedido pedido) {
        Date hoje = new Date();
        return hoje.before(pedido.getDataVencimentoReserva());
    }
}
