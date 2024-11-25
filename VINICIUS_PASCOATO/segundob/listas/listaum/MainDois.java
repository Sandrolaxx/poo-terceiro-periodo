package segundob.listas.listaum;

import javax.swing.JOptionPane;

public class MainDois {

    public static void main(String[] args) {
        try {
            calcular();
        } catch (MinhaExcecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void calcular() throws MinhaExcecao {
        String[] operacoes = {"Soma", "Subtração", "Multiplicação", "Divisão"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma operação:", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);

        double num1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o primeiro número:"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o segundo número:"));

        double resultado;

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
                    throw new MinhaExcecao("Divisão por zero não é permitida.");
                }
                resultado = num1 / num2;
                break;
            default:
                throw new MinhaExcecao("Operação inválida.");
        }

        JOptionPane.showMessageDialog(null, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}

// Exceção personalizada que herda de Exception
class MinhaExcecao extends Exception {
    public MinhaExcecao(String mensagem) {
        super(mensagem);
    }
}
