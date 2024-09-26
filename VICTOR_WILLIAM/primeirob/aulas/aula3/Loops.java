package VICTOR_WILLIAM.primeirob.aulas.aula3;

public class Loops {
    public static void main(String[] args) {
        String [] vetorString = new String[10];
        int idx = 0;

        System.out.println(vetorString.length);


        while (idx < vetorString.length) {
            vetorString[idx] = "Skafikis " + idx;
            idx++;
        }
        System.out.println(vetorString.length);


        idx = 0;

        do {
            vetorString[idx] = "Do-While-" + idx;
            idx++;
        } while (idx < vetorString.length);
        System.out.println(vetorString.length);
    }
}