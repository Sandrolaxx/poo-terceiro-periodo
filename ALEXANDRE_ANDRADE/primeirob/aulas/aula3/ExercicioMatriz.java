package primeirob.aulas.aula3;

public class ExercicioMatriz {
    public static void main(String[] args) {
        // Declaração e inicialização de uma matriz 3x3
        int[][] matrizUm = new int[][] {
                {31, 27, 4},
                {44, 32, 95},
                {9, 16, 56}
        };

        // Impressão da matriz
        System.out.println("Matriz:");
        for (int i = 0; i < matrizUm.length; i++) {
            for (int j = 0; j < matrizUm[i].length; j++) {
                System.out.print(matrizUm[i][j] + " ");
            }
            System.out.println(); // Nova linha após cada linha da matriz
        }

        // Exemplo de como acessar um elemento específico
        int elemento = matrizUm[1][2]; // Acesso ao elemento na segunda linha, terceira coluna
        System.out.println("Elemento na segunda linha, terceira coluna: " + elemento);
    }
}
