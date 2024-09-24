package ENZO_PRADO.primeirob.listas.listasete;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestObjects {
    private static List<Item> itens = new ArrayList<>();

    public static void main(String[] args) {
        itens.add(new Item(1, "Orquídea Exótica", "planta", 50));
        itens.add(new Item(2, "Suculenta", "planta", 30));
        Scanner scanner = new Scanner(System.in);
        ProcessarPedido processarPedido = new ProcessarPedido();
        int opcao;
        do{

            System.out.println("----- Menu -----");
            System.out.println("1. Informações do Gerente");
            System.out.println("2. Informações dos Vendedores");
            System.out.println("3. Informações da Loja");
            System.out.println("4. Informações do Cliente");
            System.out.println("5. Criar Pedido");
            System.out.println("6. Cadastrar novo item");
            System.out.println("7. Listar todos os itens");
            System.out.println("8. Pesquisar item por nome");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("------------Informações Gerente------------");
                    mostrarGerente();
                    systemPause();
                    break;
                case 2:
                    System.out.println("------------Informações dos Vendedores------------");
                    mostrarVendedor();
                    systemPause();
                    break;
                case 3:
                    System.out.println("------------Informações da Loja------------");
                    mostrarLoja();
                    systemPause();
                    break;
                case 4:
                    System.out.println("------------Informações do Cliente------------");
                    mostrarCliente();
                    systemPause();
                    break;
                case 5:
               criarPedido(scanner, processarPedido, clienteCadastradoUm(), vendedorCadastradoDois(), lojaCadastradaUm(), itens);
               systemPause();
                break;
                case 6: 
                cadastrarItem(scanner);
                systemPause();
                  break;
                case 7:
                    listarItens();
                    systemPause();
                    break;
                case 8:
                    buscarItemPorNome(scanner);
                    systemPause();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }while(opcao != 0);
        scanner.close();
    }

    public static Pedido criarPedido(Scanner scanner, ProcessarPedido processarPedido, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        Pedido pedido = processarPedido.processarPedido(cliente, vendedor, loja, new ArrayList<>());
    
        System.out.println("Itens disponíveis para compra:");
        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            item.gerarDescricao();
        }
    
        int opcao;

        do {
            System.out.println("Digite o número do item que deseja adicionar ao pedido ou 0 para finalizar:");
            opcao = scanner.nextInt();
            scanner.nextLine(); 
    
            if (opcao > 0 && opcao <= itens.size()) {
                Item itemEscolhido = itens.get(opcao - 1);
                pedido.adicionarItem(itemEscolhido);
                System.out.println("Item " + itemEscolhido.getNome() + " adicionado ao pedido.");
            } else if (opcao != 0) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        pedido.gerarDescricaoVenda();
    
        System.out.println("Deseja confirmar o pagamento? (s/n): ");
        String confirmar = scanner.nextLine();
        if (confirmar.equalsIgnoreCase("s")) {
            boolean pagamentoConfirmado = processarPedido.confirmarPagamento(pedido);
            if (pagamentoConfirmado) {
                System.out.println("Pagamento confirmado com sucesso!");
            } else {
                System.out.println("Pagamento não confirmado. A reserva expirou.");
            }
        } else {
            System.out.println("Pagamento não confirmado.");
        }
    
        return pedido;
    }


    public static void cadastrarItem(Scanner scanner) {
        System.out.println("Cadastrar novo item");
    
        System.out.print("Informe o nome do item: ");
        String nome = scanner.nextLine();  
    
        System.out.print("Informe p tipo do item: ");
        String categoria = scanner.nextLine(); 
    
        System.out.print("Informe o preço do item: ");
        double preco = scanner.nextDouble();  
        scanner.nextLine();  

        Item novoItem = new Item(itens.size() + 1, nome, categoria, preco);
        itens.add(novoItem);
    
        System.out.println("Item cadastrado com sucesso!");
    }

    public static void buscarItemPorNome(Scanner scanner) {
        System.out.print("Informe o nome do item a ser buscado: ");
        String nomeBuscado = scanner.nextLine();

        boolean encontrado = false;
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeBuscado)) {
                System.out.println(item.getId() + " - " + item.getNome() + " (" + item.getTipo() + ") - R$ " + item.getValor());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Item não encontrado.");
        }
    }


    public static void listarItens(){
        for(Item item : itens){
            System.out.println("ID: " + item.getId() 
            +"\nNome: " + item.getNome() 
            +"\nTipo: " + item.getTipo() 
            + "\nPreço: R$" + item.getValor() );

        }

    }

    private static void systemPause(){
        System.out.println("Pressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void mostrarGerente(){
        Gerente gerenteUm = gerenteCadastradoUm();
                    gerenteUm.apresentarse();
                    gerenteUm.calcularMedia();
                    gerenteUm.calcularBonus();
                   
    }


    public static void mostrarVendedor(){
        Vendedor vendedorUm = vendedorCadastradoUm();
        vendedorUm.apresentarse();
        vendedorUm.calcularMedia();
        vendedorUm.calcularBonus();
        
        Vendedor vendedorDois = vendedorCadastradoDois();

        vendedorDois.apresentarse();
        vendedorDois.calcularMedia();
        vendedorDois.calcularBonus();

    }

    public static void mostrarCliente(){
        Cliente clienteUm = clienteCadastradoUm();
                    clienteUm.apresentarse();
            
    }

    public static void mostrarLoja(){
        Loja loja = lojaCadastradaUm(); 
        loja.adicionarVendedor(vendedorCadastradoUm());
        loja.adicionarVendedor(vendedorCadastradoDois());
        loja.adicionarGerente(gerenteCadastradoUm());
        loja.adicionarCliente(clienteCadastradoUm());
        loja.apresentarse();
        loja.contarClientes();
        loja.contarVendedores();
        loja.contarGerentes();
    }

    private static Item itemCadastradoUm() {
        return new Item(1, "Orquídea Exótica", "planta", 50);
    }

    private static Item itemCadastradoDois() {
        return new Item(2, "Suculenta", "Planta", 30);
    }

    private static Loja lojaCadastradaUm(){
       return new Loja(enderecoLojaCadastradaUm(),"Plantas dona Gabrielinha LTDA" , "My Planty", "26.880.836/0001-11");
    }

    private static Endereco enderecoLojaCadastradaUm(){
        return new Endereco("Parana", "Cascavel", "Universitarios", "AV. Das Torres", 232, "Em frente a praça");
    }


    private static Vendedor vendedorCadastradoUm(){
        return new Vendedor("Enzo", 19, enderecoVendedorCadastradoUm(), lojaCadastradaUm(), 5000, List.of(5000.0,5323.0,5432.0));
    }

    private static Endereco enderecoVendedorCadastradoUm(){
        return new Endereco("Parana", "Cascavel", "Jardim Paulista", "Cuiaba", 332, "Do lado da pizzaria");
    }

    private static Vendedor vendedorCadastradoDois(){
        return new Vendedor("Barbara", 19, enderecoVendedorCadastradoDois(), lojaCadastradaUm(), 8000, List.of(8000.0, 8900.0, 8500.0));
    }

    private static Endereco enderecoVendedorCadastradoDois(){
        return new Endereco("Parana", "Cascavel", "Ciro Nardi", "AV. Carlos Gomes", 367, "Em frente aos correios");
    }
   
    private static Cliente clienteCadastradoUm(){
        return new Cliente("Camille", 20, enderecoClienteCadastradoUm());
    }

    private static Endereco enderecoClienteCadastradoUm(){
        return new Endereco("Parana", "Cascavel", "Universitarios", "Carlos Dias", 332, "Sem complemento");
    }

    private static Gerente gerenteCadastradoUm(){
        return new Gerente("Sandro", 24, enderecoClienteCadastradoUm(), lojaCadastradaUm(), 9500, List.of(10000.0, 9500.0, 10321.0));

    }

    private static Endereco enderecoGerenteCadastradoUm(){
        return new Endereco("Parana", "Cascavel", "Country", "José Rico", 749, "Casa de 4 andares");
    }

}

