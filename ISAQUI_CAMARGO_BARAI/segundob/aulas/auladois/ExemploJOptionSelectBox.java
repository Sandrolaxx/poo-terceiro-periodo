package ISAQUI_CAMARGO_BARAI.segundob.aulas.auladois;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploJOptionSelectBox {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo JOptionPane - ShowInputDialog SelectOne");
        List<String> melhoresProfes = List.of("Sandro", "Riuta", "Elenilds", "Andrade", "Elaine");

        String melhorProfe = (String) JOptionPane.showInputDialog(frame,
        "Qual é o seu professor favorito?",
        "O melhor profe",
        JOptionPane.QUESTION_MESSAGE,
        null,
        melhoresProfes.toArray(),
        melhoresProfes.toArray()[0]);

        JOptionPane.showMessageDialog(frame, "Meu professor favorito é: " + melhorProfe);

        System.exit(0);
    }
    
}
