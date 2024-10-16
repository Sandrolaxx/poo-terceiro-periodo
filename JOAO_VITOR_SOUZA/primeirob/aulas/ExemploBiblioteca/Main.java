package primeirob.aulas.ExemploBiblioteca;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca.cadastrarAluno("João Silva", "12345");
        SistemaBiblioteca.cadastrarAluno("Maria Souza", "54321");

        SistemaBiblioteca.cadastrarLivro("O Senhor dos Anéis", "J.R.R. Tolkien");
        SistemaBiblioteca.cadastrarLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");

        SistemaBiblioteca.registrarEmprestimo("12345", "O Senhor dos Anéis", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10));
        SistemaBiblioteca.registrarEmprestimo("54321", "O Pequeno Príncipe", LocalDate.of(2023, 9, 5), LocalDate.of(2023, 9, 12));

        SistemaBiblioteca.listarEmprestimos();
    }
}

