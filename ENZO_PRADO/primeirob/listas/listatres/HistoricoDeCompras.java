package ENZO_PRADO.primeirob.listas.listatres;

import java.util.Scanner;

public class HistoricoDeCompras {

    private static int[] historicoDePlantas = new int[100]; 
    private static double[] historicoDeValores = new double[100];
    private static double[] historicoDeDescontos = new double[100];
    private static int[][] historicodiaMes = new int[12][30];
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

    public static void LancamentoDeVendasDiaMes(){
        Scanner inserir = new Scanner(System.in);
           
        int mes, dia, vendasTotal;
        char escolha = ' ';
        
        System.out.println("Deseja inserir o total em qual mês? (1-12): ");
        mes = inserir.nextInt() - 1; 
        System.out.println("Deseja inserir em qual dia? (1-30): ");
        dia = inserir.nextInt() - 1; 
        System.out.println("Insira a quantidade total de vendas: ");
        vendasTotal = inserir.nextInt();

       if (mes >= 0 && mes < 12 && dia >= 0 && dia < 30) { 
            historicodiaMes[mes][dia] = vendasTotal;
        } else {
            System.out.println("Mês ou dia inválido!");
        } 

    }   

    public static void VerDiaMes(){
        Scanner vizualizacao = new Scanner(System.in);
        int dia, mes, escolha;
        
        System.out.println("[1] - Ver todos os dias preenchidos");
        System.out.println("[2] - Ver dia específico");
        escolha = vizualizacao.nextInt();

        switch (escolha) {
            case 1:
                for(int i = 0; i < 12; i++) { 
                    for(int j = 0; j < 30; j++) { 
                        if (historicodiaMes[i][j] != 0) {
                            System.out.println("Mês: " + (i + 1)); 
                            System.out.println("Dia: " + (j + 1)); 
                            System.out.println("Total de vendas: " + historicodiaMes[i][j]);
                            System.out.println("-------------------------------");
                        } else {
                            System.out.println("Mês: " + (i + 1));
                            System.out.println("Dia: " + (j + 1));
                            System.out.println("Sem histórico de vendas do dia");
                            System.out.println("-------------------------------");
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Deseja visualizar o total de qual mês? (1-12): ");
                mes = vizualizacao.nextInt() - 1; 
                System.out.println("E qual dia? (1-30): ");
                dia = vizualizacao.nextInt() - 1; 
                
                if (mes >= 0 && mes < 12 && dia >= 0 && dia < 30) {
                    System.out.println("Total de vendas no mês " + (mes + 1) + " dia " + (dia + 1) + ": " + historicodiaMes[mes][dia]);
                } else {
                    System.out.println("Mês ou dia inválido!");
                }
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}
