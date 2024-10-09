package segundob.aulas.auladois;

import java.util.List;

import javax.swing.JOptionPane;

public class ExemploJOptionSelectBox {

    public static void main(String[] args) {

        List<String> melhoresProfes = List.of("Sandrolax", "Riuta", "Elenilds", "Elaine");

        String opcao = (String) JOptionPane.showInputDialog(
                null,
                "Selecione o melhor professor",
                "Selecione opção",
                JOptionPane.QUESTION_MESSAGE,
                null,
                melhoresProfes.toArray(),
                melhoresProfes.toArray()[0]);

        JOptionPane.showMessageDialog(null,
                "O melhor profe é " + opcao,
                opcao,
                0);

    }

}
