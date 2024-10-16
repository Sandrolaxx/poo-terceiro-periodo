package segundoB.aulas.aulaDois;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Jselect {
    public static void main(String[] args) {
        JFrame frame = new JFrame("exemplo JOptionpane - ShowInputDialog Selections");
        List<String> melhoresProfs = List.of("Sandro", "Rita", "Elaine");

        String melhorProfs = (String) JOptionPane.showInputDialog(frame,
                "Qual seu Professor Favorito?",
                "O Melhor Professor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                melhoresProfs.toArray(),
                melhoresProfs.toArray()[0]);
        JOptionPane.showMessageDialog(frame, "meu professor favorito é: " + melhorProfs);
        System.exit(0);
    }
}