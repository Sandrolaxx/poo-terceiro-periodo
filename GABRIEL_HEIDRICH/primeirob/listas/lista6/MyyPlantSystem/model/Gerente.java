package MyyPlantSystem.model; 

import java.util.List;
import java.util.ArrayList;

public class Gerente {
    private List<Vendedor> vendedores;

    public Gerente() {
        this.vendedores = new ArrayList<>();
    }

    public Gerente(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public void addVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public void removeVendedor(Vendedor vendedor) {
        vendedores.remove(vendedor);
    }
  
}
