package VINICIUS_PASCOATO.primeirob.listas.listaseis;

import java.util.ArrayList;

public class Gerente extends Pessoa {
    private double salarioBase;
    private ArrayList<Double> salariosRecebidos;

    public Gerente(String nome, int idade, Endereco endereco, double salarioBase) {
        super(nome, idade, endereco);
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

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salariosRecebidos) {
            soma += salario;
        }
        return salariosRecebidos.size() > 0 ? soma / salariosRecebidos.size() : 0;
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
    
    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }
}

