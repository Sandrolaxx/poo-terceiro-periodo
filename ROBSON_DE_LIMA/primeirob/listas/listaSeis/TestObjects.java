package ROBSON_DE_LIMA.primeirob.listas.listaSeis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TestObjects {
    public static void main(String[] args) {
        Loja loja = criarLoja();
        Vendedor vendedor1 = criarVendedor1();
        Cliente cliente = criarCliente();
        List<Item> itens = criarItens();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(" ---------------------------------");
            System.out.println("| Menu:                           |");
            System.out.println("| [1] - Criar Pedido              |");
            System.out.println("| [2] - Sair                      |");
            System.out.println(" ---------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    ProcessaPedido processador = new ProcessaPedido();
                    Pedido pedido = processador.processar(1, new Date(), cliente, vendedor1, loja, itens);
                    if (processador.confirmarPagamento(pedido)) {
                        System.out.println("Pagamento confirmado.");
                    } else {
                        System.out.println("Reserva vencida, pagamento não autorizado.");
                    }
                    break;
                case 2:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 2);

        scanner.close();
    }

    public static Loja criarLoja() {
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "Rua das Flores", "100", "Apt 10");
        return new Loja("Myy Plant", "Myy Plant Comércio de Plantas LTDA", "12.345.678/0001-90", endereco);
    }

    public static Vendedor criarVendedor1() {
        Endereco endereco = new Endereco("SP", "São Paulo", "Centro", "Rua das Flores", "200", "Apt 5");
        return new Vendedor("João", 30, endereco, "Myy Plant", 2000);
    }

    public static Cliente criarCliente() {
        Endereco endereco = new Endereco("SP", "São Paulo", "Jardim", "Rua das Palmeiras", "300", "Casa");
        return new Cliente("Carlos", 40, endereco);
    }

    public static List<Item> criarItens() {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(1, "Vaso de Cerâmica", "Decoração", 45.50));
        itens.add(new Item(2, "Adubo Orgânico", "Jardinagem", 20.00));
        return itens;
    }
}
