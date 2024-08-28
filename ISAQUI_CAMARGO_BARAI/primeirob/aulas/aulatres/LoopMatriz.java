package ISAQUI_CAMARGO_BARAI.primeirob.aulas.aulatres;

public class LoopMatriz {
    public static void main(String[] args) {
        int[][] matrizSample = new int[][] {
            { 20, 34, 74 },
            { 4, 17, 98 },
            { 18, 85, 11 }
        };

        for (int linha = 0; linha < matrizSample.length; linha++) {
            for (int coluna = 0; coluna < matrizSample[linha].length) {
                System.out.println(matrizSample);
            }
        }
    }
    
}
