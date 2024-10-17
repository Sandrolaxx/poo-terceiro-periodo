package segundob.listaum;

import javax.swing.JOptionPane;

public class MainDois {

    public static void main(String[] args) {

        String[] opcoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Selecione a operação matemática:",
                "Calculadora",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, 
                null,
                opcoes,
                opcoes[0]
        );

        if (escolha != JOptionPane.CLOSED_OPTION) {
            try {
                String num1Str = JOptionPane.showInputDialog("Digite o primeiro número:");
                double num1 = Double.parseDouble(num1Str);

                String num2Str = JOptionPane.showInputDialog("Digite o segundo número:");
                double num2 = Double.parseDouble(num2Str);

                double resultado = 0;
                switch (escolha) {
                    case 0: 
                        resultado = num1 + num2;
                        break;
                    case 1: 
                        resultado = num1 - num2;
                        break;
                    case 2: 
                        resultado = num1 * num2;
                        break;
                    case 3: 
                        if (num2 == 0) {
                            throw new ArithmeticException("Divisão por zero!");
                        }
                        resultado = num1 / num2;
                        break;
                }

                JOptionPane.showMessageDialog(
                        null,
                        "O resultado é: " + resultado,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Entrada inválida! Digite números válidos.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            } catch (ArithmeticException e) {
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            } 
        }
     }
}
