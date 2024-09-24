package DIONATAN_DARIZ.primeirob.aulas.aulasete;

public class GatewayPagamento {

    public static void main(String[] args) {
        StoneGateway stoneGateway = new StoneGateway();

        transacionar(stoneGateway);
    }

    public static void transacionar(Gateway gateway); {

        gateway.realizarTrxCartao();
    }
    
}
