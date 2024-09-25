package JACY_CORDEIRO.primeirob.aulas.aulaseis;

import java.util.Date;

public class DateSample {

    public static void main(String[] args) {
        // Milissegundos em um dia
        Long DiaEmMs = 86400000L;

        // Data e hora atual
        Date agora = new Date();

        // Data sem hora
        Date dataSemHora = new Date(agora.getYear(), agora.getMonth(), agora.getDate());

        // Data específica: 20 de fevereiro de 2024
        Date vinteFevereiro = new Date(124, 1, 20);

        // Obtém o tempo em milissegundos da data específica
        Long vinteFevEpoch = vinteFevereiro.getTime();

        // Exibe as datas e tempo em milissegundos
        System.out.println("Data atual: " + agora);
        System.out.println("Data sem hora: " + dataSemHora);
        System.out.println("Data específica (20 de fevereiro de 2024): " + vinteFevereiro);
        System.out.println("Tempo em milissegundos (20 de fevereiro de 2024): " + vinteFevEpoch);
    }
}
