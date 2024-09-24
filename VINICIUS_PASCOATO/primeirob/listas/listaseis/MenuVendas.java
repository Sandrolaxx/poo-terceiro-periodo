package VINICIUS_PASCOATO.primeirob.listas.listaseis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MenuVendas {
    private static ArrayList<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Exibir Registros de Vendas");
            System.out.println("[4] - Registrar Vendas do Dia");
            System.out.println("[5] - Buscar Vendas por Dia");
            System.out.println("[6] - Buscar Vendas por Mês");
            System.out.println("[7] - Criar Pedido");
            System.out.println("[8] - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o preço unitário: ");
                    double precoUnitario = scanner.nextDouble();
                    double precoTotal = calcularPrecoTotal(quantidade, precoUnitario);
                    System.out.println("Preço Total: " + precoTotal);
                    break;
                case 2:
                    System.out.print("Digite o valor recebido: ");
                    double valorRecebido = scanner.nextDouble();
                    System.out.print("Digite o valor total da compra: ");
                    double valorTotal = scanner.nextDouble();
                    double troco = calcularTroco(valorRecebido, valorTotal);
                    System.out.println("Troco: " + troco);
                    break;
                case 3:
                    exibirRegistrosDeVendas();
                    break;
                case 4:
                    registrarVendasDoDia();
                    break;
                case 5:
                    System.out.print("Digite a data (dd/MM/yyyy): ");
                    String dataDia = scanner.nextLine();
                    buscarVendasPorDia(dataDia);
                    break;
                case 6:
                    System.out.print("Digite o mês e ano (MM/yyyy): ");
                    String mesAno = scanner.nextLine();
                    buscarVendasPorMes(mesAno);
                    break;
                case 7:
                    criarPedido();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static double calcularPrecoTotal(int quantidade, double precoUnitario) {
        double total = quantidade * precoUnitario;
        if (quantidade > 10) {
            total *= 0.95;
        }
        return total;
    }

    public static double calcularTroco(double valorRecebido, double valorTotal) {
        return valorRecebido - valorTotal;
    }

    public static void exibirRegistrosDeVendas() {
        for (Pedido pedido : pedidos) {
            pedido.gerarDescricaoVenda();
        }
    }

    public static void registrarVendasDoDia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a data de criação (dd/MM/yyyy): ");
        String dataCriacaoStr = scanner.nextLine();
        Date dataCriacao = parseDate(dataCriacaoStr);
        System.out.print("Digite a data de pagamento (dd/MM/yyyy, deixe em branco se não pago): ");
        String dataPagamentoStr = scanner.nextLine();
        Date dataPagamento = dataPagamentoStr.isEmpty() ? null : parseDate(dataPagamentoStr);
        System.out.print("Digite a data de vencimento da reserva (dd/MM/yyyy): ");
        String dataVencimentoReservaStr = scanner.nextLine();
        Date dataVencimentoReserva = parseDate(dataVencimentoReservaStr);

        Loja loja = TestObjects.criarLoja();
        Cliente cliente = TestObjects.criarCliente();
        Vendedor vendedor = TestObjects.criarVendedor1();
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Planta A", "Tipo A", 20.0));
        itens.add(new Item(2, "Planta B", "Tipo B", 30.0));

        Pedido pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, loja, cliente, vendedor, itens);
        pedidos.add(pedido);

        System.out.println("Venda registrada com sucesso!");
    }

    public static void buscarVendasPorDia(String dataDia) {
        Date data = parseDate(dataDia);
        for (Pedido pedido : pedidos) {
            if (pedido.getDataCriacao().equals(data)) {
                pedido.gerarDescricaoVenda();
            }
        }
    }

    public static void buscarVendasPorMes(String mesAno) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        for (Pedido pedido : pedidos) {
            SimpleDateFormat pedidoSdf = new SimpleDateFormat("MM/yyyy");
            if (pedidoSdf.format(pedido.getDataCriacao()).equals(mesAno)) {
                pedido.gerarDescricaoVenda();
            }
        }
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Data inválida.");
            return null;
        }
    }
    
    private static void criarPedido() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a data de criação (dd/MM/yyyy): ");
        String dataCriacaoStr = scanner.nextLine();
        Date dataCriacao = parseDate(dataCriacaoStr);
        System.out.print("Digite a data de pagamento (dd/MM/yyyy, deixe em branco se não pago): ");
        String dataPagamentoStr = scanner.nextLine();
        Date dataPagamento = dataPagamentoStr.isEmpty() ? null : parseDate(dataPagamentoStr);
        System.out.print("Digite a data de vencimento da reserva (dd/MM/yyyy): ");
        String dataVencimentoReservaStr = scanner.nextLine();
        Date dataVencimentoReserva = parseDate(dataVencimentoReservaStr);

        Loja loja = TestObjects.criarLoja();
        Cliente cliente = TestObjects.criarCliente();
        Vendedor vendedor = TestObjects.criarVendedor1();
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Planta A", "Tipo A", 20.0));
        itens.add(new Item(2, "Planta B", "Tipo B", 30.0));

        Pedido pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, loja, cliente, vendedor, itens);
        pedidos.add(pedido);

        System.out.println("Pedido criado com sucesso!");
    }
}
