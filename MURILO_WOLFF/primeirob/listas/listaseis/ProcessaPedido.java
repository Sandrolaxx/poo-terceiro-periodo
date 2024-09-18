package MURILO_WOLFF.primeirob.listas.listaseis;

import java.util.Date;

public class ProcessaPedido {

    public Pedido processar(int id, Date dataCriacao, Cliente cliente, Vendedor vendedor, String loja, Date dataVencimentoReserva) {
        return new Pedido(id, dataCriacao, dataVencimentoReserva, cliente, vendedor, loja);
    }

    public boolean confirmarPagamento(Pedido pedido, Date dataAtual) {
        if (verificarValidadeReserva(pedido, dataAtual)) {
            System.out.println("Pagamento confirmado para o pedido ID: " + pedido.getId());
            return true;
        } else {
            System.out.println("Falha na confirmação. Reserva vencida para o pedido ID: " + pedido.getId());
            return false;
        }
    }

    private boolean verificarValidadeReserva(Pedido pedido, Date dataAtual) {
        long diferenca = dataAtual.getTime() - pedido.getDataVencimentoReserva().getTime();
        long diasDiferenca = diferenca / (1000 * 60 * 60 * 24); // Converter milissegundos para dias
        return diasDiferenca <= 3;
    }
}

