package lista5;

public class Vendedor {
    private String nome;
    private int idade;
    private double salarioBase;
    private double[] salariosRecebidos;

    public Vendedor(String nome, int idade, double salarioBase, double[] salariosRecebidos) {
        this.nome = nome;
        this.idade = idade;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = salariosRecebidos;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return soma / salariosRecebidos.length;
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
