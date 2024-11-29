package ERICK_SCUR.segundob.listas.lista1;

import javax.swing.*;

//ATV4
public class DialogException extends Exception {
    public DialogException(String mensagem) {
        super(mensagem);
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
