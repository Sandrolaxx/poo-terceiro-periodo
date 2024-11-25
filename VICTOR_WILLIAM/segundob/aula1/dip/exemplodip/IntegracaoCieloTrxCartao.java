public class IntegracaoCieloTrxCartao implements IntegracaoAdquirente {

    public TransacaoCartao realizarTransacaoCartao(TransacaoCartao trx) {
        System.out.println("Executando Transacao na Cielo");
        trx.setNsu("222204444")
    }
}