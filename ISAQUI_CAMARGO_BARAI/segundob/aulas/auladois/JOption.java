package ISAQUI_CAMARGO_BARAI.segundob.aulas.auladois;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOption {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo JOptionsPane - ShowMassageDialog");

        JOptionPane.showMessageDialog(frame,
            "Não foi possível se conectar no banco de dados",
            "Erro ao salvar!",
            JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(frame,
            "Erro ao buscar presença do aluno",
            "Erro ao lançar nota!",
            JOptionPane.WARNING_MESSAGE);

        JOptionPane.showMessageDialog(frame,
            "Não foi possível buscar dados externos",
            "Erro ao buscar dados!",    
            JOptionPane.ERROR_MESSAGE);

        System.exit(0);
    }
    
}
