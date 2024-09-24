package MARCUS_PENSO.lista7;

import java.util.ArrayList;
public class Vendedor {
    private String nome;
    private int idade;
    private Endereco endereco;
    private double salarioBase;
    private ArrayList<Double> salariosRecebidos;
    public Vendedor(String nome, int idade, Endereco endereco, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();
    }
    public void adicionaSalario(double salario) {
        if (salariosRecebidos.size() < 3) {
            salariosRecebidos.add(salario);
        } else {
            System.out.println("Já foram inseridos 3 lançamentos de salário.");
        }
    }
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }
    public double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return salariosRecebidos.size() > 0 ? soma / salariosRecebidos.size() : 0;
    }
    public double calcularBonus() {
        return salarioBase * 0.2;
    }