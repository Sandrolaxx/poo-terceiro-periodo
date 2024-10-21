package segundob.listas.listaum;
import javax.swing.JOptionPane;
public class ExececaoCustomizada extends Exception {
    public ExececaoCustomizada(String message){
        JOptionPane.showMessageDialog(null, "Digite algo, por favor", "DIGITE ALGO",JOptionPane.WARNING_MESSAGE);
    }
}
