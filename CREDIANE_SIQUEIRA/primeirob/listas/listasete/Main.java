package CREDIANE_SIQUEIRA.primeirob.listas.listasete;

    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;
    import java.util.Scanner;
    
    public class Main {
        private static List<Item> itensCadastrados = new ArrayList<>();
    
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
                System.out.println("2. Cadastrar Item");
                System.out.println("3. Listar Itens");
                System.out.println("4. Buscar Item por Nome");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); 
    
                switch (opcao) {
                    case 1:
                        criarPedido(scanner, processaPedido, cliente, vendedor, loja);
                        break;
                    case 2:
                        cadastrarItem(scanner);
                        break;
                    case 3:
                        listarItens();
                        break;
                    case 4:
                        buscarItemPorNome(scanner);
                        break;
                    case 5:
                        continuar = false;
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            }
    
            scanner.close();
        }
    
        public static void cadastrarItem(Scanner scanner) {
            System.out.println("Cadastrando um novo item...");
    
            System.out.print("Digite o ID do item: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
    
            System.out.print("Digite o nome do item: ");
            String nome = scanner.nextLine();
    
            System.out.print("Digite o tipo do item: ");
            String tipo = scanner.nextLine();
    
            System.out.print("Digite o valor do item: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); 
    
            itensCadastrados.add(new Item(id, nome, tipo, valor));
            System.out.println("Item cadastrado com sucesso!");
        }
    
        public static void listarItens() {
            System.out.println("Itens cadastrados:");
            for (Item item : itensCadastrados) {
                item.gerarDescricao();
            }
        }
    
        public static void buscarItemPorNome(Scanner scanner) {
            System.out.print("Digite o nome do item que deseja buscar: ");
            String nome = scanner.nextLine();
    
            boolean itemEncontrado = false;
            for (Item item : itensCadastrados) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    item.gerarDescricao();
                    itemEncontrado = true;
                    break;
                }
            }
    
            if (!itemEncontrado) {
                System.out.println("Item não encontrado.");
            }
        }
    
        public static void criarPedido(Scanner scanner, ProcessaPedido processaPedido, Cliente cliente, Vendedor vendedor, String loja) {
            System.out.println("Criando um novo pedido...");
    
            List<Item> itensDoPedido = new ArrayList<>();
            boolean adicionarItens = true;
            while (adicionarItens) {
                listarItens();
                System.out.print("Digite o ID do item que deseja comprar: ");
                int id = scanner.nextInt();
                scanner.nextLine(); 
    
                System.out.print("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); 
    
                for (Item item : itensCadastrados) {
                    if (item.getId() == id) {
                        for (int i = 0; i < quantidade; i++) {
                            itensDoPedido.add(item);
                        }
                        break;
                    }
                }
    
                System.out.print("Deseja adicionar mais itens? (s/n): ");
                String resposta = scanner.nextLine();
                if (!resposta.equalsIgnoreCase("s")) {
                    adicionarItens = false;
                }
            }
    
            Date dataCriacao = new Date();
            Pedido pedido = processaPedido.processar(1, dataCriacao, cliente, vendedor, loja, itensDoPedido);
    
            pedido.gerarDescricaoVenda();
    
            System.out.print("Deseja confirmar o pagamento? (s/n): ");
            String confirmarPagamento = scanner.nextLine();
            if (confirmarPagamento.equalsIgnoreCase("s")) {
                Date dataPagamento = new Date();  
                processaPedido.confirmarPagamento(pedido, dataPagamento);
            } else {
                System.out.println("Pagamento não confirmado.");
            }
        }
    }
    