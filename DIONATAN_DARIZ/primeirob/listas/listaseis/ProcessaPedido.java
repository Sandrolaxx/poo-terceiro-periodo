package DIONATAN_DARIZ.primeirob.listas.listaseis;

import java.util.Date;

public class ProcessaPedido {

    // Método para processar o pedido, recebendo os dados necessários para criação
    public Pedido processar(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva,
                            Cliente cliente, Vendedor vendedor, Loja loja, Item[] itens) {
        Pedido novoPedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
        System.out.println("Pedido criado com sucesso!");
        return novoPedido;
    }

    // Método para confirmar o pagamento, verificando se a reserva não está vencida
    public boolean confirmarPagamento(Pedido pedido) {
        if (verificarValidadeReserva(pedido)) {
            System.out.println("Pagamento confirmado para o pedido ID: " + pedido.getId());
            return true;
        } else {
            System.out.println("Não foi possível confirmar o pagamento. A reserva está vencida.");
            return false;
        }
    }

    // Método privado para verificar se a reserva do pedido está válida (não vencida)
    private boolean verificarValidadeReserva(Pedido pedido) {
        Date dataAtual = new Date();
        if (dataAtual.before(pedido.getDataVencimentoReserva())) {
            return true;
        } else {
            return false;
        }
    }
}
