package VICTOR_WILLIAM.primeirob.aulas.aula1;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Opcoes\n[1]Soma\n[2]Subtração");
        int opcao = sc.nextInt();

        System.out.println("Informe o primeiro valor!");
        int valueOne = sc.nextInt();

        System.out.println("Informe o segundo valor!");
        int valueTwo = sc.nextInt();

        if (opcao == 1) {
            System.out.println("Realizando soma");
            System.out.println(valueOne + valueTwo);
        }

        if (opcao == 2) {
            System.out.println("Realizando subtração");
            System.out.println(valueOne - valueTwo);
        }

        String valor = valueOne > valueTwo ? "Valor um eh maior" : "Valor dois eh maior";

        System.out.println(valor);

        sc.close();
    }
}
