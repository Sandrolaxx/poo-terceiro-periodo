package segundob.aulas.auladois;

import javax.swing.JOptionPane;

public class MagagninExeption extends RuntimeException {

    public MagagninExeption(String mensagemErro) {
        JOptionPane.showMessageDialog(null, mensagemErro,
                "Erro!", JOptionPane.ERROR_MESSAGE);
    }

}
