package segundob.aulas.aulaum.ocp;

import segundob.aulas.aulaum.srp.Pedido;
import segundob.aulas.aulaum.srp.ProcessaPedido;

public class ProcessaPedidoFrete extends ProcessaPedido {

    @Override
    public Pedido processa(Pedido pedido) {
        super.processa(pedido);

        System.out.println("Calcular frete....");

        return pedido;
    }

}
