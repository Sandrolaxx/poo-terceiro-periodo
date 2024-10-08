package ISAQUI_CAMARGO_BARAI.primeirob.listas.listacinco;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    List<Double> salarioRecebido;

    // Construtor
    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase, List<Double> salarioRecebido) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = salarioRecebido;
        
        // Verificando se existem no mínimo 3 lançamentos de salário
        if (this.salarioRecebido.size() < 3) {
            throw new IllegalArgumentException("É necessário ao menos 3 valores de salário lançados.");
        }
    }

    // Método para se apresentar
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    // Método para calcular a média dos salários recebidos
    public double calcularMedia() {
        double soma = 0;
        for (double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.size();
    }

    // Método para calcular o bônus
    public double calcularBonus() {
        return salarioBase * 0.2;
    }
}
