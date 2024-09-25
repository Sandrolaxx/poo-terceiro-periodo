package ERICK_SCUR.primeirob.listas.lista5;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Vendedor {
    private String nome;
    private int idade;
    private Loja loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, Loja loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
    }

    public void adicionaSalarioRecebido(double salario) {
        if (salarioRecebido.size() < 3) {
            salarioRecebido.add(salario);
        } else {
            JOptionPane.showMessageDialog(null, "Já existem 3 lançamentos de salário.");
        }
    }

    public void apresentarse() {
        JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nIdade: " + idade + "\nLoja: " + loja.getNomeFantasia());
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}