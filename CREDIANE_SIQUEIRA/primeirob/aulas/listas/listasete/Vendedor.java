package CREDIANE_SIQUEIRA.primeirob.aulas.listas.listasete;

public class Vendedor {
    private String nome;
    private int idade;
    private Endereco endereco;

    public Vendedor(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters e Setters para encapsulamento
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void apresentarSe() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
        endereco.apresentarLogradouro();
    }
}
