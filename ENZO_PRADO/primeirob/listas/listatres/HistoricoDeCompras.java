package ENZO_PRADO.primeirob.listas.listatres;

public class HistoricoDeCompras {

    private static int[] historicoDePlantas = new int[100]; 
    private static double[] historicoDeValores = new double[100];
    private static double[] historicoDeDescontos = new double[100];
    public static int novaCompra = 0;

    public static void Armazenamento(int qtdPlantas, double valor, double desconto) {
        if (novaCompra < 100) { 
            historicoDePlantas[novaCompra] = qtdPlantas;
            historicoDeValores[novaCompra] = valor;
            historicoDeDescontos[novaCompra] = desconto;
            novaCompra++;
        } else {
            System.out.println("Limite de armazenamento de vendas atingido!");
        }
    }
    
    public static void ExibirArmazenamento() {
        if (novaCompra == 0) {
            System.out.println("Nenhuma compra registrada.");
        } else {
            for (int i = 0; i < novaCompra; i++) {
                System.out.println("Venda número: " + (i));
                System.out.println("Quantidade de plantas vendidas: " + historicoDePlantas[i]);
                System.out.println("Valor da compra: R$ " + historicoDeValores[i]);
                System.out.println("Desconto aplicado: R$ " + historicoDeDescontos[i]);
                System.out.println("-----------------------------------");
            }
        }
    }
}


     
    
