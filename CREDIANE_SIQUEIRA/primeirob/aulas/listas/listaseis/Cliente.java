package CREDIANE_SIQUEIRA.primeirob.aulas.listas.listaseis;

public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
        endereco.apresentarLogradouro();
    }
}
