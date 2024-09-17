package VICTOR_WILLIAM.primeirob.aulas.aula5;

public class StringUtils {
    public static String removeNumeros(String texto){
        return texto.replaceAll("[0-9]", "");
    }
}
