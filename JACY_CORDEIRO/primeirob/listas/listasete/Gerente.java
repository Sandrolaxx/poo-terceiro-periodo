//package poo_terceiro_periodo.JACY_CORDEIRO.primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.List;

public class Gerente {
    private String nome;
    private int idade;
    private String loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    // Construtor da classe Gerente
    public Gerente(String nome, int idade, String loja, double salarioBase) {
        this.nome = nome;
        setIdade(idade); // Usar método setter para validação
        this.loja = loja;
        setSalarioBase(salarioBase); // Usar método setter para validação
        this.salarioRecebido = new ArrayList<>();
        // Adicionando três valores de exemplo para salário
        salarioRecebido.add(3000.0);
        salarioRecebido.add(3200.0);
        salarioRecebido.add(3500.0);
    }

    // Setters com validação
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade >= 0) { // Validação de idade
            this.idade = idade;
        } else {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0) { // Validação de salário
            this.salarioBase = salarioBase;
        } else {
            throw new IllegalArgumentException("Salário base não pode ser negativo.");
        }
    }

    // Método para apresentar as informações do gerente
    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    // Calcula a média dos salários recebidos
    public double calcularMedia() {
        if (salarioRecebido.isEmpty()) {
            return 0; // Evita divisão por zero
        }
        
        double total = 0.0;
        for (double salario : salarioRecebido) {
            total += salario;
        }
        return total / salarioRecebido.size();
    }

    // Calcula o bônus baseado no salário base
    public double calcularBonus() {
        return salarioBase * 0.35;
    }

    // Métodos get para atributos privados
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getLoja() {
        return loja;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", loja='" + loja + '\'' +
                ", salarioBase=" + salarioBase +
                ", salarioRecebido=" + salarioRecebido +
                '}';
    }
}
