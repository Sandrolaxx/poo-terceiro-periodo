package ISAQUI_CAMARGO_BARAI.primeirob.listas.listaseis;

import java.util.ArrayList;

class Gerente {
    String nome;
    int idade;
    String loja;
    Endereco endereco;
    double salarioBase;
    ArrayList<Double> salarioRecebido = new ArrayList<>();

    Gerente(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        
        this.salarioRecebido.add(3000.0);
        this.salarioRecebido.add(3200.0);
        this.salarioRecebido.add(3500.0);
    }

    void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }

    double calcularMedia() {
        double total = 0;
        for(double salario : salarioRecebido) {
            total += salario;
        }
        return total / salarioRecebido.size();
    }

    double calcularBonus() {
        return salarioBase * 0.35;
    }
}
