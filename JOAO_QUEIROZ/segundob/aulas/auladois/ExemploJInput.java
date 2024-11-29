package segundob.aulas.auladois;

import javax.swing.JOptionPane;

public class ExemploJInput {
    public static void main(String[] args) {
        String opcao = JOptionPane.showInputDialog(
        null, "Selecione uma opção\n[1] " + 
            "Realizar fluxo x\n[2]Realizar fluxo y\n[3]Sair", "Selecione uma opção!", JOptionPane.QUESTION_MESSAGE);

        
    }
}
