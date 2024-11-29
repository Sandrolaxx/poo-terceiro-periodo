package primeirob.aulas.aulaSeis;
import java.util.Date;
import java.text.SimpleDateFormat;
public class dateSample {
    public static void main(String[] args) {
        
        long diaEmMs = 86400000l;
        Date dataTeste = new Date(diaEmMs);
        Date agora = new Date();
        Date amanha = new Date(agora.getTime() + diaEmMs *3);
        Date dataAlet = new Date(124,9,10);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");


        System.out.println(dataTeste);
        System.out.println(agora);
        System.out.println(amanha);
        System.out.println(dataAlet);
        System.out.println(dateFormat.format (dataAlet));
    }
}
