package MATHEUS.primeirob.prova;

import java.util.Scanner;

public class Menu {
    static Scanner entrada = new Scanner(System.in);
    public static int exibeMenu() {
        System.out.println("[1] - cadastro de Cliente\n[2] - cadastro de Quarto\n[3] - Listar quartos\n[4] - Fazer Reserva \n[5] - Realizar chek-out\n[6] - calcular o total de diarias\n[7] - verificar disponibilidade\n[0] - finaliza sistema");
        return entrada.nextInt();
    }
}
