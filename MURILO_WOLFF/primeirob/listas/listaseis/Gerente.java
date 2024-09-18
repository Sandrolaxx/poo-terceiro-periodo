package MURILO_WOLFF.primeirob.listas.listaseis;

import java.util.ArrayList;

public class Gerente extends Pessoa{
    private Endereco endereco;
    private String loja;
    private double salarioBase;
    private ArrayList<Double> salariosRecebidos;

    public Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        super(nome, idade);
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();
    }

    public void apresentarse() {
        super.apresentarse();
        System.out.println("\nLoja: " + loja);
    }

    public void adicionarSalario(double salario) {
        salariosRecebidos.add(salario);
    }

    public double calcularMedia() {
        return salariosRecebidos.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}