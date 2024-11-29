package MARCUS_PENSO.segundob.listas.listaum;

import javax.swing.JOptionPane;

public class MainUm {

    // ATV1 - Método que exibe a mensagem "Olá, Mundo!"
    public static void atv1() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // ATV2 - Método que solicita o nome do usuário e exibe uma mensagem de boas-vindas
    public static void atv2() {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + nome + "!");
    }

    // ATV3 - Método que apresenta uma lista de opções ao usuário e exibe uma mensagem segundo a opção escolhida
    public static void atv3() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Lista de Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        if (escolha == 0) {
            JOptionPane.showMessageDialog(null, "Você escolheu a Opção 1");
        } else if (escolha == 1) {
            JOptionPane.showMessageDialog(null, "Você escolheu a Opção 2");
        } else if (escolha == 2) {
            JOptionPane.showMessageDialog(null, "Você escolheu a Opção 3");
        }
    }

    // ATV4 - Exceção personalizada que apresenta um dialog(ERROR_MESSAGE) com a mensagem do erro ocorrido
    static class MinhaExcecaoPersonalizada extends Exception {
        public MinhaExcecaoPersonalizada(String mensagem) {
            super(mensagem);
        }

        public void exibirErro() {
            JOptionPane.showMessageDialog(null, getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Teste das atividades
        atv1();
        atv2();
        atv3();

        try {
            throw new MinhaExcecaoPersonalizada("Ocorreu um erro personalizado.");
        } catch (MinhaExcecaoPersonalizada e) {
            e.exibirErro();
        }
    }
}
