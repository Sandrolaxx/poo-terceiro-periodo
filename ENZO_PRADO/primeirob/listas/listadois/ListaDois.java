package ENZO_PRADO.primeirob.listas.listadois;

import java.util.Scanner;

public class ListaDois {
    public static void main(String[] args) {
        Scanner opcao = new Scanner(System.in);
        int escolha;
        
        
        do {
            System.out.println("===== Loja da Dona Gabrielinha =====");
            System.out.println("[1] - Fazer compra");
            System.out.println("[2] - Calcular preço total");
            System.out.println("[3] - Pagar");
            System.out.println("[4] - Historico de compras");
            System.out.println("[5] - Sair");
            System.out.println("Escolha uma opção: ");
            escolha = opcao.nextInt();

            switch (escolha) {
                case 1:
                    Calculos.valorDaCompra();
        
                    break;

                case 2:
                    if (Calculos.qtdTotalDePlantas > 10) {

                        System.out.printf("O valor total da compra é: R$ %.2f%n", Calculos.total);
                        System.out.printf("Com 5 porcento de desconto devido a quantidade maior de 10 plantas, fica: R$ %.2f%n", Calculos.total - (Calculos.total * 0.05));

                    }else{
                
                    System.out.printf("O valor total da compra é: R$ %.2f%n", Calculos.total);
                    }
                    break;

                case 3:
                    Calculos.CalcularTroco();
                    break;
                
                case 4: 
                    HistoricoDeCompras.ExibirArmazenamento();

                case 5:
                    System.out.println("Volte sempre");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        } while (escolha != 5);

        opcao.close();
    }
}