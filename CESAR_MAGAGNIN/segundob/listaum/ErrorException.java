package segundob.listaum;

import javax.swing.JOptionPane;

public class ErrorException extends RuntimeException {
    public ErrorException(String msgErro) {
        JOptionPane.showMessageDialog(null, msgErro,"Erro!", JOptionPane.ERROR_MESSAGE);
    }
}
