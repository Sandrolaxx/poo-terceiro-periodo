package CREDIANE_SIQUEIRA.primeirob.aulas.aulas.aulaseis;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateSample {
    public static void main(String[] args) {
        Long diaEmMs = 86400000l;
        Date dataEpochMaisUmDia = new Date(diaEmMs);
        Date agora = new Date();
        Date amanha = new Date(agora.getTime() + diaEmMs * 3);
        Date dataAleatoria = new Date(124, 9, 10);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(dataEpochMaisUmDia);
        System.out.println(agora);
        System.out.println(amanha);
        System.out.println(dataAleatoria);

        System.out.println(dateFormat.format(dataAleatoria));
    }
}
