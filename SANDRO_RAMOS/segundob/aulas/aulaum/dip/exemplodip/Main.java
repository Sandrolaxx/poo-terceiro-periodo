package segundob.aulas.aulaum.dip.exemplodip;

public class Main {
    
    public static void main(String[] args) {
        
        RealizarTransacaoCartao realizarTransacaoCartao = new RealizarTransacaoCartao();

        IntegracaoStoneTrxCartao integracaoStone = new IntegracaoStoneTrxCartao();
        IntegracaoCieloTrxCartao integracaoCielo = new IntegracaoCieloTrxCartao();

        realizarTransacaoCartao.executar(integracaoStone);
    }

}
