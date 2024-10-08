package MATHEUS.primeirob.atividades.listasete;
import java.util.Scanner;

public class Menu {
    static Scanner entrada = new Scanner(System.in);
    public static int exibeMenu() {
        System.out.println("[1] - cria pedido\n[2] - listar pedidos\n[3] - Finalizar pedido\n[4] - Cadastro de itens\n[5] - lista todos os itens cadastrados\n[6] - procurar item por nome\n[0] - finaliza sistema");
        return entrada.nextInt();
    }
}
