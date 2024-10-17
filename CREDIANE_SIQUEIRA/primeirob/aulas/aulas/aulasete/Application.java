package primeirob.aulas.aulas.aulasete;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        String[] produtos = new String[] { "Mouse", "Teclado razer", "Placa de vídeo" };
    
        Scanner scanner = new Scanner(System.in);

        String valorBusca = scanner.nextLine();
        
        for (String produto : produtos) {
            if (produto.contains(valorBusca)) {
                System.out.println("Existe é o: " + produto);
            }
        }
    }

}
