package segundob.listaum;

import javax.swing.JOptionPane;

// Classe principal
public class MainUm {
    
    // ATV1 - Método para exibir "Olá, Mundo!" com JOptionPane
    public static void exibirMensagemSimples() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // ATV2 - Método que solicita o nome do usuário e exibe uma mensagem de boas-vindas
    public static void boasVindas() {
        String nome = JOptionPane.showInputDialog("Digite o seu nome:");
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
    }

    // ATV3 - Método que apresenta uma lista de opções e exibe uma mensagem conforme a escolha
    public static void exibirOpcoes() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", 
                "Menu de Opções", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                null, opcoes, opcoes[0]);

        if (escolha != -1) {
            JOptionPane.showMessageDialog(null, "Você escolheu: " + opcoes[escolha]);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção foi escolhida.");
        }
    }

    // ATV4 - Exceção personalizada
    static class MinhaExcecao extends Exception {
        public MinhaExcecao(String mensagem) {
            super(mensagem);
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Chamando as atividades para execução
        exibirMensagemSimples(); // ATV1
        boasVindas(); // ATV2
        exibirOpcoes(); // ATV3
    }
}
