package segundob.aulas.aulaum.dip.exemplodip;

public class ConsoleGUI implements IInterfaceUsuario {

    @Override
    public void apresentarMenu() {
        System.out.println("Menu");
        System.out.println("[1] Realizar trx");
        System.out.println("[2] Consultar trx");
        System.out.println("[3] Sair");
    }
    
}
