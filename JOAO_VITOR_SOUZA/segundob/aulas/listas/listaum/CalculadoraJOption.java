package segundob.aulas.listas.listaum;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class CalculadoraJOption {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Simples");

        ArrayList<String> operacoes = new ArrayList<>();
        operacoes.add("Adição");
        operacoes.add("Subtração");
        operacoes.add("Multiplicação");
        operacoes.add("Divisão");

        String operacaoSelecionada = (String) JOptionPane.showInputDialog(
                frame,
                "Selecione uma operação:",
                "Calculadora",
                JOptionPane.QUESTION_MESSAGE,
                null,
                operacoes.toArray(),
                operacoes.get(0)
        );

        if (operacaoSelecionada == null) {
            JOptionPane.showMessageDialog(frame, "Nenhuma operação selecionada, encerrando o programa.");
            System.exit(0);
        }

        try {
            double numero1 = Double.parseDouble(JOptionPane.showInputDialog(frame, "Digite o primeiro número:"));
            double numero2 = Double.parseDouble(JOptionPane.showInputDialog(frame, "Digite o segundo número:"));

            double resultado = 0;

            
            switch (operacaoSelecionada) {
                case "Adição":
                    resultado = numero1 + numero2;
                    break;
                case "Subtração":
                    resultado = numero1 - numero2;
                    break;
                case "Multiplicação":
                    resultado = numero1 * numero2;
                    break;
                case "Divisão":
                    if (numero2 == 0) {
                        throw new ArithmeticException("Erro: Divisão por zero não é permitida.");
                    }
                    resultado = numero1 / numero2;
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Operação inválida.");
                    System.exit(0);
            }

            
            JOptionPane.showMessageDialog(frame, "O resultado da " + operacaoSelecionada + " é: " + resultado);

        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(frame, "Erro: Entrada inválida. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

