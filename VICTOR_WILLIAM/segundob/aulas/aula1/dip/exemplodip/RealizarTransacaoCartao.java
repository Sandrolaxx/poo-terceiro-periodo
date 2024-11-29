public class RealizarTransacaoCartao {
    public void executar(IntegracaoAdquirente integracaoAdquirente) {
        String escolha = "STONE";
        TransacaoCartao trx = new TransacaoCartao();

        trx.setDadosCartao("1234 5678 9012 3456");
        trx.setValor(100.0);

        integracaoAdquirente.realizarTransacaoCartao(trx);

    }
}
