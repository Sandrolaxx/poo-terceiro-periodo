package main.factories.usecases;

import data.protocols.Celcoin.IConsultBills;
import data.usecasesimplementation.CheckBills;
import domain.usecases.ICheckBills;

public class CheckBillsFactory {
    public static ICheckBills getCheckBills(IConsultBills consultBills){
        return new CheckBills(consultBills);
    }
}
