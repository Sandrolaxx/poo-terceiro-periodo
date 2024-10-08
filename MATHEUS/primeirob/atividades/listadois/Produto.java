package MATHEUS.primeirob.atividades.listadois;


public class Produto {
    double valorUnitarioPlanta;
    int quantidadePlanta;


    public double getValorTotalProduto() {
        return valorUnitarioPlanta * quantidadePlanta;
    }

}
