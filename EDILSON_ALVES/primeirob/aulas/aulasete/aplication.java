package EDILSON_ALVES.primeirob.aulas.aulasete;

import java.util.Date;
import java.text.SimpleDateFormat;

public class aplication {
    public static void main(String[] args) {
        
        long diaEmMs = 86400000l;
        Date dateTeste = new Date(diaEmMs);
        Date agora = new Date();
        Date amanha = new Date(agora.getTime()+diaEmMs);
        Date daquitres = new Date(agora.getTime()+(diaEmMs*4 ));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
       

        System.out.println("aqui "+format.format(agora));



            System.out.println(dateTeste);
            System.out.println(agora);
            System.out.println(amanha);
            System.out.println(daquitres);
            //entregar uma data e somar dias fazer erxercicio
    }
}
