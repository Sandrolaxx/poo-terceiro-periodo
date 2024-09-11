package ISAQUI_CAMARGO_BARAI.primeirob.listas.listacinco;

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

    // Método para se apresentar
    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}
