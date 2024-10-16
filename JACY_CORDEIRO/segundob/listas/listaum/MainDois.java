package segundob.listas.listaum;

import javax.swing.JOptionPane;

// Classe principal para a calculadora
public class MainDois {

    public static void main(String[] args) {
        try {
            calcular();
        } catch (MinhaExcecaoPersonalizada e) {
            exibirErro(e.getMessage());
        }
    }

    // Método para a calculadora
    public static void calcular() throws MinhaExcecaoPersonalizada {
        String[] opcoes = {"Soma", "Subtração", "Multiplicação", "Divisão"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma operação:", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == -1) return; // Se nenhuma opção foi escolhida

        String numero1 = JOptionPane.showInputDialog("Digite o primeiro número:");
        String numero2 = JOptionPane.showInputDialog("Digite o segundo número:");

        double num1;
        double num2;

        // Testar se os números são válidos
        try {
            num1 = Double.parseDouble(numero1);
            num2 = Double.parseDouble(numero2);
        } catch (NumberFormatException e) {
            throw new MinhaExcecaoPersonalizada("Erro: Entrada inválida. Por favor, insira números válidos.");
        }

        double resultado = 0;

        // Realizando a operação escolhida
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
                    throw new MinhaExcecaoPersonalizada("Erro: Divisão por zero não é permitida.");
                }
                resultado = num1 / num2;
                break;
            }

            // Exibir o resultado
            JOptionPane.showMessageDialog(null, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    
        // Método para exibir um diálogo de erro, já mencionado na classe MainUm
        public static void exibirErro(String mensagem) {
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    
        // Exceção personalizada, também mencionada na classe MainUm
        public static class MinhaExcecaoPersonalizada extends Exception {
            public MinhaExcecaoPersonalizada(String mensagem) {
                super(mensagem);
            }
        }
    }
    
