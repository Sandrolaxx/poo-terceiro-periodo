package MURILO_WOLFF.primeirob.listas.listaseis;

public class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + "\nIdade: " + idade);
    }
}
