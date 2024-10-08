package JOAO_VITOR_SOUZA.primeirob.listas.listasete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaPlantas sistema = new SistemaPlantas();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar item");
            System.out.println("2. Listar itens");
            System.out.println("3. Buscar item por nome");
            System.out.println("4. Criar pedido");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nomeItem = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    sistema.cadastrarItem(nomeItem, quantidade);
                    break;
                case 2:
                    sistema.listarItens();
                    break;
                case 3:
                    System.out.print("Nome do item para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    Item itemEncontrado = sistema.buscarItemPorNome(nomeBusca);
                    if (itemEncontrado != null) {
                        System.out.println(itemEncontrado);
                    } else {
                        System.out.println("Item não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Nome do item: ");
                    String nomeItemPedido = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidadePedido = scanner.nextInt();
                    sistema.criarPedido(nomeUsuario, nomeItemPedido, quantidadePedido);
                    break;
                case 5:
                    running = false;
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}


