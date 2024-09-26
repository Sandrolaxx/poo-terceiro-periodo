package VICTOR_WILLIAM.primeirob.aulas.aula3;

public class LoopMatriz {
    public static void main(String[] args) {

        int [][] matriz = new int [][] {
                { 1, 20 },
                { 4, 60 },
                { 7, 90 }
        };

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j]);
            }
        }
    }
}
