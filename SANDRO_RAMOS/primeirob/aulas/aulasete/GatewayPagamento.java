package primeirob.aulas.aulasete;

public class GatewayPagamento {

    public static void main(String[] args) {
        StoneGateway stoneGateway = new StoneGateway();
        RedeGateway redeGateway = new RedeGateway();
        CieloGateway cieloGateway = new CieloGateway();
        GetNetGateway getNetGateway = new GetNetGateway();

        transacionar(getNetGateway);
    }

    public static void transacionar(IGateway gateway) {
        gateway.realizarTrxCartao();
    }

    // SEM UTILIZAÇÃO DE INTERFACES
    // transacionar(null, null, null, getNetGateway);
    // }

    // public static void transacionar(StoneGateway stoneGateway,
    // RedeGateway redeGateway, CieloGateway cieloGateway,
    // GetNetGateway getNetGateway) {

    // if (stoneGateway != null) {
    // stoneGateway.realizarTrxCartao();
    // } else if (redeGateway != null) {
    // redeGateway.realizarTrxCartao();
    // } else if (cieloGateway != null) {
    // cieloGateway.realizarTrxCartao();
    // } else if (getNetGateway != null) {
    // getNetGateway.realizarTrxCartao();
    // }

    // }

}
