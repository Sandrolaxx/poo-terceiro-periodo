package ISAQUI_CAMARGO_BARAI.segundob.aulas.auladois;

import javax.swing.JOptionPane;

public class ExemploJInput {
    
    public static void main(String[] args) {
        
        String opcao = JOptionPane.showInputDialog(
            null, "Selecione uma opção: \n[1] Abrir conta" +
            "\n[2] Encerrar conta\n[3] Sair",
            "Selecione a opção",
            JOptionPane.QUESTION_MESSAGE
        );

        JOptionPane.showMessageDialog(null, "Usuário selecionou a opção: " + opcao);

        System.exit(0);
    }
    
}
