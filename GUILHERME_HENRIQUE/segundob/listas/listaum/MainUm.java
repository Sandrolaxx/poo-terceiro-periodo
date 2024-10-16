package GUILHERME_HENRIQUE.segundob.listas.listaum;
import javax.swing.JOptionPane;

public class MainUm {
    
    public static void main(String[] args) {
        // 1
        exibirMensagemSimples();
        
        // 2
        solicitarNomeEExibirMensagem();
        
        // 3
        exibirListaDeOpcoes();
        
        // 4
        try {
            throw new MinhaExcecaoPersonalizada("Ocorreu um erro personalizado!");
        } catch (MinhaExcecaoPersonalizada e) {
            e.mostrarMensagemErro();
        }
    }
    
    // 1
    public static void exibirMensagemSimples() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }
    
    // 2
    public static void solicitarNomeEExibirMensagem() {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
    }
    
    // 3
    public static void exibirListaDeOpcoes() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Seleção",
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
                JOptionPane.showMessageDialog(null, "Nenhuma opção foi selecionada");
        }
    }
    
    // 4 
    static class MinhaExcecaoPersonalizada extends Exception {
        public MinhaExcecaoPersonalizada(String mensagem) {
            super(mensagem);
        }
        
        public void mostrarMensagemErro() {
            JOptionPane.showMessageDialog(null, getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}


    

