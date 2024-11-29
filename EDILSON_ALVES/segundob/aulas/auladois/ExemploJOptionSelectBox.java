package segundob.aulas.auladois;

import java.util.List;
import javax.swing.JOptionPane;

public class ExemploJOptionSelectBox {
    public static void main(String[] args) {
        List <String> melhorprof = List.of("sad", "edi");

        String opcao = (String) JOptionPane.showInputDialog(null,
        "Seleione o prfo",
        "selecione oopcao",
        JOptionPane.ERROR_MESSAGE
        );
    }
}
