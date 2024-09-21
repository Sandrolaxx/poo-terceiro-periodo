package ENZO_PRADO.primeirob.listas.listadois;

import java.util.Scanner;

public class Calculos {
    public static double valorCompra = 0;
    public static double total = 0;
    public static int qtdTotalDePlantas = 0;
    public static double desconto = 0;

    public static void valorDaCompra() {
        Scanner compra = new Scanner(System.in);
        int qtdDeTipos, qtdDePlanta = 0;
        double valor;
        valorCompra = 0;

        System.out.println("Digite a quantidade de tipos de plantas compradas: ");
        qtdDeTipos = compra.nextInt();

        for (int i = 1; i <= qtdDeTipos; i++) {
            System.out.println("Digite a quantidade do tipo " + i + ": ");
            qtdDePlanta = compra.nextInt();
            System.out.println("Digite o valor desse tipo: ");
            valor = compra.nextDouble();
            
            valorCompra += valor * qtdDePlanta;
            
        }

        System.out.printf("O valor da compra é: R$ %.2f%n", valorCompra);
        total += valorCompra;
        qtdTotalDePlantas += qtdDePlanta;
    }

    public static void CalcularTroco() {
        Scanner pagamentoScanner = new Scanner(System.in);
        double pagamento, falta, troco;

        if (total == 0) {
            System.out.println("Você não possui nada em seu carrinho, por favor adicionar uma planta");
            
        }else{

        if (qtdTotalDePlantas > 10) {
            total = total - (total * 0.05);
            desconto = total * 0.05;
         }


        System.out.println("Digite o valor pago pelo cliente: ");
        pagamento = pagamentoScanner.nextDouble();

        if (pagamento < total) {
            falta = total - pagamento;

            do {
                System.out.printf("O valor está incorreto, ainda falta: R$ %.2f. Por favor, pague o valor restante: ", falta);
                double valorCorreto = pagamentoScanner.nextDouble();
                falta -= valorCorreto;
                pagamento += valorCorreto;
            } while (falta > 0);

            System.out.println("Valor correto recebido. Obrigada!");
        }

        if (pagamento > total) {
            troco = pagamento - total;
            System.out.printf("Aqui está seu troco: R$ %.2f%n", troco);
        } else if(pagamento == total) {
            System.out.println("Você pagou o valor exato. Obrigada!");
        }

        HistoricoDeCompras.Armazenamento(qtdTotalDePlantas, valorCompra, desconto);
        valorCompra = 0;
        total = 0;
        qtdTotalDePlantas = 0;
        desconto = 0;
       
    }
}
}