package ERICK_SCUR.primeirob.listas.lista6;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

class Vendedor extends Pessoa {
    private Loja loja;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, Loja loja, Endereco endereco, double salarioBase) {
        super(nome, idade, endereco);
        this.loja = loja;
        this.salarioBase = salarioBase;
        this.salarioRecebido = Arrays.asList(2600.0, 2700.0, 2800.0);
    }

    @Override
    public void apresentarse() {
        JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nIdade: " + idade + "\nLoja: " + loja.getNomeFantasia());
    }

    public double calcularMedia() {
        double soma = salarioRecebido.stream().mapToDouble(Double::doubleValue).sum();
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }

    public Loja getLoja() {
        return loja;
    }
}
