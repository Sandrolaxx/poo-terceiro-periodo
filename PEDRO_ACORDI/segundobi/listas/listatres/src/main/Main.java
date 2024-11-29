package main;

import data.protocols.Celcoin.IConsultBills;
import data.protocols.Celcoin.IGenerateCelcoinToken;
import data.protocols.Celcoin.IGetInstitutions;
import domain.usecases.ICheckBills;
import domain.usecases.ICheckInstitutions;
import main.factories.repositories.ConsultBillsFactory;
import main.factories.repositories.GenerateCelcoinTokenFactory;
import main.factories.repositories.GetInstitutionsFactory;
import main.factories.ui.UserInterfaceConsoleImplementationFactory;
import main.factories.ui.UserInterfaceSwingImplementationFactory;
import main.factories.usecases.CheckBillsFactory;
import main.factories.usecases.CheckInstitutionsFactory;
import presentation.usecases.IUserInterface;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        IGenerateCelcoinToken generateCelcoinTokenRepository = GenerateCelcoinTokenFactory.getGenerateCelcoinToken();
        IConsultBills consultBillsRepository = ConsultBillsFactory.getConsultBills(generateCelcoinTokenRepository);
        IGetInstitutions getInstitutionsRepository = GetInstitutionsFactory.getInstitutions(generateCelcoinTokenRepository);

        ICheckInstitutions checkInstitutions = CheckInstitutionsFactory.getCheckInstitutions(getInstitutionsRepository);
        ICheckBills checkBills = CheckBillsFactory.getCheckBills(consultBillsRepository);

        IUserInterface userInterface = null;

        String[] options = {"Console (linha de comando)", "Interface Gráfica"};
        int option = JOptionPane.showOptionDialog(
                    null,
                    "Como você deseja ver o sistema?",
                    "Olá",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[1]
            );
        switch (option){
            case 0:
               userInterface = UserInterfaceConsoleImplementationFactory.getUserInterfaceConsoleImplementation(checkBills, checkInstitutions);
               break;
            case 1:
                userInterface = UserInterfaceSwingImplementationFactory.getUserInterfaceSwingImplementation(checkBills, checkInstitutions);
                break;
        }
        userInterface.showMenu();
    }

}
