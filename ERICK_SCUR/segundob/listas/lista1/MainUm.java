package ERICK_SCUR.segundob.listas.lista1;

import javax.swing.JOptionPane;

public class MainUm {
    public static void main(String[] args) {
        helloWorld();
        boasVindas();
        menu();

        try {
            throw new DialogException("Erro de diálogo!");
        } catch (DialogException e) {
            e.printStackTrace();
        }
    }

    //ATV1
    public static void helloWorld() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }

    //ATV2
    public static void boasVindas() {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + nome + "!");
    }

    //ATV3
    public static void menu() {
        String[] opcoes = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Seleção de Opções",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
        if (escolha >= 0 && escolha < opcoes.length) {
            JOptionPane.showMessageDialog(null, "Você escolheu: " + opcoes[escolha]);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção escolhida.");
        }
    }
}
