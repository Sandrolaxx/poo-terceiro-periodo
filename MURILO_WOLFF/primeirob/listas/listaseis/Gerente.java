package MURILO_WOLFF.primeirob.listas.listaseis;

import java.util.ArrayList;

public class Gerente extends Pessoa {
    private String loja;
    private double salarioBase;
    private ArrayList<Double> salariosRecebidos;

    public Gerente(String nome, int idade, String loja, double salarioBase) {
        super(nome, idade);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salariosRecebidos = new ArrayList<>();
        this.salariosRecebidos.add(2500.0);
        this.salariosRecebidos.add(2700.0);
        this.salariosRecebidos.add(3000.0);
    }

    public void apresentarse() {
        super.apresentarse();
        System.out.println("Loja: " + loja);
    }

    public double calcularMedia() {
        return salariosRecebidos.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
