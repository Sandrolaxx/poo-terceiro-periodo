package primeirob.listas.listaseis;

public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected Endereco endereco;

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public void apresentarse() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
        endereco.apresentarLogradouro();
    }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
}
