package segundob.listaum;

import javax.swing.JOptionPane;

public class MainDois {
    public static void main(String[] args) {
        String[] operacoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        String operacaoSelecionada = (String) JOptionPane.showInputDialog(
            null,
            "Selecione a operação:",
            "Calculadora",
            JOptionPane.QUESTION_MESSAGE,
            null,
            operacoes,
            operacoes[0]);
        if (operacaoSelecionada == null) {
            throw new ErrorException("Operação cancelada");
        }

        String primeiroNum = JOptionPane.showInputDialog(null,
        "Digite o primeiro número:",
        "Calculadora",
        JOptionPane.QUESTION_MESSAGE);
        if (primeiroNum == null) {
            throw new ErrorException("Operação cancelada");
        }
        float num1= Float.parseFloat(primeiroNum);
  
        String segundoNum = JOptionPane.showInputDialog(null, "Digite o segundo número:", "Calculadora", JOptionPane.QUESTION_MESSAGE);
        if (segundoNum == null) {
            throw new ErrorException("Operação cancelada");
        }
        float num2 = Float.parseFloat(segundoNum);
   
        float resultado = 0;
   
        switch (operacaoSelecionada) {
            case "Adição":
                resultado = num1 + num2;
                break;
            case "Subtração":
                resultado = num1 - num2;
                break;
            case "Multiplicação":
                resultado = num1 * num2;
                break;
            case "Divisão":
                if (num2 == 0) {
                    throw new ErrorException("Não é possível dividir por zero!");
                }
                else {
                    resultado = num1 / num2;
                }
                break;
            default:
                throw new ErrorException("Opção inválida");
            }

            JOptionPane.showMessageDialog(null, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    } 
}