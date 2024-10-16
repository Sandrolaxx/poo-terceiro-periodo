package primeirob.aulas.ExemploBiblioteca;

import java.time.LocalDate;

public class SistemaBiblioteca {
    private static Aluno[] alunos = new Aluno[10];
    private static Livro[] livros = new Livro[10];
    private static Emprestimo[] emprestimos = new Emprestimo[10];
    private static int alunoCount = 0;
    private static int livroCount = 0;
    private static int emprestimoCount = 0;

    public static void cadastrarAluno(String nome, String matricula) {
        if (alunoCount < alunos.length) {
            alunos[alunoCount++] = new Aluno(nome, matricula);
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Limite de alunos cadastrados atingido.");
        }
    }

    public static void cadastrarLivro(String titulo, String autor) {
        if (livroCount < livros.length) {
            livros[livroCount++] = new Livro(titulo, autor);
            System.out.println("Livro cadastrado com sucesso!");
        } else {
            System.out.println("Limite de livros cadastrados atingido.");
        }
    }

    public static void registrarEmprestimo(String matricula, String titulo, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        Aluno aluno = buscarAlunoPorMatricula(matricula);
        Livro livro = buscarLivroPorTitulo(titulo);

        if (aluno != null && livro != null) {
            if (emprestimoCount < emprestimos.length) {
                emprestimos[emprestimoCount++] = new Emprestimo(aluno, livro, dataEmprestimo, dataDevolucao);
                System.out.println("Empréstimo registrado com sucesso!");
            } else {
                System.out.println("Limite de empréstimos atingido.");
            }
        } else {
            System.out.println("Aluno ou livro não encontrado.");
        }
    }

    public static Aluno buscarAlunoPorMatricula(String matricula) {
        for (int i = 0; i < alunoCount; i++) {
            if (alunos[i].getMatricula().equals(matricula)) {
                return alunos[i];
            }
        }
        return null;
    }

    public static Livro buscarLivroPorTitulo(String titulo) {
        for (int i = 0; i < livroCount; i++) {
            if (livros[i].getTitulo().equals(titulo)) {
                return livros[i];
            }
        }
        return null;
    }

    public static void listarEmprestimos() {
        for (int i = 0; i < emprestimoCount; i++) {
            System.out.println(emprestimos[i]);
            System.out.println();
        }
    }
}
