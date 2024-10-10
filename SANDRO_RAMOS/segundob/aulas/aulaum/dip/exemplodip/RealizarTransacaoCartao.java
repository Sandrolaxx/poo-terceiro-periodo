package segundob.aulas.aulaum.dip.exemplodip;

public class RealizarTransacaoCartao {

    public void executar(IIntegracaoAdquirente integracao) {
        // Realizar transacao de cartão
        String escolha = "STONE";
        TransacaoCartao trx = new TransacaoCartao();

        trx.setDadosCartao("092183902103012");
        trx.setValor(50.00);
                
        integracao.realizarTransacaoCartao(trx);
    }

}
