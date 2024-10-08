package ERICK_SCUR.primeirob.listas.lista7;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

class Gerente extends Pessoa {
    private Loja loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Gerente(String nome, int idade, Loja loja, Endereco endereco, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = Arrays.asList(5000.0, 5100.0, 5200.0);
    }

    @Override
    public void apresentarse() {
        JOptionPane.showMessageDialog(null, "Nome: " + this.getNome() + "\nIdade: " + this.getIdade() + "\nLoja: " + loja.getNomeFantasia());
    }

    public double calcularMedia() {
        double soma = salarioRecebido.stream().mapToDouble(Double::doubleValue).sum();
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }
}
