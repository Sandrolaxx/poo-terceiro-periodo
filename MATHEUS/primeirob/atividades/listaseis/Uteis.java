package MATHEUS.primeirob.atividades.listaseis;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Uteis {
    public static String dataFormatada(Date data) {
        String dataFormatada = "";

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy  hh:mm");

        dataFormatada = formatador.format(data);

        return dataFormatada;
    }
}
