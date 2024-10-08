package GUILHERME_HENRIQUE.primeirob.listas.listacinco;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private double salarioBase;
    private List<Double> salariosRecebidos;

    public Vendedor(String nome, int idade, String loja, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();
        // Adicionando um salário base como exemplo
        this.salariosRecebidos.add(salarioBase);
    }

    public String getNome() {
        return nome;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        return salariosRecebidos.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
