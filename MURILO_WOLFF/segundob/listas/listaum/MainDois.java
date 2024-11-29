package MURILO_WOLFF.segundob.listas.listaum;

import javax.swing.JOptionPane;

public class MainDois {
    public static void main(String[] args) {
        do {
            String[] opcoes = {"Soma", "Subtração", "Multiplicação", "Divisão", "Sair"};
            String opcao = (String) JOptionPane.showInputDialog(null, "Selecione uma opção", "Calculadora", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcao) {
                case "Soma":
                    soma();
                    break;
                case "Subtração":
                    subtracao();
                    break;
                case "Multiplicação":
                    multiplicacao();
                    break;
                case "Divisão":
                    divisao();
                    break;
                case "Sair":
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    public static void soma(){
        int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o primeiro número:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o segundo número:"));
        JOptionPane.showMessageDialog(null, "A soma dos números é: " + (num1 + num2));
    }

    public static void subtracao(){
        int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o primeiro número:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o segundo número:"));
        JOptionPane.showMessageDialog(null, "A subtração dos números é: " + (num1 - num2));
    }

    public static void multiplicacao(){
        int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o primeiro número:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o segundo número:"));
        JOptionPane.showMessageDialog(null, "A multiplicação dos números é: " + (num1 * num2));
    }

    public static void divisao(){
        int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o primeiro número:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o segundo número:"));
        JOptionPane.showMessageDialog(null, "A divisão dos números é: " + (num1 / num2));
    }
}
