public class ConsoleGUI implements InterfaceUsuario {

    @Override
    public void apresentarMenu() {
        System.out.println("Apresentando menus");
        System.out.println("[1] Realizar trx");
        System.out.println("[2] Consultar trx");
        System.out.println("[3] Sair");
    }
}