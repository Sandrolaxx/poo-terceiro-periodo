// Professor.java
public class Professor {
    // Atributos
    private String nome;
    private String subject;

    // Construtor padrão
    public Professor() {
        this.nome = "Professor Padrão";
        this.subject = "Matemática"; // disciplina padrão
    }
    
    // Construtor com parâmetros
    public Professor(String nome, String subject) {
        this.nome = nome;
        this.subject = subject;
    }

    // Métodos
    public String getNome() {
        return nome;
    }

    public String getSubject() {
        return subject;
    }

    public void ensinar() {
        System.out.println(nome + " está ensinando " + subject + ".");
    }
}
