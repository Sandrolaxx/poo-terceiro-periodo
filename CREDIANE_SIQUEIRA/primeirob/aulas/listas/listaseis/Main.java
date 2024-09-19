package CREDIANE_SIQUEIRA.primeirob.aulas.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Endereco enderecoCliente = new Endereco("Paraná", "Cascavel", "Fag", "Avenida das Torres", "Complemento");
        Cliente cliente = new Cliente("Luzia", 35, enderecoCliente);

        Endereco enderecoVendedor = new Endereco("Paraná", "Bela Vista", "Via Bela", "Luna Maria da Silva", "Complemento");
        Vendedor vendedor = new Vendedor("José", 40, enderecoVendedor);

        String loja = "Loja";

        ProcessaPedido processaPedido = new ProcessaPedido();

        boolean continuar = true;
        while (continuar) {
            System.out.println("===== MENU =====");
            System.out.println("1. Criar Pedido");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    criarPedido(scanner, processaPedido, cliente, vendedor, loja);
                    break;
                case 2:
                    continuar = false;
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }

    public static void criarPedido(Scanner scanner, ProcessaPedido processaPedido, Cliente cliente, Vendedor vendedor, String loja) {
        System.out.println("Criando um novo pedido...");

        List<Item> itens = new ArrayList<>();
        boolean adicionarItens = true;
        while (adicionarItens) {
            System.out.print("Digite o ID do item: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            System.out.print("Digite o nome do item: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o tipo do item: ");
            String tipo = scanner.nextLine();

            System.out.print("Digite o valor do item: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();  // Consumir nova linha

            itens.add(new Item(id, nome, tipo, valor));

            System.out.print("Deseja adicionar mais itens? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                adicionarItens = false;
            }
        }

        Date dataCriacao = new Date();

        Pedido pedido = processaPedido.processar(1, dataCriacao, cliente, vendedor, loja, itens);

        pedido.gerarDescricaoVenda();

        System.out.print("Deseja confirmar o pagamento? (s/n): ");
        String confirmarPagamento = scanner.nextLine();
        if (confirmarPagamento.equalsIgnoreCase("s")) {
            Date dataPagamento = new Date();  // Usando data atual para simular pagamento imediato
            processaPedido.confirmarPagamento(pedido, dataPagamento);
        } else {
            System.out.println("Pagamento não confirmado.");
        }
    }
}
