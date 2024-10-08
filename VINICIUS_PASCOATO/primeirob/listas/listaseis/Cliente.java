package VINICIUS_PASCOATO.primeirob.listas.listaseis;

public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
        endereco.apresentarLogradouro();
    }
}
