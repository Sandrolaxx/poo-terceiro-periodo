package JACY_CORDEIRO.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.List;

public class Gerente {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Gerente() {
        salarioRecebido = new ArrayList<>();
        // Adicionando três valores de exemplo para salário
        salarioRecebido.add(3000.0);
        salarioRecebido.add(3200.0);
        salarioRecebido.add(3500.0);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {  // Validação de idade
            this.idade = idade;
        } else {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0) {  // Validação de salário
            this.salarioBase = salarioBase;
        } else {
            throw new IllegalArgumentException("Salário base não pode ser negativo.");
        }
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

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
