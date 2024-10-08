
package CESAR_MAGAGNIN.primeirob.listas.listaseis;
import java.time.LocalDateTime;
import java.util.List;

public class ProcessaPedido {

    // Método para processar um pedido
    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do pedido deve ser um número positivo.");
        }
        if (cliente == null || vendedor == null || loja == null || itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Dados inválidos para criação do pedido.");
        }
        LocalDateTime dataCriacao = LocalDateTime.now();
        Pedido pedido = new Pedido(id, dataCriacao, cliente, vendedor, loja, itens);
        return pedido;
    }

    // Método para confirmar o pagamento
    public boolean confirmarPagamento(Pedido pedido) {
        if (pedido == null) {
            System.out.println("Pedido inválido.");
            return false;
        }
        if (verificarValidadeReserva(pedido)) {
            pedido.setDataPagamento(LocalDateTime.now());
            System.out.println("Pagamento confirmado para o pedido ID: " + pedido.getId());
            return true;
        } else {
            System.out.println("Reserva vencida. Não é possível confirmar o pagamento do pedido ID: " + pedido.getId());
            return false;
        }
    }

    // Método privado para verificar a validade da reserva
    private boolean verificarValidadeReserva(Pedido pedido) {
        LocalDateTime dataAtual = LocalDateTime.now();
        return !dataAtual.isAfter(pedido.getDataVencimentoReserva());
    }
}
