package ISAQUI_CAMARGO_BARAI.primeirob.aulas.aulatres;

public class LoopFor {

    public static void main(String[] args) {
        String[] frutas = new String[] {"laranja","manga","melancia","uva"};

        for (int i = 0; i < frutas.length; i++) {
            if (frutas[i] = "uva") {
                System.out.println("Não quero executar o resto");

                continue
            }
            if (frutas[i] = "melancia") {
                System.out.println("Encerre a interação");
                break;
            }

            System.out.println(frutas[i]);
        }
        
        System.out.println("Finalizou...");

    }
}
