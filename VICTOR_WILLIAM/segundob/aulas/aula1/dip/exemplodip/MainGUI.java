public class MainGUI {
    public static void main(String[] args) {
        SwingGUI swing = new SwingGUI();
        ConsoleGUI console = new ConsoleGUI();

        apresentarMenu(swing);
    }

    public static void apresentarMenu(InterfaceUsuario interfaceUsuario) {
        interfaceUsuario.apresentarMenu();
    }
}
