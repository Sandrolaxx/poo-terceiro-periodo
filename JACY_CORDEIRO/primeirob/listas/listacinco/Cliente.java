package JACY_CORDEIRO.primeirob.listas.listacinco;

public class Cliente {
    String nome;
    int idade;
    String cidade;
    String bairro;
    String rua;

    // Construtor
    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    // Método apresentar-se
    public void apresentarse() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cidade: " + cidade);
        System.out.println("Bairro: " + bairro);
        System.out.println("Rua: " + rua);
    }
}
