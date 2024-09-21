package ENZO_PRADO.primeirob.listas.listasete;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestObjects {
    public static void main(String[] args) {
        
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
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("------------Informações Gerente------------");
                    Gerente gerenteUm = gerenteCadastradoUm();
                    gerenteUm.apresentarse();
                    gerenteUm.calcularMedia();
                    gerenteUm.calcularBonus();
                    break;
                case 2:
                    System.out.println("------------Informações dos Vendedores------------");
                    Vendedor vendedorUm = vendedorCadastradoUm();
                    vendedorUm.apresentarse();
                    vendedorUm.calcularMedia();
                    vendedorUm.calcularBonus();
                    Vendedor vendedorDois = vendedorCadastradoDois();
                    vendedorDois.apresentarse();
                    vendedorDois.calcularMedia();
                    vendedorDois.calcularBonus();
                    break;
                case 3:
                    System.out.println("------------Informações da Loja------------");
                    Loja loja = lojaCadastradaUm();
                    loja.apresentarse();
                    loja.contarClientes();
                    loja.contarVendedores();
                    loja.contarGerentes();
                    break;
                case 4:
                    System.out.println("------------Informações do Cliente------------");
                    Cliente clienteUm = clienteCadastradoUm();
                    clienteUm.apresentarse();
                    break;
                case 5:
                List<Item> itens = new ArrayList<>();

                Item itemUm = itemCadastradoUm();
                itens.add(itemUm);

                Item itemDois = itemCadastradoDois();
                itens.add(itemDois);
                
                criarPedido(scanner, processarPedido, clienteCadastradoUm(), vendedorCadastradoDois(), lojaCadastradaUm(), itens);
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
        Pedido pedido = processarPedido.processar(cliente, vendedor, loja, new ArrayList<>());
    
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
                System.out.println("Item " + itemEscolhido.nome + " adicionado ao pedido.");
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



    public static Item itemCadastradoUm() {
        Item item = new Item();
        item.id = 1;
        item.nome = "Orquídea Exótica";
        item.tipo = "Planta";
        item.valor = 50.0;
        return item;
    }

    public static Item itemCadastradoDois() {
        Item item = new Item();
        item.id = 2;
        item.nome = "Suculenta";
        item.tipo = "Planta";
        item.valor = 30.0;
        return item;
    }


    

    public static Loja lojaCadastradaUm(){

        Loja loja = new Loja();

        loja.nomeFantasia = "My Planty";
        loja.razaoSocial = "Plantas dona Gabrielinha LTDA";
        loja.cnpj = "26.880.836/0001-11";
        loja.endereco = enderecoLojaCadastradaUm();
        return loja;
    }

    public static Endereco enderecoLojaCadastradaUm(){
        Endereco enderecoLojaUm = new Endereco();

        enderecoLojaUm.estado = "Parana";
        enderecoLojaUm.cidade = "Cascavel";
        enderecoLojaUm.bairro = "Universitarios";
        enderecoLojaUm.rua = "AV. Das Torres";
        enderecoLojaUm.numero = 232;
        enderecoLojaUm.complemento = "Em frente a praça";

        return enderecoLojaUm;
    }


    public static Vendedor vendedorCadastradoUm(){

        Vendedor vendedor = new Vendedor(); 
        vendedor.nome = "Enzo";
        vendedor.idade = 19;
        vendedor.loja = lojaCadastradaUm();
        vendedor.endereco = enderecoVendedorCadastradoUm();
        vendedor.salariBase = 5000;
        vendedor.salarioRecebido = new double[ ]{5000, 5323, 5432};
        return vendedor;
    }

    public static Endereco enderecoVendedorCadastradoUm(){

        Endereco enderecoVendedorCadastradoUm = new Endereco();

        enderecoVendedorCadastradoUm.estado = "Parana";
        enderecoVendedorCadastradoUm.cidade = "Cascavel";
        enderecoVendedorCadastradoUm.bairro = "Jardim Paulista";
        enderecoVendedorCadastradoUm.rua = "Cuiaba";
        enderecoVendedorCadastradoUm.numero = 332;
        enderecoVendedorCadastradoUm.complemento = "Do lado da pizzaria";

        return enderecoVendedorCadastradoUm;
    }

    public static Vendedor vendedorCadastradoDois(){

        Vendedor vendedor2 = new Vendedor(); 
        vendedor2.nome = "Barbara";
        vendedor2.idade = 19;
        vendedor2.loja = lojaCadastradaUm();
        vendedor2.endereco = enderecoVendedorCadastradoDois();
        vendedor2.salariBase = 8000;
        vendedor2.salarioRecebido = new double[ ]{8000, 8900, 8500};

        return vendedor2;
    }

    public static Endereco enderecoVendedorCadastradoDois(){

        Endereco enderecoVendedorCadastradoDois = new Endereco();

        enderecoVendedorCadastradoDois.estado = "Parana";
        enderecoVendedorCadastradoDois.cidade = "Cascavel";
        enderecoVendedorCadastradoDois.bairro = "Ciro Nardi";
        enderecoVendedorCadastradoDois.rua = "AV. Carlos Gomes";
        enderecoVendedorCadastradoDois.numero = 367;
        enderecoVendedorCadastradoDois.complemento = "Em frente aos correios";

        return enderecoVendedorCadastradoDois;
    }

    public static Cliente clienteCadastradoUm(){

        Cliente clienteum = new Cliente();
        

        clienteum.nome = "Camille";

        clienteum.idade = 20;
        
        clienteum.endereco = enderecoClienteCadastradoUm();

        return clienteum;
    }

    
    public static Endereco enderecoClienteCadastradoUm(){

        Endereco enderecoClienteCadastradoUm = new Endereco();

        enderecoClienteCadastradoUm.estado = "Parana";
        enderecoClienteCadastradoUm.cidade = "Cascavel";
        enderecoClienteCadastradoUm.bairro = "Universitarios";
        enderecoClienteCadastradoUm.rua = "Carlos Dias";
        enderecoClienteCadastradoUm.numero = 332;
        enderecoClienteCadastradoUm.complemento = "Sem complemento";

        return enderecoClienteCadastradoUm;
    }

    public static Gerente gerenteCadastradoUm(){

         Gerente gerente = new Gerente();

         gerente.nome = "Sandro";
         gerente.idade = 24;
         gerente.loja = lojaCadastradaUm();
         gerente.endereco = enderecoGerenteCadastradoUm();
         gerente.salariBase = 9000;
         gerente.salarioRecebido = new double[ ]{10000, 9500, 10321};

         return gerente;

    }

    public static Endereco enderecoGerenteCadastradoUm(){

        Endereco enderecoGerenteCadastradoUm = new Endereco();

        enderecoGerenteCadastradoUm.estado = "Parana";
        enderecoGerenteCadastradoUm.cidade = "Cascavel";
        enderecoGerenteCadastradoUm.bairro = "Country";
        enderecoGerenteCadastradoUm.rua = "José Rico";
        enderecoGerenteCadastradoUm.numero = 749;
        enderecoGerenteCadastradoUm.complemento = "Casa de 4 andares";

        return enderecoGerenteCadastradoUm;
    }



}

