public class IntegracaoCieloTrxCartao implements IntegracaoAdquirente {

    @Override
    public TransacaoCartao realizarTransacaoCartao(TransacaoCartao trx) {
        System.out.println("Executando Transacao na Cielo");
        trx.setNsu("222203333");
 
        return trx;
    }

}