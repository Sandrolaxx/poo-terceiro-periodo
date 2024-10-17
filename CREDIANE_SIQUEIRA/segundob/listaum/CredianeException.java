package segundob.listaum;

import javax.swing.JOptionPane;

public class CredianeException extends RuntimeException  {
    
    public CredianeException(String message) {
            JOptionPane.showMessageDialog(null, message, "Erro nao esperado", 
            JOptionPane.ERROR_MESSAGE);
    }

}
