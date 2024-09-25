package ROBSON_DE_LIMA.primeirob.listas.listaSeis;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Pessoa {
    private String loja;
    private double salarioBase;
    private List<Double> salariosRecebidos = new ArrayList<>();

    public Gerente(String nome, int idade, Endereco endereco, String loja, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        // Preenchendo com valores de exemplo
        salariosRecebidos.add(5000.0);
        salariosRecebidos.add(5200.0);
        salariosRecebidos.add(5400.0);
    }

    @Override
    public void apresentarse() {
        super.apresentarse();
        System.out.printf("Loja: %s%n", loja);
    }

    public double calcularMedia() {
        return salariosRecebidos.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}

