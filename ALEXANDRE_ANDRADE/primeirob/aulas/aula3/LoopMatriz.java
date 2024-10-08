package primeirob.aulas.aula3;

public class LoopMatriz {
    public static void main(String[] args) {
        // Declaração e inicialização da matriz
        int[][] matrizSample = new int[][] {
                {20, 34},
                {4, 17},
                {18, 85}
        };

        // Loop para percorrer e imprimir os elementos da matriz
        for (int linha = 0; linha < matrizSample.length; linha++) {
            for (int coluna = 0; coluna < matrizSample[linha].length; coluna++) {
                System.out.println(matrizSample[linha][coluna]);
            }
        }
    }
}
