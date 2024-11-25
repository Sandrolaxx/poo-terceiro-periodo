package segundob.listas.listatres;

public class BankingService {
    
    private IUserInterface gui;

    public BankingService(IUserInterface gui){
        this.gui = gui;
     }
     public Integer showMenu(){
        return gui.showFunctionScreenMenu();
    }
}
