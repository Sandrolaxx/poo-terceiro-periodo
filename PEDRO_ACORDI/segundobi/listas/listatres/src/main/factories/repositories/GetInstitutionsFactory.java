package main.factories.repositories;

import data.protocols.Celcoin.IGenerateCelcoinToken;
import data.protocols.Celcoin.IGetInstitutions;
import infra.api.Celcoin.GetInstitutions;

public class GetInstitutionsFactory {
    public static IGetInstitutions getInstitutions(IGenerateCelcoinToken generateCelcoinToken){
        return new GetInstitutions(generateCelcoinToken);
    }
}
