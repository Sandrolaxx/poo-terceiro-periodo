package JACY_CORDEIRO.primeirob.listas.listaseis;

public class Vendedor {
    private String nome;
    private int idade;
    private String loja;

    public Vendedor(String nome, int idade, String loja) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
    }

    public void apresentarVendedor() {
        System.out.println("Vendedor: " + nome + ", Idade: " + idade + ", Loja: " + loja);
    }
}

