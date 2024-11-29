package segundoB.aulas.aulaDois;

import javax.swing.*;

public class ExJbala {
    public static void main(String[] args) {
        JFrame frame = new JFrame("exemplo JOption - ShowInputDialog");

        //solicitando ao user opçao
        String opcao = JOptionPane.showInputDialog(frame,
                "Selecione uma Opção: \n[1] Entradas \n" +
                        "[2] Saidas \n[3] Encerrar",
                "Selecione  uma das Opções",
                JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(frame,"Optou pela Opção: " + opcao);
        System.exit(0);
    }
}