package primeirob.aulas.aulasete;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static SimpleDateFormat DDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");

    public static Integer diasEntreDatas(Date dataUm, Date dataDois) {
        long msDia = 86400000l;

        long valorDif = dataUm.getTime() - dataDois.getTime();
        long dias = valorDif / msDia;

        return (int) dias;
    }

    public static Date ddmmyyyyToDate(String strDate) throws ParseException {
        return DDMMYYYY.parse(strDate);
    }

}
