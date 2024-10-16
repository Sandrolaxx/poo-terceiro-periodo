package segundob.aula.auladois;


import javax.swing.JOptionPane;

public class ExemploJInput {

    public static void main(String[] args) {

        String opcao = JOptionPane.showInputDialog(
                null,
                "Selecione uma opção\n[1] " +
                        "Realizar fluxo x\n[2]Realizar fluxo y\n[3]Sair",
                "Selecione opção",
                JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "Opção selecionada " + opcao,
                "Opção selecionada",
                JOptionPane.INFORMATION_MESSAGE);

    }

}