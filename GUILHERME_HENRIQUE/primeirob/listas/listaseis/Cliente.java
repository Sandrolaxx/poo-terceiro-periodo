package GUILHERME_HENRIQUE.primeirob.listas.listaseis;

public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public Cliente(String string, int i, String string2, String string3, String string4) {
    }

    public void apresentarse() {
        System.out.println("Cliente: " + nome + ", Idade: " + idade);
        endereco.apresentarLogradouro();
    }
}
