package main.factories.usecases;

import data.protocols.Celcoin.IGetInstitutions;
import data.usecasesimplementation.CheckInstitutions;
import domain.usecases.ICheckInstitutions;

public class CheckInstitutionsFactory {
    public static ICheckInstitutions getCheckInstitutions(IGetInstitutions getInstitutions) {
        return new CheckInstitutions(getInstitutions);
    }
}
