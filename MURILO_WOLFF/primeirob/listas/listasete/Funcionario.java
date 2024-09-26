package MURILO_WOLFF.primeirob.listas.listasete;

public abstract class Funcionario extends Pessoa {
    private String loja;
    private double salarioBase;
    private double[] salarioRecebido = new double[3];

    public Funcionario(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getSalarioRecebido(int indice) {
        if (indice >= 0 && indice < salarioRecebido.length) {
            return salarioRecebido[indice];
        } else {
            throw new IllegalArgumentException("Índice de salário inválido.");
        }
    }

    public void setSalarioRecebido(int indice, double salario) {
        if (indice >= 0 && indice < salarioRecebido.length) {
            this.salarioRecebido[indice] = salario;
        } else {
            throw new IllegalArgumentException("Índice de salário inválido.");
        }
    }

    public double calcularMedia() {
        double somaSalarios = 0;
        for (double salario : salarioRecebido) {
            somaSalarios += salario;
        }
        return somaSalarios / salarioRecebido.length;
    }

    public abstract double calcularBonus();
}
