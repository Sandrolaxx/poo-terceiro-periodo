package segundob.aulas.aulaum.dip.exemplodip;

public class IntegracaoCieloTrxCartao implements IIntegracaoAdquirente {
    
    @Override
    public TransacaoCartao realizarTransacaoCartao(TransacaoCartao trx) {
        System.out.println("Executando transação na Cielo");
        trx.setNsu("912309123");

        return trx;
    }

}
