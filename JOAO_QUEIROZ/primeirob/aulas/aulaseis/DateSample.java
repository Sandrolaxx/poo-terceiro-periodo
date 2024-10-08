package primeirob.aulas.aulaseis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSample {
    public static void main(String[] args) {
        
        Long diaEmMs = 8640000l;
        Date dataEpochMaisUmDia = new Date(diaEmMs);
        Date agora = new Date();
        Long msAtual = agora.getTime();

        Date amanha = new Date(agora.getTime() + (diaEmMs + 3));

        Date dataAleatoria = new Date(124, 9, 10);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        System.out.println(dataEpochMaisUmDia);
        System.out.println(agora);
        System.out.println(amanha);
        System.out.println(dataAleatoria);
    }
}
