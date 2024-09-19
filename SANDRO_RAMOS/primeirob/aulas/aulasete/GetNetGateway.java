package primeirob.aulas.aulasete;

public class GetNetGateway implements IGateway {
    
    public boolean realizarTrxCartao() {

        System.out.println("Realizando transação do cartão na GetNet.");

        return true;
    }

}
