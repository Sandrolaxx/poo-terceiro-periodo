package segundob.aulas.listas.listaum;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Execao extends RuntimeException {

    private final JFrame frame = new JFrame();

    public Execao(String message) {
        JOptionPane.showMessageDialog(frame, message, "Aviso!", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        printarMsg("Joãozeira");
        printarMsg(null);        
    }

    public static void printarMsg(String texto) {
        try {
            if (texto == null) { 
                throw new Execao("Errou!"); 
            }
            System.out.println(texto.length());
        } catch (Execao e) {
            
        }
    }
}

    
    

