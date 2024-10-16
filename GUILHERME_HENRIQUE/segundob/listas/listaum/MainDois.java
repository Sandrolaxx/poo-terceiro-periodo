package GUILHERME_HENRIQUE.segundob.listas.listaum;

import javax.swing.JOptionPane;

public class MainDois {
    
    public static void main(String[] args) {
        try {
            exibirCalculadora();
        } catch (MinhaExcecaoPersonalizada e) {
            e.mostrarMensagemErro();
        }
    }

    // 5
    public static void exibirCalculadora() throws MinhaExcecaoPersonalizada {
        String[] operacoes = {"Adição", "Subtração", "Multiplicação", "Divisão"};
        int operacaoEscolhida = JOptionPane.showOptionDialog(null, "Escolha uma operação:", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);
        
        if (operacaoEscolhida < 0) {
            throw new MinhaExcecaoPersonalizada("Nenhuma operação foi selecionada.");
        }
        
        try {
            String input1 = JOptionPane.showInputDialog("Digite o primeiro número:");
            String input2 = JOptionPane.showInputDialog("Digite o segundo número:");
            
            double numero1 = Double.parseDouble(input1);
            double numero2 = Double.parseDouble(input2);
            double resultado = 0;
            
            switch (operacaoEscolhida) {
                case 0:
                    resultado = numero1 + numero2;
                    break;
                case 1:
                    resultado = numero1 - numero2;
                    break;
                case 2:
                    resultado = numero1 * numero2;
                    break;
                case 3:
                    if (numero2 == 0) {
                        throw new MinhaExcecaoPersonalizada("Divisão por zero não é permitida.");
                    }
                    resultado = numero1 / numero2;
                    break;
                default:
                    throw new MinhaExcecaoPersonalizada("Operação inválida.");
            }
            
            JOptionPane.showMessageDialog(null, "Resultado: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            throw new MinhaExcecaoPersonalizada("Entrada inválida. Por favor, digite números válidos.");
        }
    }
    
    static class MinhaExcecaoPersonalizada extends Exception {
        public MinhaExcecaoPersonalizada(String mensagem) {
            super(mensagem);
        }
        
        public void mostrarMensagemErro() {
            JOptionPane.showMessageDialog(null, getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
