package primeirob.aulas.aulasete;

public class CieloGateway implements IGateway {
    
    public boolean realizarTrxCartao() {

        System.out.println("Realizando transação do cartão na Cielo.");

        return true;
    }

}
