package segundob.listas.listatres;

import javax.swing.JOptionPane;

public class SwingUserInterface implements IUserInterface {

    @Override
    public Integer showFunctionScreenMenu() {
        String menu = "---------CONSULTAS DISPONIVEIS------------"
        .concat("\n[1] Listagem de convênios")
        .concat("\n[2] Consulta de Boletos")
        .concat("\n[3] Sair");

        String escolha = JOptionPane.showInputDialog(null, menu, "Menu incial de funções", JOptionPane.INFORMATION_MESSAGE);
        return Integer.parseInt(escolha);
    }
    
}
