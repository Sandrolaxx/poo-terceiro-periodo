package ENZO_PRADO.primeirob.listas.listaseis;

import java.util.Date;
import java.util.List;

public class ProcessarPedido {

    public Pedido processar(Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        Pedido pedido = new Pedido();
        pedido.cliente = cliente;
        pedido.vendedor = vendedor;
        pedido.loja = loja;
        pedido.dataCriacao = new Date();  
       
        for (Item item : itens) {
            pedido.adicionarItem(item);
        }

        System.out.println("Pedido processado para o cliente: " + cliente.nome);

        return pedido;
    }

    public boolean confirmarPagamento(Pedido pedido) {
    
        pedido.dataPagamento = new Date();

        if (verificarValidadeReserva(pedido)) {
            System.out.println("Pagamento confirmado na data: " + pedido.dataPagamento);
            return true;
        } else {
            System.out.println("Pagamento não confirmado: a reserva expirou.");
            return false;
        }
    }

    private boolean verificarValidadeReserva(Pedido pedido) { 
        Long diaEmMs = 86400000L;  
        
        Date dataAtual = new Date();

        if (pedido.dataPagamento != null) {
            
            pedido.dataVencimentoReserva = new Date(pedido.dataPagamento.getTime() + (diaEmMs * 3));
            
            if (dataAtual.before(pedido.dataVencimentoReserva)) {
                return true;
            }
        } 
        System.out.println("A reserva expirou ou a data de pagamento não é válida.");
        return false;
    }
}
