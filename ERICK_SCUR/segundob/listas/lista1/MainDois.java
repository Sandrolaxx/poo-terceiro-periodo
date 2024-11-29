package ERICK_SCUR.segundob.listas.lista1;

import javax.swing.JOptionPane;

public class MainDois {
    public static void main(String[] args) throws DialogException {
        calculadora();
    }

    public static void calculadora() throws DialogException {
        String[] operacoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        int operacao = JOptionPane.showOptionDialog(
                null,
                "Escolha uma operação:",
                "Calculadora",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                operacoes,
                operacoes[0]
        );

        if (operacao == -1) {
            throw new DialogException("Operação não selecionada.");
        }

        try {
            double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
            double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));
            double resultado = 0;

            switch (operacao) {
                case 0 -> resultado = num1 + num2;
                case 1 -> resultado = num1 - num2;
                case 2 -> resultado = num1 * num2;
                case 3 -> {
                    if (num2 == 0) {
                        throw new ArithmeticException("Divisão por zero!");
                    }
                    resultado = num1 / num2;
                }
                default -> throw new DialogException("Operação inválida.");
            }

            JOptionPane.showMessageDialog(null, "Resultado: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            throw new DialogException("Erro: Entrada inválida. Digite números válidos.");
        } catch (ArithmeticException e) {
            throw new DialogException("Erro: " + e.getMessage());
        }
    }
}
