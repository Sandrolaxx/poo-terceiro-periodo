package primeirob.aulas.aula3;

import java.util.Arrays;

public class Loops {
    public static void main(String[] args) {
        // Declaração e inicialização do array
        String[] vetorzinStr = new String[10];
        int index = 0;

        // Imprime o tamanho do array
        System.out.println("Tamanho do array: " + vetorzinStr.length);

        // Preenchendo o array com valores usando o loop while
        while (index < vetorzinStr.length) {
            vetorzinStr[index] = "Sandrolax-" + index;
            index++;
        }

        // Imprimindo o array após o loop while
        System.out.println("Após o loop while: " + Arrays.toString(vetorzinStr));

        // Resetando o índice para o próximo loop
        index = 0;

        // Preenchendo o array com novos valores usando o loop do-while
        do {
            vetorzinStr[index] = "Do-While-" + index;
            index++;
        } while (index < vetorzinStr.length);

        // Imprimindo o array após o loop do-while
        System.out.println("Após o loop do-while: " + Arrays.toString(vetorzinStr));
    }
}
