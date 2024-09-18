// Aluno.java
public class Aluno {
    // Atributos
    private String nome;
    private int idade;
    
    // Construtor padrão
    public Aluno() {
        this.nome = "Nome Padrão";
        this.idade = 18; // idade padrão
    }
    
    // Construtor com parâmetros
    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void estudar() {
        System.out.println(nome + " está estudando.");
    }
}
