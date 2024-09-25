
package CESAR_MAGAGNIN.primeirob.listas.listasete;

import java.time.LocalDateTime;
import java.util.List;

public class ProcessaPedido {

    // Método para processar um pedido
    public Pedido processar(int id, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        if (id <= 0 || cliente == null || vendedor == null || loja == null || itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Dados inválidos para o pedido.");
        }
        // Criar novo pedido
        Pedido pedido = new Pedido(id, LocalDateTime.now(), cliente, vendedor, loja, itens);
        pedido.setDataVencimentoReserva(LocalDateTime.now().plusDays(7)); // Exemplo de vencimento
        return pedido;
    }

    // Método para definir a data de pagamento de um pedido
    public void setPagamento(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido inválido.");
        }
        pedido.setDataPagamento(LocalDateTime.now());
    }

    // Verificar data de vencimento de reserva
    public boolean verificarVencimento(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido inválido.");
        }
        return LocalDateTime.now().isBefore(pedido.getDataVencimentoReserva());
    }
}
