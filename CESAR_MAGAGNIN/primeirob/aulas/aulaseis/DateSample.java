package CESAR_MAGAGNIN.primeirob.aulas.aulaseis;

import java.util.Date;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;

public class DateSample {
    public static void main (String[]args){
        Long diaEmMs = 86400000l;
        Date dataEpoch = new Date(diaEmMs); // GDH Epoch
        Date agora = new Date(); //GDH atual
        Date amanha = new Date(agora.getTime()+(diaEmMs));
        Date niver = new Date(92, 8, 25); // 1900 + Ano decada (Ex 2001 = 1900+101) /Mes (-1) /dia
        SimpleDateFormat dataformatada = new SimpleDateFormat ("dd/MM/yyyy");
        String niverformatado = dataformatada.format(niver);

        System.out.println(dataEpoch);
        System.out.println(agora);
        System.out.println(amanha);
        System.out.println(niverformatado);
    }
    
}
