package MARCUS_PENSO.segundob.listas.listaum;

import javax.swing.JOptionPane;

public class MainDois {

    // Exceção personalizada da ATV4
    static class MinhaExcecaoPersonalizada extends Exception {
        public MinhaExcecaoPersonalizada(String mensagem) {
            super(mensagem);
        }

        public void exibirErro() {
            JOptionPane.showMessageDialog(null, getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ATV5 - Calculadora utilizando JOptionPane
    public static void atv5() {
        String[] operacoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma operação", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);

        if (escolha == JOptionPane.CLOSED_OPTION) {
            return;  // Se o usuário fechar o diálogo
        }

        try {
            String input1 = JOptionPane.showInputDialog("Digite o primeiro número:");
            String input2 = JOptionPane.showInputDialog("Digite o segundo número:");

            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            double resultado = 0;

            switch (escolha) {
                case 0:  // Adição
                    resultado = num1 + num2;
                    break;
                case 1:  // Subtração
                    resultado = num1 - num2;
                    break;
                case 2:  // Multiplicação
                    resultado = num1 * num2;
                    break;
                case 3:  // Divisão
                    if (num2 == 0) {
                        throw new MinhaExcecaoPersonalizada("Erro: Divisão por zero não é permitida.");
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    throw new MinhaExcecaoPersonalizada("Operação inválida.");
            }

            JOptionPane.showMessageDialog(null, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            new MinhaExcecaoPersonalizada("Erro: Entrada inválida. Por favor, insira números válidos.").exibirErro();
        } catch (MinhaExcecaoPersonalizada e) {
            e.exibirErro();
        }
    }

    public static void main(String[] args) {
        // Executa a calculadora
        atv5();
    }
}
