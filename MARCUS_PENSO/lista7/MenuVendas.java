
package MARCUS_PENSO.lista7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MenuVendas {
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static ArrayList<Item> itens = new ArrayList<>();

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
            System.out.println("[8] - Cadastrar Item");
            System.out.println("[9] - Listar Itens");
            System.out.println("[10] - Buscar Item por Nome");
            System.out.println("[11] - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    exibirRegistrosDeVendas();
                    break;
                case 4:
                    registrarVendasDoDia();
                    break;
                case 5:
                    buscarVendasPorDia(scanner);
                    break;
                case 6:
                    buscarVendasPorMes(scanner);
                    break;
                case 7:
                    criarPedido(scanner);
                    break;
                case 8:
                    cadastrarItem(scanner);
                    break;
                case 9:
                    listarItens();
                    break;
                case 10:
                    buscarItemPorNome(scanner);
                    break;
                case 11:
                    System.out.println("Saindo...");
                    System.exit(0);
            }
        }
    }

    // Métodos faltantes adicionados

    private static void exibirRegistrosDeVendas() {
        System.out.println("Registros de Vendas:");
        for (Pedido pedido : pedidos) {
            pedido.exibirDescricao();
        }
    }

    private static void registrarVendasDoDia() {
        System.out.println("Vendas do Dia registradas.");
    }

    private static void buscarVendasPorDia(Scanner scanner) {
        System.out.print("Digite a data (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        Date data = parseDate(dataStr);
        if (data != null) {
            for (Pedido pedido : pedidos) {
                if (pedido.getDataCriacao().equals(data)) {
                    pedido.exibirDescricao();
                }
            }
        } else {
            System.out.println("Data inválida.");
        }
    }

    private static void buscarVendasPorMes(Scanner scanner) {
        System.out.print("Digite o mês e ano (MM/yyyy): ");
        String mesAno = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        for (Pedido pedido : pedidos) {
            String dataPedido = sdf.format(pedido.getDataCriacao());
            if (dataPedido.equals(mesAno)) {
                pedido.exibirDescricao();
            }
        }
    }

    // Método para calcular o preço total
    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário: ");
        double precoUnitario = scanner.nextDouble();
        double precoTotal = quantidade * precoUnitario;
        System.out.println("Preço Total: " + precoTotal);
    }

    // Método para calcular o troco
    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();
        double troco = valorRecebido - valorTotal;
        System.out.println("Troco: " + troco);
    }

    // Método para criar um pedido
    private static void criarPedido(Scanner scanner) {
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

        // Busca do item no sistema
        System.out.print("Digite o nome do item: ");
        String nomeItem = scanner.nextLine();
        Item itemSelecionado = buscarItem(nomeItem);
        if (itemSelecionado != null) {
            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            ArrayList<Item> itensDoPedido = new ArrayList<>();
            for (int i = 0; i < quantidade; i++) {
                itensDoPedido.add(itemSelecionado);
            }
            Pedido pedido = new Pedido(id, dataCriacao, dataPagamento, dataVencimentoReserva, loja, cliente, vendedor, itensDoPedido);
            pedidos.add(pedido);
            System.out.println("Pedido criado com sucesso!");
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    // Método para cadastrar um item
    private static void cadastrarItem(Scanner scanner) {
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo do item: ");
        String tipo = scanner.nextLine();
        System.out.print("Digite o preço do item: ");
        double preco = scanner.nextDouble();
        Item item = new Item(itens.size() + 1, nome, tipo, preco);
        itens.add(item);
        System.out.println("Item cadastrado com sucesso!");
    }

    // Método para listar itens
    private static void listarItens() {
        if (itens.size() < 2) {
            System.out.println("Cadastre pelo menos 2 itens.");
        } else {
            for (Item item : itens) {
                System.out.println("Item: " + item.getNome() + ", Preço: " + item.getPreco());
            }
        }
    }

    // Método para buscar item por nome
    private static void buscarItemPorNome(Scanner scanner) {
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        Item item = buscarItem(nome);
        if (item != null) {
            System.out.println("Item encontrado: " + item.getNome() + ", Preço: " + item.getPreco());
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    // Método para buscar um item pelo nome
    private static Item buscarItem(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    // Métodos auxiliares para data e outros
    private static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Data inválida.");
            return null;
        }
    }
}
