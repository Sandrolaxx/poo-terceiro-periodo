package segundob.aulas.aulaum.dip.exemplodip;

public class IntegracaoStoneTrxCartao implements IIntegracaoAdquirente {
    
    @Override
    public TransacaoCartao realizarTransacaoCartao(TransacaoCartao trx) {
        System.out.println("Executando transação na STONE");
        trx.setNsu("912309123");

        return trx;
    }

}
