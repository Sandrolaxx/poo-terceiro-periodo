package main.factories.ui;

import domain.usecases.ICheckBills;
import domain.usecases.ICheckInstitutions;
import presentation.implementation.UserInterfaceConsoleImplementation;
import presentation.usecases.IUserInterface;

public class UserInterfaceConsoleImplementationFactory {
    public static IUserInterface getUserInterfaceConsoleImplementation(ICheckBills checkBills, ICheckInstitutions checkInstitutions){
        return new UserInterfaceConsoleImplementation(checkBills, checkInstitutions);
    }
}
