
// Main.java
public class Main {
    public static void main(String[] args) {
        // Usando o construtor padrão
        Aluno aluno1 = new Aluno();
        System.out.println("Aluno: " + aluno1.getNome() + ", Idade: " + aluno1.getIdade());
        aluno1.estudar();

        // Usando o construtor com parâmetros
        Aluno aluno2 = new Aluno("Lucas", 20);
        System.out.println("Aluno: " + aluno2.getNome() + ", Idade: " + aluno2.getIdade());
        aluno2.estudar();
        
        // Usando o construtor padrão na classe Professor
        Professor professor1 = new Professor();
        System.out.println("Professor: " + professor1.getNome() + ", Disciplina: " + professor1.getSubject());
        professor1.ensinar();

        // Usando o construtor com parâmetros na classe Professor
        Professor professor2 = new Professor("Maria", "Física");
        System.out.println("Professor: " + professor2.getNome() + ", Disciplina: " + professor2.getSubject());
        professor2.ensinar();
    }
}

