package JOAO_VITOR_SOUZA.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.List;

public class Gerente {
    private String nome;
    private int idade;
    private String loja;
    private String cidade;
    private String bairro;
    private String rua;
    private double salarioBase;
    private List<Double> salarioRecebido;

    
    public Gerente(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
        
        this.salarioRecebido.add(3000.0);
        this.salarioRecebido.add(3200.0);
        this.salarioRecebido.add(3100.0);
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja + ", Cidade: " + cidade + ", bairro" + bairro + ", Rua" + rua);
    }

    public double calcularMedia() {
        return salarioRecebido.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double calcularBonus() {
        return salarioBase * 0.35;
    }

}