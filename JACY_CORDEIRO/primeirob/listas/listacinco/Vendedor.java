package JACY_CORDEIRO.primeirob.listas.listacinco;

public class Vendedor {
    String nome;
    int idade;
    String loja;
    String cidade;
    String bairro;
    String rua;
    double salarioBase;
    double[] salarioRecebido = new double[3];
    
    // Construtor
    public Vendedor(String nome, int idade, String loja, String cidade, String bairro, String rua, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.salarioBase = salarioBase;
    }

    // Adiciona salário ao array
    public void adicionarSalario(double salario, int index) {
        if(index >= 0 && index < 3) {
            this.salarioRecebido[index] = salario;
        }
    }

    // Método apresentar-se
    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Loja: " + loja);
        System.out.println("Cidade: " + cidade);
        System.out.println("Bairro: " + bairro);
        System.out.println("Rua: " + rua);
    }

    // Calcula a média dos salários
    public double calcularMedia() {
        double soma = 0;
        for(double salario : salarioRecebido) {
            soma += salario;
        }
        return soma / salarioRecebido.length;
    }

    // Calcula o bônus (20% do salário base)
    public double calcularBonus() {
        return salarioBase * 0.2;
    }

    // Printar salários
    public void printSalarios() {
        System.out.println("Salários Recebidos:");
        for(double salario : salarioRecebido) {
            System.out.println(salario);
        }
    }
}
