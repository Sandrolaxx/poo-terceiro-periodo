package primeirob.aulas.aula3;

public class LoopFor {
    public static void main(String[] args) {
        // Declaração e inicialização dos arrays
        String[] frutas = new String[] { "🍊", "🍐", "🍇", "🍇" };
        int[] test = new int[] { 23, 44 };

        // Loop com instruções de controle (comentado para referência)
        /*
        for (int i = 0; i < frutas.length; i++) {
            if (frutas[i].equals("🍇")) {
                System.out.println("Não quero executar o resto");
                continue;
            }

            if (frutas[i].equals("🍐")) {
                System.out.println("Encerre a iteração");
                break;
            }

            System.out.print(frutas[i]);
        }
        */

        // Loop aprimorado com enhanced for (for-each)
        for (String str : frutas) {
            System.out.println(str);
        }

        for (int i : test) {
            System.out.println(i);
        }

        System.out.println("Finalizou...");
    }
}
