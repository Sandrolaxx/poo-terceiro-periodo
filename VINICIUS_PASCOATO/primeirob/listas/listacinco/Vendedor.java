package primeirob.listas.listacinco;

import java.util.ArrayList;

public class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private ArrayList<Double> salariosRecebidos;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
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
}
