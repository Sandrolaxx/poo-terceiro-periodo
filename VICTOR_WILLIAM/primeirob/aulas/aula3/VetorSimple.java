package VICTOR_WILLIAM.primeirob.aulas.aula3;

public class VetorSimple {
    public static void main(String[] args) {
        int [][] matrizDeclarada;
        int [][] matrizInicializada = new int[2][2];
        int [][] matrizInicializada2 = new int[][] {
                { 1, 20 },
                { 4, 60 },
                { 7, 90 }
        };

        try {
            System.out.println(matrizInicializada2[0][0]);
            System.out.println(matrizInicializada2[2][1]);
            System.out.println(matrizInicializada2[1][3]);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
