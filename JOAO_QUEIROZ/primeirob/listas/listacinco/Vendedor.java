package primeirob.listas.listacinco;

/*1. Crie uma classe Vendedor com:
- Com os atributos nome, idade, Loja, cidade, bairro, rua, salarioBase e salarioRecebido.
- Atributo salarioRecebido DEVE armazenar no mínimo três valores de lançamentos de salário.
- Métodos apresentarse, calcularMedia e calcularBonus.
- Método apresentarse deve printar o nome, idade e Loja.
- calcularMedia deve trazer a média dos salários.
- calcularBonus onde a formulá é [salarioBase * 0.2] */


import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
    }

    public void adicionarSalario(double salario) {
            salarioRecebido.add(salario);       
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return salarioRecebido.isEmpty() ? 0 : soma / salarioRecebido.size();
    }

    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}