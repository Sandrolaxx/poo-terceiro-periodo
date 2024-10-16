package listaum;

import javax.swing.JOptionPane;

public class MainDois {
    public static void main(String[] args) {
        try {
            executarCalculadora();
        } catch (MinhaExcecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void executarCalculadora() throws MinhaExcecao {
        String[] operacoes = {"Soma", "Subtração", "Multiplicação", "Divisão"};
        int operacaoEscolhida = JOptionPane.showOptionDialog(
                null,
                "Escolha a operação:",
                "Calculadora",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                operacoes,
                operacoes[0]
        );

        if (operacaoEscolhida == -1) {
            throw new MinhaExcecao("Operação não selecionada.");
        }

        double numero1 = solicitarNumero("Digite o primeiro número:");
        double numero2 = solicitarNumero("Digite o segundo número:");
        double resultado = 0;

        switch (operacaoEscolhida) {
            case 0 -> resultado = numero1 + numero2; // Soma
            case 1 -> resultado = numero1 - numero2; // Subtração
            case 2 -> resultado = numero1 * numero2; // Multiplicação
            case 3 -> {
                if (numero2 == 0) {
                    throw new MinhaExcecao("Divisão por zero não é permitida.");
                }
                resultado = numero1 / numero2; // Divisão
            }
            default -> throw new MinhaExcecao("Operação inválida.");
        }

        JOptionPane.showMessageDialog(
                null,
                "O resultado é: " + resultado,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Método para solicitar um número e lidar com a entrada inválida
    private static double solicitarNumero(String mensagem) throws MinhaExcecao {
        try {
            String input = JOptionPane.showInputDialog(mensagem);
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new MinhaExcecao("Entrada inválida. Por favor, digite um número.");
        }
    }
}
