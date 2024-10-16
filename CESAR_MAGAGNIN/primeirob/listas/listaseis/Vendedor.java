package primeirob.listas.listaseis;

public class Vendedor extends Funcionario {
    private static final long serialVersionUID = 1L;

    public Vendedor(String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        super(nome, idade, loja, endereco, salarioBase, salarioRecebido);
    }

    @Override
    public double calcularBonus() {
        return getSalarioBase() * 0.15;
    }

    @Override
    public String toString() {
        return super.toString() + ", bonus=" + calcularBonus() + '}';
    }
}
