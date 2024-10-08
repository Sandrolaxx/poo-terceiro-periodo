package ENZO_PRADO.primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessarPedido {

    public Pedido processarPedido(Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {

        

         Pedido pedido = new Pedido(new Date(), null, null, cliente, vendedor, loja, new ArrayList<>(), 0);
    
       
        for (Item item : itens) {
            pedido.adicionarItem(item);
        }

        System.out.println("Pedido processado para o cliente: " + cliente.getNome());

        return pedido;
    }

    public boolean confirmarPagamento(Pedido pedido) {
    
        pedido.setDataPagamento(new Date());

        if (verificarValidadeReserva(pedido)) {
            System.out.println("Pagamento confirmado na data: " + pedido.getDataPagamento());
            return true;
        } else {
            System.out.println("Pagamento não confirmado: a reserva expirou.");
            return false;
        }
    }

    private boolean verificarValidadeReserva(Pedido pedido) { 
        Long diaEmMs = 86400000L;  
        
        Date dataAtual = new Date();

        if (pedido.getDataPagamento() != null) {
            
            pedido.setDataVencimentoReserva(new Date(pedido.getDataPagamento().getTime() + (diaEmMs * 3)));
            
            if (dataAtual.before(pedido.getDataVencimentoReserva())) {
                return true;
            }
        } 
        System.out.println("A reserva expirou ou a data de pagamento não é válida.");
        return false;
    }
}
