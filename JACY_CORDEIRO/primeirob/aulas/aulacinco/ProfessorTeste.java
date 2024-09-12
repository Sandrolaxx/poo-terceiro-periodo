package JACY_CORDEIRO.primeirob.aulas.aulacinco;

import JACY_CORDEIRO.primeirob.aulas.aulaseis.Professor;

public class ProfessorTeste {
    public static void main(String[] args) {
        // Criando uma instância para Professor Sandro
        Professor professorSandro = new Professor(
            "Sandro",
            "Professor de Java",
            "Conhecido por suas aulas detalhadas e práticas."
        );

        // Criando uma instância para Professor Elaine
        Professor professorElaine = new Professor(
            "Elaine",
            "Professora de Engenharia de Software: Modelagem de Software",
            "Conhecida por sua abordagem teórica e rigorosa."
        );

        // Exibindo informações sobre Professor Sandro
        System.out.println("Informações sobre Professor Sandro:");
        professorSandro.exibirInfo();

        System.out.println("\nInformações sobre Professor Elaine:");
        professorElaine.exibirInfo();
    }
}

