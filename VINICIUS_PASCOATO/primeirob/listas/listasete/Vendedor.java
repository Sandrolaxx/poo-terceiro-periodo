package primeirob.listas.listasete;

public class Vendedor {

    private String nome;
    private int idade;
    private Loja loja;

    public Vendedor(String nome, int idade, Loja loja) {
        this.nome = nome;
        this.idade = idade;
        this.loja = loja;
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

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public void apresentarVendedor() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Loja: " + loja.getNome());
    }
}
