package MyyPlantSystem.app; 
import MyyPlantSystem.model.Cliente;
import MyyPlantSystem.model.Pedido;
import MyyPlantSystem.service.ProcessaPedido; 

import java.util.Date;

public class Main {
    public static void main(String[] args) {
  
        Cliente cliente1 = new Cliente("Gabriel", 19);
        Cliente cliente2 = new Cliente("Maria", 25);
        
        Pedido pedido1 = new Pedido(1, cliente1, new Date(), 100.0);
        Pedido pedido2 = new Pedido(2, cliente2, new Date(), 150.0);
  
        ProcessaPedido processaPedido = new ProcessaPedido();
    
        processaPedido.adicionarPedido(pedido1);
        processaPedido.adicionarPedido(pedido2);

        Pedido pedidoBuscado = processaPedido.buscarPedidoPorId(1);
        if (pedidoBuscado != null) {
            System.out.println("Pedido encontrado: " + pedidoBuscado);
        } else {
            System.out.println("Pedido não encontrado.");
        }

        processaPedido.removerPedido(pedido1);
        Pedido pedidoRemovido = processaPedido.buscarPedidoPorId(1);
        if (pedidoRemovido == null) {
            System.out.println("Pedido removido com sucesso.");
        } else {
            System.out.println("Pedido ainda existe.");
        }
    }
}
