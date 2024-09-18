package DIONATAN_DARIZ.primeirob.listas.listaseis;

public class Humano extends Endereco {
    private String nome;
    private int idade;

    public Humano(String nome, int idade, String rua, String bairro, String estado, String complemento, int numero) {
        super(rua, bairro, estado, complemento, numero);
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
        apresentarLogradouro(); // Chama o método da classe Endereco
    }
}
