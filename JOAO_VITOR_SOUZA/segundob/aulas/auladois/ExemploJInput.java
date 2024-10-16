package segundob.aulas.auladois;

import javax.swing.JOptionPane;

public class ExemploJInput {
    
    public static void main(String[] args) {
        
        String opcao =  JOptionPane.showInputDialog(null,
            "Selecione uma opção\n" + "Realizar Flxo\n" + "Sair",
            "Selecione opção",
            JOptionPane.QUESTION_MESSAGE
            
        );

        JOptionPane.showMessageDialog(null, "A opção selecionada foi " + opcao,
         "A opção selecionada", JOptionPane.INFORMATION_MESSAGE);
    }
}
