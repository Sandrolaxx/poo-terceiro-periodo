package segundob.aulas.auladois;

import javax.swing.JOptionPane;

public class ExemploJinput {
    public static void main(String[] args) {
        String opcao = JOptionPane.showInputDialog(null,
         "Selecione uma opcao\n[1] Relizar fluxo x\n[2] Realizar fluxo y",
          "Selecione opcao", 
          JOptionPane.QUESTION_MESSAGE);

          JOptionPane.showMessageDialog(null, "Opcao selecionada", opcao, JOptionPane.INFORMATION_MESSAGE);
        
    }
}
