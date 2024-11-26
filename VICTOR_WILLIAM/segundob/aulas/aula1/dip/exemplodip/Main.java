public class Main {
    public static void main(String[] args) {
        RealizarTransacaoCartao realizarTransacaoCartao = new RealizarTransacaoCartao();

        IntegracaoStoneTrxCartao integracaoStoneTrxCartao = new IntegracaoStoneTrxCartao();
        IntegracaoCieloTrxCartao integracaoCieloTrxCartao = new IntegracaoCieloTrxCartao();

        realizarTransacaoCartao.executar(integracaoStoneTrxCartao);
    }
}