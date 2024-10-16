package primeirob.listas.listaseis;

public class Gerente extends Funcionario {
    private static final long serialVersionUID = 1L;

    public Gerente(String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    @Override
    public double calcularBonus() {
        return getSalarioBase() * 0.35;
    }

    @Override
    public String toString() {
        return super.toString() + ", bonus=" + calcularBonus() + '}';
    }
}
