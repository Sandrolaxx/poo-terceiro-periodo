package primeirob.listas.listacinco;

public class Cliente {
    String nome;
    Integer idade;
    String cidade;
    String bairro;
    String rua;

    void apresentarse() {
        System.out.println("Olá! Me chamo " + nome + ", tenho " + idade + " anos.");
    }
}
