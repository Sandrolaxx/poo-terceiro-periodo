package DIONATAN_DARIZ.segundob.aulas.auladois;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExemploJOptionSelectBox {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Exemplo");
        List<String> melhoresProfes = List.of("Sandrolax", "Rita", "Elenides", "Euclides");

        String opcao = (String) JOptionPane.showInputDialog(
            null, "Selecione o melhor professor",
            "Selecione opção", 
            JOptionPane.QUESTION_MESSAGE, 
            null, melhoresProfes.toArray(), melhoresProfes.toArray()[0]);

        JOptionPane.showMessageDialog(frame, "Meu professor favorito é:" + opcao);

        System.exit(0);
    }
    
}
