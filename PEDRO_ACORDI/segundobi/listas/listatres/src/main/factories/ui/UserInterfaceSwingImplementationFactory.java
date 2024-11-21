package main.factories.ui;

import domain.usecases.ICheckBills;
import domain.usecases.ICheckInstitutions;
import presentation.implementation.UserInterfaceSwingImplementation;
import presentation.usecases.IUserInterface;

public class UserInterfaceSwingImplementationFactory {
    public static IUserInterface getUserInterfaceSwingImplementation(ICheckBills checkBills, ICheckInstitutions checkInstitutions){
        return new UserInterfaceSwingImplementation(checkBills, checkInstitutions);
    }
}
