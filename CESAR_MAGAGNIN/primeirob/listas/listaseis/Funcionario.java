package CESAR_MAGAGNIN.primeirob.listas.listaseis;

// Funcionario.java

import java.io.Serializable;

public abstract class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String nome;
    protected int idade;
    protected Loja loja;
    protected Endereco endereco;
    protected double salarioBase;
    protected double[] salarioRecebido; // Pelo menos três valores

    // Construtor
    public Funcionario(String nome, int idade, Loja loja, Endereco endereco, double salarioBase, double[] salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
    }

    // Método abstrato para calcular bônus
    public abstract double calcularBonus();

    // Método para apresentar-se
    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Loja: " + (loja != null ? loja.getNomeFantasia() : "Nenhuma"));
    }

    // Método para calcular a média salarial
    public double calcularMedia() {
        double total = 0;
        for (double salario : salarioRecebido) {
            total += salario;
        }
        return total / salarioRecebido.length;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double[] getSalarioRecebido() {
        return salarioRecebido;
    }

    public void setSalarioRecebido(double[] salarioRecebido) {
        this.salarioRecebido = salarioRecebido;
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Funcionario{" +
               "nome='" + nome + '\'' +
               ", idade=" + idade +
               ", loja=" + (loja != null ? loja.getNomeFantasia() : "Nenhuma") +
               ", salarioBase=" + salarioBase +
               ", mediaSalarial=" + calcularMedia() +
               '}';
    }
}
