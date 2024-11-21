package segundob.aulas.aulaum.dip.exemplodip;

import javax.swing.JOptionPane;

public class SwingGUI implements IInterfaceUsuario {

    @Override
    public void apresentarMenu() {
        String msg = "Menu \n[1] Realizar trx \n[2] Consultar trx" + "\n[3] Sair";

        JOptionPane.showMessageDialog(null,
                msg, "MENU", JOptionPane.INFORMATION_MESSAGE);
    }

}
