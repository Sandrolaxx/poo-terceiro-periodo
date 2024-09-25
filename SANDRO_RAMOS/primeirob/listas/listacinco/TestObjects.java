package primeirob.listas.listacinco;

public class TestObjects {
    
    public static void main(String[] args) {

        Vendedor vendedorUm = vendedorPadraoUm();
        Vendedor vendedorDois = vendedorPadraoDois();
        
    }

    public static Vendedor vendedorPadraoUm() {
        Vendedor vendedor = new Vendedor("Sandrolax", 20);

        return vendedor;
    }

    public static Vendedor vendedorPadraoDois() {
        Vendedor vendedor = new Vendedor("Roberto", 49);

        return vendedor;
    }

}
