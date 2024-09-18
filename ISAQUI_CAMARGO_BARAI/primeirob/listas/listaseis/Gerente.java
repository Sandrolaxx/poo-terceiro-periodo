package ISAQUI_CAMARGO_BARAI.primeirob.listas.listaseis;

import java.util.ArrayList;

class Gerente {
    String nome;
    int idade;
    String loja;
    Endereco endereco;
    double salarioBase;
    ArrayList<Double> salarioRecebido = new ArrayList<>();

    // Construtor
    Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        
        // Adicionando lançamentos de salário
        this.salarioRecebido.add(3000.0);
        this.salarioRecebido.add(3200.0);
        this.salarioRecebido.add(3500.0);
    }

    // Método apresentarse
    void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    // Método para calcular a média de salários recebidos
    double calcularMedia() {
        double total = 0;
        for(double salario : salarioRecebido) {
            total += salario;
        }
        return total / salarioRecebido.size();
    }

    // Método para calcular o bônus
    double calcularBonus() {
        return salarioBase * 0.35;
    }
}
