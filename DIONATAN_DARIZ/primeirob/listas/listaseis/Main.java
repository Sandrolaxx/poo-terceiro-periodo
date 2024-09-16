package DIONATAN_DARIZ.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Pedido ultimoPedido;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Endereco enderecoLoja = new Endereco("SP", "São Paulo", "Centro", 100, "Sala 1");
        Loja loja = new Loja("Myy Plant", "Exóticas Ltda", "12345678901234", enderecoLoja);
        Vendedor vendedor = new Vendedor("Carlos", 30, loja);
        Cliente cliente = new Cliente("Ana", 45, "São Paulo", "Vila Madalena", "Rua das Flores");

        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Orquídea", "Flor", 50.00));
        itens.add(new Item(2, "Samambaia", "Folhagem", 30.00));

        ProcessaPedido processador = new ProcessaPedido();

        while (true) {
            System.out.println("----- Menu -----");
            System.out.println("[1] - Criar Pedido");
            System.out.println("[2] - Confirmar Pagamento");
            System.out.println("[3] - Ver Detalhes do Pedido");
            System.out.println("[4] - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Pedido pedido = new Pedido(1, new Date(), cliente, vendedor, loja, itens, new Date(System.currentTimeMillis() + 86400000));  // 1 dia para vencer
                    processador.processar(pedido);
                    ultimoPedido = pedido;
                    break;
                case 2:
                    if (ultimoPedido != null) {
                        processador.confirmarPagamento(ultimoPedido);
                    } else {
                        System.out.println("Nenhum pedido foi criado ainda.");
                    }
                    break;
                case 3:
                    if (ultimoPedido != null) {
                        System.out.println("----- Detalhes do Pedido -----");
                        System.out.println("ID do Pedido: " + ultimoPedido.getId());
                        System.out.println("Data de Criação: " + ultimoPedido.getDataCriacao());
                        System.out.println("Cliente: " + ultimoPedido.getCliente().getNome());
                        System.out.println("Vendedor: " + ultimoPedido.getVendedor().getNome());
                        System.out.println("Loja: " + ultimoPedido.getLoja().getNomeFantasia());
                        System.out.println("Itens:");
                        for (Item item : ultimoPedido.getItens()) {
                            item.gerarDescricao();
                        }
                        System.out.println("Data de Vencimento da Reserva: " + ultimoPedido.getDataVencimentoReserva());
                        System.out.println("Valor Total: " + ultimoPedido.calcularValorTotal());
                    } else {
                        System.out.println("Nenhum pedido foi criado ainda.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
