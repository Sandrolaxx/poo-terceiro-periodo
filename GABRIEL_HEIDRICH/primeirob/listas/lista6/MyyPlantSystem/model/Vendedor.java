package MyyPlantSystem.model;

public class Vendedor {
    private Cliente cliente;
    
    public Vendedor(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
}
