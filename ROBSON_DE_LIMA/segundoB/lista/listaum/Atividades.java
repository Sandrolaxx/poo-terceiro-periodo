package segundoB.lista.listaum;

import javax.swing.JOptionPane;

public class Atividades {
    //só mensagem//
    public static void exibirMensagem() {
        JOptionPane.showMessageDialog(null, "Olá!");
    }//pergunta e caixa de texto//
    public static void boasVindas() {
        String nome = JOptionPane.showInputDialog("Qual seu nome:");
        if (nome != null && !nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + nome + "!");
        } else {
            JOptionPane.showMessageDialog(null, "Nome inválido, tente novamente.");
        }
    }//opcao//
    public static void exibirOpcoes() {
        String[] opcoes = {" Bem ", " Muito Bem ", " Não Muito Bem "};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Qual seu Nivel de Satisfação hoje?: ",
                "Menu de Opções",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
    switch (escolha) {
            case 0:
                JOptionPane.showMessageDialog(null, "Que bom que está bem!");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Wow Top em Continue Assim!");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Que pena, Procure melhorar Respire Fundo !");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Nenhuma opção foi escolhida.");
                break;
        }
    }//execao//
public static void lancarExcecaoPersonalizada(String mensagemErro) throws ExcecaoPersonalizada {
        throw new ExcecaoPersonalizada(mensagemErro);
    }


    static class ExcecaoPersonalizada extends Exception {
        public ExcecaoPersonalizada(String mensagemErro) {
            super(mensagemErro);
            JOptionPane.showMessageDialog(null, mensagemErro, " OPA ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            
            exibirMensagem();
            boasVindas();
            exibirOpcoes();
            lancarExcecaoPersonalizada(" Calma ai Jovem tenta novamente você errou !");  // Atv4
        } catch (ExcecaoPersonalizada e) {
            
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}
