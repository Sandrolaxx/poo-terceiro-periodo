package DIONATAN_DARIZ.primeirob.aulas.aulaseis.data;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateSample {
    
    public static void main(String[] args) {
        
        Long diaEmMs = 86400000l;
        Date dataTeste = new Date(diaEmMs);
        Date agora = new Date();
        Date amanha = new Date(agora.getTime() + diaEmMs);
        Date dataAleatorio = new Date(124, 9, 10);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); ///formatar data


        System.out.println(dataTeste);
        System.out.println(agora);
        System.out.println(amanha);
        System.out.println(dataAleatorio);
        System.out.println(dateFormat.format(dataAleatorio));

    }
}
