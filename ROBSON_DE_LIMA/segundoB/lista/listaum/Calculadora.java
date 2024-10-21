package segundoB.lista.listaum;

import javax.swing.JOptionPane;

public class Calculadora {

    static class ExcecaoPersonalizada extends Exception {
        public ExcecaoPersonalizada(String mensagemErro) {
            super(mensagemErro);
            JOptionPane.showMessageDialog(null, mensagemErro, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void calculadora() {
        String[] operacoes = {" Somar ", " Subtrair ", " Multiplicar ", " Dividir "};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma operação:",
                "Calculadora",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                operacoes,
                operacoes[0]
        );

        try {
            String num1Str = JOptionPane.showInputDialog("Digite o primeiro número:");
            String num2Str = JOptionPane.showInputDialog("Digite o segundo número:");
            if (num1Str == null || num2Str == null) {
                throw new ExcecaoPersonalizada("Entrada inválida: Poh! ta de brincadeira faz com números.");
            }

            double num1 = Double.parseDouble(num1Str);
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
                        throw new ExcecaoPersonalizada("Erro: Divisão por zero não né Ai Não dá.");
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    throw new ExcecaoPersonalizada("Nenhuma operação válida foi selecionada.");
            }

            JOptionPane.showMessageDialog(null, "Resultado: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            try {
                throw new ExcecaoPersonalizada("Entrada inválida: Poh! ta de brincadeira faz com números.");
            } catch (ExcecaoPersonalizada ex) {
                System.out.println("Erro capturado: " + ex.getMessage());
            }
        } catch (ExcecaoPersonalizada e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        calculadora();
    }
}
