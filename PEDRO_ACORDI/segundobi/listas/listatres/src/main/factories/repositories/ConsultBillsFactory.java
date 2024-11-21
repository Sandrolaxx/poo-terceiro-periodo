package main.factories.repositories;

import data.protocols.Celcoin.IConsultBills;
import data.protocols.Celcoin.IGenerateCelcoinToken;
import infra.api.Celcoin.ConsultBills;

public class ConsultBillsFactory {

    public static IConsultBills getConsultBills(IGenerateCelcoinToken generateCelcoinToken){
        return new ConsultBills(generateCelcoinToken);
    }

}
