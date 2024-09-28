package MATHEUS.primeirob.atividades.listatres;

public class Produto {
    double valorUnitarioPlanta;
    int quantidadePlanta;


    public double getValorTotalProduto() {
        return valorUnitarioPlanta * quantidadePlanta;
    }
}
