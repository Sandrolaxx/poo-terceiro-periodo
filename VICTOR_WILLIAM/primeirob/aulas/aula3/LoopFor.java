package VICTOR_WILLIAM.primeirob.aulas.aula3;

public class LoopFor {
    public static void main(String[] args) {
        String [] frutas = new String[]{"Banana", "Maçã", "Pera", "Uva", "Melancia"};
        int [] numeros = new int[]{1, 2, 3, 4, 5};

        for (String i : frutas) {
            System.out.println(i);
        }

        for (int i : numeros) {
            System.out.println(i);
        }
    }
}