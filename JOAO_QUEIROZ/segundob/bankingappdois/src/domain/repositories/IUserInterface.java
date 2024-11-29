package segundob.bankingappdois.src.domain.repositories;

import segundob.bankingappdois.src.domain.dto.LoginDTO;
import segundob.bankingappdois.src.domain.dto.UserAccountDTO;

public interface IUserInterface {
    
    //CONTRATO - MÉTODOS
    Integer showInitialScreenMenu();

    Integer showHomeMenu(String userName);

    LoginDTO getLoginData();

    UserAccountDTO getCreateUserData();

    void showErrorMsg(String msg);

    void showExitMessage();

}
