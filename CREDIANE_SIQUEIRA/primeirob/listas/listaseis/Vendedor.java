package CREDIANE_SIQUEIRA.primeirob.listas.listaseis;

public class Vendedor {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Vendedor(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
        endereco.apresentarLogradouro();
    }
}
