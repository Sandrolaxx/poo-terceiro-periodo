package MATHEUS.primeirob.atividades.listacinco;

public class Vendedor {
    public String nome;
    public int idade;
    public double[] salarioRecebido;
    public Loja loja;
    public double salarioBase;
    public Endereco enderco;

    public Vendedor(String nome, int idade, double[] salarioRecebido, double salarioBase, Endereco endereco){
        this.nome = nome;
        this.idade = idade;
        this.salarioRecebido = salarioRecebido;
        this.salarioBase = salarioBase;
        this.enderco = endereco;
    }

    public void apresentarse(){
        System.out.println("Nome:" + nome + "\nidade:" + idade);
        enderco.apresentarse();
        if (this.loja != null){    
            this.loja.apresentarse();
        }
    }
    public double calcularMedia(){
        double soma = 0;
        for(double salario : salarioRecebido){
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }
    public double calcularBonus(){
        return salarioBase * 0.2;
    }
}