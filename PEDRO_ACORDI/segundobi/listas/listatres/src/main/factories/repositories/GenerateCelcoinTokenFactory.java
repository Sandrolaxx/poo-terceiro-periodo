package main.factories.repositories;

import data.protocols.Celcoin.IGenerateCelcoinToken;
import infra.api.Celcoin.GenerateCelcoinToken;

public class GenerateCelcoinTokenFactory {
    public static IGenerateCelcoinToken getGenerateCelcoinToken(){
        return new GenerateCelcoinToken();
    }
}
