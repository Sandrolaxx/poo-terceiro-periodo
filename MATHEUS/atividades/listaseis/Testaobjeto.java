import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Testaobjeto {

    static int ids = 1;

    public static void main(String[] args) {

        List<Pedido> pedidos = new LinkedList<Pedido>();
        Endereco enderecoGenerico = new Endereco("esmeralda", "tupiti", "Rua jostelei");
        Loja loja1 = new Loja("Loja 1", "Razão Social 1", "45.789.348/0001-54", enderecoGenerico);
        Vendedor vendedor1 = new Vendedor("Vendedor 1", 20, new double[] { 1000, 2000, 4900 }, 2000, enderecoGenerico);
        Vendedor vendedor2 = new Vendedor("Ricardo", 25, new double[] { 1500 }, 2000, enderecoGenerico);

        vendedor1.loja = loja1;
        vendedor2.loja = loja1;

        loja1.vendedores = new Vendedor[] { vendedor1, vendedor2 };

        Cliente cliente1 = new Cliente("ian", 40, enderecoGenerico);
        loja1.clientes = new Cliente[] { cliente1 };
        vendedor2.apresentarse();

        Item itens[] = { new Item("cafe", 25) };

        pedidos.add(ProcessaPedido.processar(cliente1, vendedor2, loja1, itens));

        int menu = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            menu = Menu.exibeMenu();
            switch (menu) {
                case 0 :
                    System.out.println("finalizando o sistema");
                break;

                case 1:
                    System.out.println("Criando um novo pedido...");
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, 0, enderecoGenerico);

                    System.out.print("Digite o nome do vendedor: ");
                    String nomeVendedor = scanner.nextLine();

                    Vendedor vendedor = null;
                    for (Vendedor v : loja1.vendedores) {
                        if (v.nome.equals(nomeVendedor)) {
                            vendedor = v;
                            break;
                        }
                    }
                    if (vendedor == null) {
                        System.out.println("Vendedor não encontrado.");
                        break;
                    }

                    System.out.print("Quantos itens você deseja adicionar ao pedido? ");
                    int numItens = Integer.parseInt(scanner.nextLine());
                    Item[] novosItens = new Item[numItens];

                    for (int i = 0; i < numItens; i++) {
                        System.out.print("Digite o nome do item " + (i + 1) + ": ");
                        String nomeItem = scanner.nextLine();
                        System.out.print("Digite o preço do item " + (i + 1) + ": ");
                        Float precoItem = Float.parseFloat(scanner.nextLine());
                        novosItens[i] = new Item(nomeItem, precoItem);
                    }

                    pedidos.add(ProcessaPedido.processar(cliente, vendedor, loja1, novosItens));

                    break;

                case 2:
                    System.out.println("Listar pedidos");
                    for (Pedido pedido : pedidos) {
                        pedido.geraDescricaoVenda();
                    }

                    break;

                case 3:
                    System.out.println("Digite o ID do pedido que deseja finalizar:");
                    int id;

                
                    try {
                        id = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número.");
                        scanner.nextLine(); 
                        break; 
                    }

                    Pedido pedidoFinalizado = null;
                    for (Pedido pedido : pedidos) {
                        if (pedido.id == id) {
                            pedidoFinalizado = pedido;
                            break;
                        }
                    }

                    if (pedidoFinalizado == null) {
                        System.out.println("Nenhum pedido encontrado com esse ID.");
                        break; // Retorna ao menu
                    }

                    pedidoFinalizado.geraDescricaoVenda(); // Se houver alguma saída, considere imprimi-la

                    if (ProcessaPedido.confirmarPagamento(pedidoFinalizado)) {
                        System.out.println("Pedido finalizado com sucesso.");
                        
                    } else {
                        System.out.println("Não foi possível concluir este pedido, por favor, faça uma nova reserva.");
                    }

                    break;
                default:
                    System.out.println("Opção não encontrada");
                    break;
            }
        } while (menu != 0);

        scanner.close();
    }

}
