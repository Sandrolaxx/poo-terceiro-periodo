package DIONATAN_DARIZ.primeirob.listas.listaseis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcessaPedido processaPedido = new ProcessaPedido();

        Loja loja = new Loja("Flor do Campo");
        Vendedor vendedor = new Vendedor("Maria", 28, loja);
        Cliente cliente = new Cliente("João", 30, "Rua das Flores", "Jardim", "São Paulo");
        Item item1 = new Item(101, "Vaso de Cerâmica", "Decoração", 59.99);
        Item item2 = new Item(102, "Planta Exótica", "Jardim", 120.50);
        Item[] itens = {item1, item2};

        boolean executando = true;
        Pedido novoPedido = null;

        while (executando) {
            System.out.println("\nMENU:");
            System.out.println("1. Criar Pedido");
            System.out.println("2. Confirmar Pagamento do Pedido");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:

                    System.out.println("Digite o ID do pedido: ");
                    int idPedido = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Informe a data de criação do pedido (formato: dd/MM/yyyy): ");
                    String dataCriacaoStr = scanner.nextLine();
                    Date dataCriacao = parseDate(dataCriacaoStr);

                    System.out.println("Informe a data de pagamento do pedido (formato: dd/MM/yyyy): ");
                    String dataPagamentoStr = scanner.nextLine();
                    Date dataPagamento = parseDate(dataPagamentoStr);

                    System.out.println("Informe a data de vencimento da reserva (formato: dd/MM/yyyy): ");
                    String dataVencimentoStr = scanner.nextLine();
                    Date dataVencimentoReserva = parseDate(dataVencimentoStr);

                    novoPedido = processaPedido.processar(idPedido, dataCriacao, dataPagamento, dataVencimentoReserva, cliente, vendedor, loja, itens);
                    System.out.println("Pedido criado com sucesso!\n");
                    novoPedido.gerarDescricaoVenda();
                    break;

                case 2:
                    if (novoPedido != null) {
                      
                        System.out.println("Confirmando pagamento do pedido...");
                        boolean sucesso = processaPedido.confirmarPagamento(novoPedido);
                        if (sucesso) {
                            System.out.println("Pagamento confirmado.");
                        } else {
                            System.out.println("Pagamento não confirmado. A reserva está vencida.");
                        }
                    } else {
                        System.out.println("Nenhum pedido criado para confirmar o pagamento.");
                    }
                    break;

                case 3:
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
        scanner.close();
    }

    private static Date parseDate(String dateStr) {
        try {
            return DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data. Usando a data atual.");
            return new Date();
        }
    }
}
