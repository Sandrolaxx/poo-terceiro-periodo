package DIONATAN_DARIZ.segundob.listas.listaum;

import javax.swing.JOptionPane;

public class Atividades {
    public static void main(String[] args) {
        escolherAtividade();
    }

    // Atividade 03 Integrado com as outras atividades
    public static void escolherAtividade() {
        String[] opcoes = {"Exibir 'Olá, Mundo!' (Atividade 01)", 
                           "Boas-vindas (Atividade 02)", 
                           "Calculadora (Atividade 05)"};

        int escolha = JOptionPane.showOptionDialog(null, 
                                                   "Escolha uma atividade", 
                                                   "Menu de Atividades", 
                                                   JOptionPane.DEFAULT_OPTION, 
                                                   JOptionPane.INFORMATION_MESSAGE, 
                                                   null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                exibirMensagem(); // Atividade 01
                break;
            case 1:
                boasVindas(); // Atividade 02
                break;
            case 2:
                calculadora(); // Atividade 05
                break;
            default:
                JOptionPane.showMessageDialog(null, "Nenhuma atividade escolhida.");
        }
    }

    // Atividade 01
    public static void exibirMensagem() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // Atividade 02
    public static void boasVindas() {
        String nome = JOptionPane.showInputDialog(null, "Qual é o seu nome?");
        JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + nome + "!");
    }

    // Atividade 05
    public static void calculadora() {
        String[] opcoesCalc = {"Soma", "Subtração", "Multiplicação", "Divisão"};

        int operacao = JOptionPane.showOptionDialog(null, 
                                                    "Escolha uma operação", 
                                                    "Calculadora", 
                                                    JOptionPane.DEFAULT_OPTION, 
                                                    JOptionPane.QUESTION_MESSAGE, 
                                                    null, opcoesCalc, opcoesCalc[0]);

        try {
            double num1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o primeiro número:"));
            double num2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o segundo número:"));
            double resultado = 0;

            switch (operacao) {
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
                        throw new Erro("Não é possível dividir por zero.");
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Operação inválida.");
                    return;
            }

            JOptionPane.showMessageDialog(null, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (Erro e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Atividade 04
    public static class Erro extends Exception {
        public Erro(String mensagem) {
            super(mensagem);
        }
    }
}
