package ENZO_PRADO.primeirob.listas.listatres;

import java.util.Scanner;

import ENZO_PRADO.primeirob.listas.listadois.Calculos;
import ENZO_PRADO.primeirob.listas.listadois.HistoricoDeCompras;

public class ListaTres {public static void main(String[] args) {
        Scanner opcao = new Scanner(System.in);
        int escolha;
        
        
        do {
            System.out.println("===== Loja da Dona Gabrielinha =====");
            System.out.println("[1] - Fazer compra");
            System.out.println("[2] - Calcular preço total");
            System.out.println("[3] - Pagar");
            System.out.println("[4] - Historico de compras");
            System.out.println("[5] - Lançar total do dia");
            System.out.println("[6] - Visualizar total do dia");
            System.out.println("[7] - Sair");
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

                    break;
                case 5: 

                    HistoricoDeCompras.LancamentoDeVendasDiaMes();
                    break;
                case 6:

                    HistoricoDeCompras.VerDiaMes();
                    break;
                
                case 7:
                    System.out.println("Volte sempre");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        } while (escolha != 7);

        opcao.close();
    }
    
}
