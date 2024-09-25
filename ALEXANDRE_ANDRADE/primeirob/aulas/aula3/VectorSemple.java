package primeirob.aulas.aula3;

public class VectorSemple {
    public static void main(String[] args) {
        // Declaração de uma matriz (inicialmente sem inicialização)
        int[][] matrizDeclarada;
        // Inicialização de matrizes
        int[][] matrizUm = new int[4][6];
        int[][] matrizDois = new int[][] {
                { 24, 39 },
                { 12, 26 }
        };

        // Tentativa de acessar elementos da matriz
        try {
            System.out.println("Elemento [1][1] de matrizDois: " + matrizDois[1][1]);
            // Tentativa de acesso fora dos limites
            System.out.println("Elemento [2][2] de matrizDois: " + matrizDois[2][2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Deu ruim! " + e.getMessage());
        }
    }
}
