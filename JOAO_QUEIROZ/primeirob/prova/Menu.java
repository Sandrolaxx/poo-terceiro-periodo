package JOAO_QUEIROZ.primeirob.prova;

import java.util.Scanner;

public class  Menu {
    private static Hotel hotel = new Hotel(); 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Quarto");
            System.out.println("3. Listar Quartos Disponíveis");
            System.out.println("4. Reservar Quarto");
            System.out.println("5. Realizar Check-out");
            System.out.println("6. Verificar Disponibilidade");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:

                default:
                    throw new AssertionError();
            }
        } while (opcao != 5);
    }
    private static void cadastrarCliente(Scanner scanner) {
        System.err.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
    }
}
