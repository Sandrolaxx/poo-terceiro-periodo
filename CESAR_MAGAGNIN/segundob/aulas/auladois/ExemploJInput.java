package segundob.aulas.auladois;
import javax.swing.JOptionPane;
public class ExemploJInput {
    public static void main(String[] args) {
        String opcao = JOptionPane.showInputDialog(
            null,
            "[1] Fluxo x\n[2] Fluxo y\n[3] Sair",
            "Selecione uma opção",
            JOptionPane.QUESTION_MESSAGE);    

            JOptionPane.showMessageDialog(null,"Usuário selecionou a opção " + opcao);
        }
    
}
