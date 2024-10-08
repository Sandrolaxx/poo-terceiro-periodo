package primeirob.aulas.aula2;

public class Vector {
    public static void main(String[] args) {
        // Declaração de vetores
        int[] declaracao;
        int declaracaoVetor[];

        // Declaração e Inicialização de arrays
        char[] string = new char[20];
        char valorChar = 68; // Valor ASCII para 'D'
        char[] meuNome = new char[] { 'S', 'A', 'N', valorChar, 'R', 'O' };
        int[] valores = new int[] { 20, 47, 12 };

        // Impressão dos arrays
        System.out.println(String.valueOf(meuNome)); // Converte o array de char para String
        System.out.println(valores[2]); // Imprime o valor do índice 2 do array 'valores'
    }
}
