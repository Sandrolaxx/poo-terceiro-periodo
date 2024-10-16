package listaum;

import javax.swing.JOptionPane;

// ATV1
public class MainUm {
    public static void main(String[] args) {
        exibirMensagem();
        solicitarNome();
        apresentarListaOpcoes();
        try {
            lançarExcecao();
        } catch (MinhaExcecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para ATV1
    public static void exibirMensagem() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    // ATV2
    public static void solicitarNome() {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
    }

    // ATV3
    public static void apresentarListaOpcoes() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Menu de Opções",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        switch (escolha) {
            case 0 -> JOptionPane.showMessageDialog(null, "Você escolheu a Opção 1.");
            case 1 -> JOptionPane.showMessageDialog(null, "Você escolheu a Opção 2.");
            case 2 -> JOptionPane.showMessageDialog(null, "Você escolheu a Opção 3.");
            default -> JOptionPane.showMessageDialog(null, "Nenhuma opção escolhida.");
        }
    }

    // ATV4 - Exceção personalizada
    public static void lançarExcecao() throws MinhaExcecao {
        throw new MinhaExcecao("Ocorreu um erro personalizado!");
    }
}

// Exceção personalizada para a ATV4
class MinhaExcecao extends Exception {
    public MinhaExcecao(String mensagem) {
        super(mensagem);
    }
}
