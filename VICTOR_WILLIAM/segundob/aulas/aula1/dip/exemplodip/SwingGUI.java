import javax.swing.JOptionPane;

public class SwingGUI implements InterfaceUsuario{

    public void apresentarMenu() {
        System.out.println("Menu \n [1] Realizar trx \n [2] Consultar trx \n [3] Sair");

        JOptionPane.showMessageDialog(
            null, 
            msg, 
            "MENU", 
            JOptionPane.INFORMATION_MESSAGE
        );
        
    }
    
}
