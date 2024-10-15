package segundob.aula.aulaum.isp;

public class Financeiro {
    private double saldo;

    public Financeiro(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarReceita(double valor) {
        saldo += valor;
    }
}
