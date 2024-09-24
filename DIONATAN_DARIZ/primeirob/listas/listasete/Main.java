package DIONATAN_DARIZ.primeirob.listas.listasete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeItens gerenciadorDeItens = new GerenciadorDeItens();
        GerenciadorDePedidos gerenciadorDePedidos = new GerenciadorDePedidos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cadastrar Item");
            System.out.println("2. Listar Itens");
            System.out.println("3. Buscar Item por Nome");
            System.out.println("4. Criar Pedido");
            System.out.println("5. Listar Pedidos");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nomeItem = scanner.nextLine();
                    System.out.print("Preço do item: ");
                    double preco = scanner.nextDouble();
                    gerenciadorDeItens.cadastrarItem(nomeItem, preco);
                    break;
                case 2:
                    gerenciadorDeItens.listarItens();
                    break;
                case 3:
                    System.out.print("Digite o nome do item: ");
                    String buscaNome = scanner.nextLine();
                    Item itemEncontrado = gerenciadorDeItens.buscarItemPorNome(buscaNome);
                    if (itemEncontrado != null) {
                        System.out.println("Item encontrado: " + itemEncontrado.getNome() + ", Preço: R$ " + itemEncontrado.getPreco());
                    } else {
                        System.out.println("Item não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Nome do item a comprar: ");
                    String nomeItemCompra = scanner.nextLine();
                    Item itemParaPedido = gerenciadorDeItens.buscarItemPorNome(nomeItemCompra);
                    if (itemParaPedido == null) {
                        System.out.println("Item não encontrado.");
                        break;
                    }
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    gerenciadorDePedidos.criarPedido(nomeCliente, itemParaPedido, quantidade);
                    break;
                case 5:
                    gerenciadorDePedidos.listarPedidos();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
