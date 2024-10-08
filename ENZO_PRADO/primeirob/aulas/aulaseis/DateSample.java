package ENZO_PRADO.primeirob.aulas.aulaseis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSample {
    
    public static void main(String[] args) {
        Long diaEmMs = 86400000l;
        int qtdDeDIasEntreData;

        Date dataTeste = new Date(diaEmMs);
        Date agora = new Date();
       
        Date amanha = new Date(agora.getTime() + diaEmMs);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dataTeste);
        System.out.println(agora);
        System.out.println(amanha);
}
}
