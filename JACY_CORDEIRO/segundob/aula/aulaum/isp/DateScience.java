package segundob.aula.aulaum.isp;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateScience {
    public static int calcularDiferencaEmDias(Date dataInicio, Date dataFim) {
        long diffInMillies = Math.abs(dataFim.getTime() - dataInicio.getTime());
        return (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
