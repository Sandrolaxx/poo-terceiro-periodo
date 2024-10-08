package lista7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        sistema.cadastrarItem("Rosa", 10.0);
        sistema.cadastrarItem("Tulipa", 15.0);

        int opcao = 0;

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Cadastrar item");
            System.out.println("2. Listar itens");
            System.out.println("3. Buscar item por nome");
            System.out.println("4. Criar pedido");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nomeItem = scanner.nextLine();
                    System.out.print("Preço do item: ");
                    double precoItem = Double.parseDouble(scanner.nextLine());
                    sistema.cadastrarItem(nomeItem, precoItem);
                    break;
                
                case 2:
                    sistema.listarItens();
                    break;

                case 3:
                    System.out.print("Informe o nome do item: ");
                    String nomeBusca = scanner.nextLine();
                    Item itemBuscado = sistema.buscarItemPorNome(nomeBusca);
                    if (itemBuscado != null) {
                        System.out.println(itemBuscado);
                    }
                    break;

                case 4:
                    System.out.print("Informe o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    Pedido pedido = sistema.criarPedido(nomeCliente, scanner);
                    System.out.println("\nResumo do Pedido:");
                    pedido.mostrarPedido();
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}
