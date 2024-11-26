package segundob.bankingappdois.src.infra.console;

import java.util.Scanner;

import segundob.bankingappdois.src.domain.dto.LoginDTO;
import segundob.bankingappdois.src.domain.dto.UserAccountDTO;
import segundob.bankingappdois.src.domain.repositories.IUserInterface;

public class ConsoleUI implements IUserInterface {

    private Scanner input = new Scanner(System.in);

    @Override
    public Integer showInitialScreenMenu() {
        System.out.println("Bem vindo ao Banking JooJ");;
        System.out.println("[1] Realizar Login");
        System.out.println("[2] Criar conta");
        System.out.println("[3] Sair");

        Integer option = input.nextInt();

        return option;

    }

    @Override
    public Integer showHomeMenu(String userName) {
        System.out.println("az\");
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showHomeMenu'");
    }

    @Override
    public LoginDTO getLoginData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLoginData'");
    }

    @Override
    public UserAccountDTO getCreateUserData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCreateUserData'");
    }

    @Override
    public void showErrorMsg(String msg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showErrorMsg'");
    }

    @Override
    public void showExitMessage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showExitMessage'");
    }
    
    
}
