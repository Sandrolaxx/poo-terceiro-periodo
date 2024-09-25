package GUILHERME_HENRIQUE.primeirob.listas.listacinco;

public class Cliente {
    private String nome;
    private int idade;
    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}
