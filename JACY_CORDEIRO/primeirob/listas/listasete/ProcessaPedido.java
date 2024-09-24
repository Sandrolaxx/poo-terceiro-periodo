//package poo_terceiro_periodo.JACY_CORDEIRO.primeirob.listas.listasete;

import java.util.Date; // Import necessário
import pacote.das.classes.Pedido;
import pacote.das.classes.Cliente;
import pacote.das.classes.Vendedor;

public class ProcessaPedido {

    // Método para processar um novo pedido
    public Pedido processar(int id, Date dataCriacao, Cliente cliente, Vendedor vendedor, String loja) {
        return new Pedido(id, dataCriacao, cliente, vendedor, loja);
    }

    // Método para confirmar o pagamento do pedido
    public boolean confirmarPagamento(Pedido pedido) {
        // Define a data de vencimento como três dias após a criação do pedido
        Date dataVencimentoReserva = new Date(pedido.getDataCriacao().getTime() + (3L * 24 * 60 * 60 * 1000)); // 3 dias
        Date dataAtual = new Date();

        // Verifica se a data atual está antes da data de vencimento
        if (dataAtual.before(dataVencimentoReserva)) {
            // Lógica para confirmar o pagamento
            pedido.setDataPagamento(dataAtual); // Verifique se o método setDataPagamento existe e está correto
            System.out.println("Pagamento confirmado para o pedido " + pedido.getId());
            return true; // Pagamento confirmado
        } else {
            System.out.println("Não é possível confirmar o pagamento. A reserva está vencida.");
            return false; // Reserva vencida, não pode confirmar
        }
    }
}
