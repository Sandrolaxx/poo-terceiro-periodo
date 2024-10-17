package primeirob.aulas.aulas.aulasete;


public class RedeGateway implements IGateway {
    
    public boolean realizarTrxCartao() {

        System.out.println("Realizando transação do cartão na Rede.");

        return true;
    }

}