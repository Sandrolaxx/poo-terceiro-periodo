package DIONATAN_DARIZ.primeirob.listas.listaseis;

public class Vendedor {
    private String nome;
    private int idade;
    private Loja loja;
    private double salarioBase;
    private double[] salarioRecebido = new double[100];
    public Vendedor(String nome, int idade, Loja loja) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
        salarioRecebido[0] = 1000.00;
        salarioRecebido[1] = 1100.00;
        salarioRecebido[2] = 1200.00;
    }

    public String getNome() {
        return nome;
    }

}
