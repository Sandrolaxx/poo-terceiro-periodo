package ENZO_PRADO.primeirob.aulas.aulaum;

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe o valor um: ");

        int valorUm = leitor.nextInt();
        

        int valorDois = 2;
        String valor = valorDois > valorUm ? "É maior" : "É menor";
        System.out.println(valor);
    }
}
