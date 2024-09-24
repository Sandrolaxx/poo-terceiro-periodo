import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Testaobjeto {

    static int ids = 1;
    static int itemid = 1;

    public static void main(String[] args) {

        List<Pedido> pedidos = new LinkedList<Pedido>();
        Item[] itens = new Item[5];
        Endereco enderecoGenerico = new Endereco("esmeralda", "tupiti", "Rua jostelei");
        Loja loja1 = new Loja("Loja 1", "Razão Social 1", "45.789.348/0001-54", enderecoGenerico);
        Vendedor vendedor1 = new Vendedor("Vendedor 1", 20, new double[] { 1000, 2000, 4900 }, 2000, enderecoGenerico);
        Vendedor vendedor2 = new Vendedor("Ricardo", 25, new double[] { 1500 }, 2000, enderecoGenerico);

        vendedor1.setLoja(loja1);
        vendedor2.setLoja(loja1);

        loja1.setVendedores(new Vendedor[] { vendedor1, vendedor2 });

        Cliente cliente1 = new Cliente("ian", 40, enderecoGenerico);
        loja1.setClientes( new Cliente[] { cliente1 });
        vendedor2.apresentarse();

        itens[0] = new Item("cafe", 25);

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
                    for (Vendedor v : loja1.getVendedores()) {
                        if (v.getNome().equals(nomeVendedor)) {
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
                        if (pedido.getId() == id) {
                            pedidoFinalizado = pedido;
                            break;
                        }
                    }

                    if (pedidoFinalizado == null) {
                        
                        System.out.println("Nenhum pedido encontrado com esse ID.");
                        break; 
                        
                    }

                    pedidoFinalizado.geraDescricaoVenda();

                    if (ProcessaPedido.confirmarPagamento(pedidoFinalizado)) {
                        System.out.println("Pedido finalizado com sucesso.");
                        
                    } else {
                        System.out.println("Não foi possível concluir este pedido, por favor, faça uma nova reserva.");
                    }

                    break;

                    case 4:
                    System.out.println("cadastrando item");
                    System.out.println("digite o nome do item");
                    String nomeDoitem = scanner.nextLine();
                    System.out.println("digite o calor unitario do item");
                    float valroDoItem = scanner.nextFloat();
                    scanner.nextLine();

                    for (int i = 0; i < 5; i++) {
                        if (itens[i] == null ) {
                            itens[i] = new Item(nomeDoitem, valroDoItem);
                            break;
                        }else if (i == 4 && itens[i] != null) {
                            
                            System.out.println("O total de 5 itens já foi atingido");
                        }
                    }
                    break;

                    case 5:
                        for (Item item : itens) {
                            if (item != null) {
                                item.gerarDescricao();
                            }
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
