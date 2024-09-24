package ALEX_HOFFMANN.primeirob.projetopoo.projeto2;

import java.util.HashMap;
import java.util.Scanner;

public class ConversorDeMoedas {


    private static final int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    private static final HashMap<String, Double> taxas = new HashMap<>();


    static {
        taxas.put("USD", 1.0);
        taxas.put("EUR", 0.85);
        taxas.put("JPY", 110.0);
        taxas.put("GBP", 0.75);
        taxas.put("BRL", 5.3);
    }


    public static String converterParaRomano(int numero) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                resultado.append(romanos[i]);
                numero -= valores[i];
            }
        }
        return resultado.toString();
    }


    public static double converterMoeda(double valor, String de, String para) {
        double taxaDe = taxas.get(de);
        double taxaPara = taxas.get(para);
        return valor * (taxaPara / taxaDe);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Escolha uma opção:");
        System.out.println("1. Converter número inteiro para número romano");
        System.out.println("2. Converter moeda");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:

                System.out.print("Digite um número inteiro entre 1 e 3999: ");
                int numero = scanner.nextInt();


                if (numero < 1 || numero > 3999) {
                    System.out.println("Número fora do intervalo permitido.");
                } else {

                    String numeroRomano = converterParaRomano(numero);
                    System.out.println("O número romano é: " + numeroRomano);
                }
                break;

            case 2:

                System.out.print("Digite o valor a ser convertido: ");
                double valor = scanner.nextDouble();
                System.out.print("Digite a moeda de origem (USD, EUR, JPY, GBP, BRL): ");
                String moedaDe = scanner.next().toUpperCase();
                System.out.print("Digite a moeda de destino (USD, EUR, JPY, GBP, BRL): ");
                String moedaPara = scanner.next().toUpperCase();


                if (taxas.containsKey(moedaDe) && taxas.containsKey(moedaPara)) {
                    double valorConvertido = converterMoeda(valor, moedaDe, moedaPara);
                    System.out.printf("Valor convertido: %.2f %s\n", valorConvertido, moedaPara);
                } else {
                    System.out.println("Moeda inválida.");
                }
                break;

            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
