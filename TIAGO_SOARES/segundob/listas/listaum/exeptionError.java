package segundob.listas.listaum;

import javax.swing.JOptionPane;

public class exeptionError extends RuntimeException {
    public exeptionError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error!", JOptionPane.ERROR_MESSAGE);
    }
}
