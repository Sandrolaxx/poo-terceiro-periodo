package VICTOR_WILLIAM.primeirob.aulas.aulaDois;

public class EstruturaControle {
    public static void main(String[] args) {
        int valor = 10;

        // if else if else eh uma estrutura de controle que permite a execucao de um bloco de codigo caso uma condicao seja verdadeira
        if (valor > 6) {
            System.out.println("Valor maior que 6");
        } else if (valor < 6) {
            System.out.println("Valor menor que 6");
        } else {
            System.out.println("Valor igual a 6");
        }

        // Switch e case sao estruturas de controle que permitem a execucao de um bloco de codigo caso uma condicao seja verdadeira
        switch (valor) {
            case 1:
                System.out.println("Valor igual a 1");
                break;
            case 2:
                System.out.println("Valor igual a 2");
                break;
            case 10:
                System.out.println("Valor igual a 10");
                break;
            default:
                System.out.println("Valor diferente de 1, 2 e 10");
        }
    }
}
