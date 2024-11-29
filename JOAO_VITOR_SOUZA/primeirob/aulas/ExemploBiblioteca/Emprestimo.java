package primeirob.aulas.ExemploBiblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private Aluno aluno;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Aluno aluno, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.aluno = aluno;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public long calcularDiasAtraso() {
        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(dataDevolucao)) {
            return ChronoUnit.DAYS.between(dataDevolucao, hoje);
        }
        return 0;
    }

    public double calcularMulta() {
        long diasAtraso = calcularDiasAtraso();
        return diasAtraso * 1.00;  // Multa de R$ 1,00 por dia de atraso
    }

    @Override
    public String toString() {
        return "Empréstimo do livro \"" + livro.getTitulo() + "\" para o aluno " + aluno.getNome() +
                "\nData de Empréstimo: " + dataEmprestimo +
                "\nData de Devolução: " + dataDevolucao +
                "\nDias de Atraso: " + calcularDiasAtraso() +
                "\nMulta por atraso: R$ " + calcularMulta();
    }
}

