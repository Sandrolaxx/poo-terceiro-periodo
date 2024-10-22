package VINICIUS_PASCOATO.segundob.listas.listaum;

import javax.swing.JOptionPane;

public class MainUm {

    public static void main(String[] args) {
        
        // ATV1
        olaMundo();
        
        // ATV2
        boasVindas();
        
        // ATV3
        mostrarOpcoes();
        
        // ATV4
        try {
            gerarErro();
        } catch (MinhaExcecao e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ATV1 - "Olá, Mundo!"
    public static void olaMundo() {
        JOptionPane.showMessageDialog(null, "Olá mundo!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }

    // ATV2 - Mensagem de boas-vindas
    public static void boasVindas() {
        String nome = JOptionPane.showInputDialog(null, "Qual seu nome?");
        JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + nome + "!", "Boas-vindas", JOptionPane.INFORMATION_MESSAGE);
    }

    // ATV3 - Lista de opções
    public static void mostrarOpcoes() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, "Você escolheu a Opção 1");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Você escolheu a Opção 2");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Você escolheu a Opção 3");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Nenhuma opção foi escolhida.");
        }
    }

    // ATV4 - Exceção personalizada
    public static void gerarErro() throws MinhaExcecao {
        throw new MinhaExcecao("Ocorreu um erro!");
    }

    static class MinhaExcecao extends Exception {
        public MinhaExcecao(String mensagem) {
            super(mensagem);
        }
    }
}
