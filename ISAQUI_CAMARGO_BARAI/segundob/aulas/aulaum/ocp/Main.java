package segundob.aulas.aulaum.ocp;

import segundob.aulas.aulaum.srp.Pedido;

public class Main {
    
    public static void main(String[] args) {
        ProcessaPedidoFrete processaPedidoFrete = new ProcessaPedidoFrete();
        Pedido pedido = new Pedido();

        processaPedidoFrete.processa(pedido);
    }

}
