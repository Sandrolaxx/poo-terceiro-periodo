package segundob.aulas.aulaum.dip.exemplodip;

public class MainGUI {
    
    public static void main(String[] args) {
        
        SwingGUI swing = new SwingGUI();
        ConsoleGUI console = new ConsoleGUI();

        apresentarMenu(swing);
    }

    public static void apresentarMenu(IInterfaceUsuario ui) {
        ui.apresentarMenu();
    }

}
