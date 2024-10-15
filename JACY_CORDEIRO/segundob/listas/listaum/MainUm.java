package segundob.listas.listaum;

import javax.swing.JOptionPane;

// Classe principal que contém todas as atividades
public class MainUm {

    public static void main(String[] args) {
        // ATV1
        exibirMensagem();
        
        // ATV2
        solicitarNome();
        
        // ATV3
        apresentarOpcoes();
        
        // ATV4
        try {
            throw new MinhaExcecaoPersonalizada("Este é um erro personalizado");
        } catch (MinhaExcecaoPersonalizada e) {
            exibirErro(e.getMessage());
        }
    }

    // ATV1 - Método para exibir "Olá, Mundo!"
    public static void exibirMensagem() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }

    // ATV2 - Método para solicitar o nome do usuário
    public static void solicitarNome() {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        if (nome != null && !nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + nome + "!", "Boas-vindas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ATV3 - Método para apresentar opções
    public static void apresentarOpcoes() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha != -1) { // Verifica se uma opção foi escolhida
            JOptionPane.showMessageDialog(null, "Você escolheu: " + opcoes[escolha], "Opção escolhida", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // ATV4 - Exceção personalizada
    public static class MinhaExcecaoPersonalizada extends Exception {
        public MinhaExcecaoPersonalizada(String mensagem) {
            super(mensagem);
        }
    }

    // Método para exibir um diálogo de erro
    public static void exibirErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

