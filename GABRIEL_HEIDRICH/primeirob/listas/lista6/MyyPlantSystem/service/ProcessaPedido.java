package MyyPlantSystem.service; 

import MyyPlantSystem.model.Pedido; 
import java.util.List;
import java.util.ArrayList; 

public class ProcessaPedido {
    private List<Pedido> pedidos;

    public ProcessaPedido() {
        pedidos = new ArrayList<>();
    }

    public ProcessaPedido(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedidos == null) {
            pedidos = new ArrayList<>();
        }
        pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        if (pedidos != null) {
            pedidos.remove(pedido);
        }
    }

    public Pedido buscarPedidoPorId(int id) {
        if (pedidos != null) {
            for (Pedido pedido : pedidos) {
                if (pedido.getId() == id) {
                    return pedido;
                }
            }
        }
        return null; 
    }

}
