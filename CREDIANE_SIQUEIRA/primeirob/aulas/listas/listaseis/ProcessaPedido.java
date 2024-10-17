package primeirob.aulas.listas.listaseis;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProcessaPedido {
    
        public Pedido processar(int id, Date dataCriacao, Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dataCriacao);
            cal.add(Calendar.DATE, 3); // Reserva vence em 3 dias
            Date dataVencimentoReserva = cal.getTime();
            return new Pedido(id, dataCriacao, null, dataVencimentoReserva, cliente, vendedor, loja, itens);
        }
    
        public void confirmarPagamento(Pedido pedido, Date dataAtual) {
            if (!verificarValidadeReserva(pedido, dataAtual)) {
                System.out.println("Reserva vencida, pagamento não pode ser confirmado.");
            } else {
                pedido.setDataPagamento(dataAtual);
                System.out.println("Pagamento confirmado.");
            }
        }
    
        private boolean verificarValidadeReserva(Pedido pedido, Date dataAtual) {
            return dataAtual.before(pedido.getDataVencimentoReserva());
        }
    }


