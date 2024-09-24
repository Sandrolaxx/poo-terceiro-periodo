package MURILO_WOLFF.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa{
    private String loja;
    private Endereco endereco;
    private double salarioBase;
    private List<Double> salarioRecebido;

    public Vendedor(String nome, int idade, String loja, Endereco endereco, double salarioBase) {
        super(nome, idade);
        this.loja = loja;
        this.endereco = endereco;
        this.salarioBase = salarioBase;
        this.salarioRecebido = new ArrayList<>();
    }

    public void apresentarse() {
        super.apresentarse();
        System.out.println("Loja: " + loja);
        endereco.apresentarLogradouro();
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

    public void adicionarSalario(double salario) {
        if (salarioRecebido.size() < 3) {
            salarioRecebido.add(salario);
        } else {
            System.out.println("Já foram registrados 3 salários.");
        }
    }
}