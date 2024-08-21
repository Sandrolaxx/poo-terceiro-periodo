package ENZO_PRADO.primeirob.listas;

import java.util.Scanner;

public class listaum {
    private static float valorCompra = 0;
    private static float total = 0;

    public static void main(String[] args) {
        Scanner opcao = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("===== Loja da Dona Gabrielinha =====");
            System.out.println("[1] - Fazer compra");
            System.out.println("[2] - Calcular preço total");
            System.out.println("[3] - Calcular troco");
            System.out.println("[4] - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = opcao.nextInt();

            switch (escolha) {
                case 1:
                    valorDaCompra();
                    break;

                case 2:
                    System.out.printf("O valor total da compra é: R$ %.2f%n", total);
                    break;

                case 3:
                    CalcularTroco();
                    break;

                case 4:
                    System.out.println("Volte sempre");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        } while (escolha != 4);

        opcao.close();
    }

    public static void valorDaCompra() {
        Scanner compra = new Scanner(System.in);
        int qtdDeTipos, qtdDePlanta;
        float valor;
        valorCompra = 0;

        System.out.print("Digite a quantidade de tipos de plantas compradas: ");
        qtdDeTipos = compra.nextInt();

        for (int i = 1; i <= qtdDeTipos; i++) {
            System.out.print("Digite a quantidade do tipo " + i + ": ");
            qtdDePlanta = compra.nextInt();
            System.out.print("Digite o valor desse tipo: ");
            valor = compra.nextFloat();

            valorCompra += valor * qtdDePlanta;
        }

        System.out.printf("O valor da compra é: R$ %.2f%n", valorCompra);
        total += valorCompra;
    }

    public static void CalcularTroco() {
        Scanner pagamentoScanner = new Scanner(System.in);
        float pagamento, falta, troco;

        System.out.print("Digite o valor pago pelo cliente: ");
        pagamento = pagamentoScanner.nextFloat();

        if (pagamento < total) {
            falta = total - pagamento;

            do {
                System.out.printf("O valor está incorreto, ainda falta: R$ %.2f. Por favor, pague o valor restante: ", falta);
                float valorCorreto = pagamentoScanner.nextFloat();
                falta -= valorCorreto;
                pagamento += valorCorreto;
            } while (falta > 0);

            System.out.println("Valor correto recebido. Obrigado!");

        }

        if (pagamento > total) {
            troco = pagamento - total;
            System.out.printf("Aqui está seu troco: R$ %.2f%n", troco);
        } else if (pagamento == total) {
            System.out.println("Você pagou o valor exato. Obrigado!");
        }

        valorCompra = 0;
        total = 0;
    }
}
