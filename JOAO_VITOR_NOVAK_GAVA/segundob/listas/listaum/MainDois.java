package segundob.listas.listaum;

import javax.swing.JOptionPane;

// Classe principal
public class MainDois {
    
    // Exceção personalizada para tratamento de erros
    static class MinhaExcecao extends Exception {
        public MinhaExcecao(String mensagem) {
            super(mensagem);
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método da calculadora
    public static void calculadora() throws MinhaExcecao {
        String[] operacoes = {"Soma", "Subtração", "Multiplicação", "Divisão"};
        int operacaoEscolhida = JOptionPane.showOptionDialog(null, "Escolha uma operação", 
                "Calculadora", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                null, operacoes, operacoes[0]);

        if (operacaoEscolhida == -1) {
            throw new MinhaExcecao("Nenhuma operação foi escolhida.");
        }

        try {
            // Solicitando os números para o cálculo
            String num1Str = JOptionPane.showInputDialog("Digite o primeiro número:");
            String num2Str = JOptionPane.showInputDialog("Digite o segundo número:");
            
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double resultado = 0;

            switch (operacaoEscolhida) {
                case 0: // Soma
                    resultado = num1 + num2;
                    break;
                case 1: // Subtração
                    resultado = num1 - num2;
                    break;
                case 2: // Multiplicação
                    resultado = num1 * num2;
                    break;
                case 3: // Divisão
                    if (num2 == 0) {
                        throw new MinhaExcecao("Erro: Divisão por zero não permitida.");
                    }
                    resultado = num1 / num2;
                    break;
            }
            // Exibindo o resultado
            JOptionPane.showMessageDialog(null, "Resultado: " + resultado, 
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            throw new MinhaExcecao("Erro: Entrada inválida. Por favor, insira números válidos.");
        }
    }

    public static void main(String[] args) {
        try {
            calculadora(); // Chamando o método da calculadora
        } catch (MinhaExcecao e) {
            // Tratamento de exceção
            System.err.println(e.getMessage());
        }
    }
}
