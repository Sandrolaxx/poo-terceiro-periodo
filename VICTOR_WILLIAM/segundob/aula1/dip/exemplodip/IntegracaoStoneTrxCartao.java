public class IntegracaoStoneTrxCartao implements IntegracaoAdquirente {
    public TransacaoCartao realizarTransacaoCartao(TransacaoCartao trx) {
        System.out.println("Executando transacao na Stone");
        trx.setNsu("111102222")
    }

    return trx;
}