package primeirob.listas.listaseis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcessaPedido processaPedido = new ProcessaPedido();

        
        Cliente cliente = new Cliente("João Silva", 30, "São Paulo", "Centro", "Rua 1");
        Vendedor vendedor = new Vendedor("Maria Oliveira", 28, "Loja A", "São Paulo", "Centro", "Rua 1", null, null);
        Gerente gerente = new Gerente("Carlos Pereira", 40, "Loja 01", "São Paulo", "Centro", "Rua 1", 5000);

        
        cliente.apresentarse();
        vendedor.apresentarse();
        gerente.apresentarse();

        System.out.print("Digite o ID do pedido: ");
        int pedidoId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite o nome da loja: ");
        String loja = scanner.nextLine();

        
        Pedido pedido = processaPedido.processar(pedidoId, cliente, vendedor, loja);

        
        while (true) {
            System.out.print("Adicionar item ao pedido? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                break;
            }

            System.out.print("Digite o ID do item: ");
            int itemId = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Digite o nome do item: ");
            String itemNome = scanner.nextLine();

            System.out.print("Digite o tipo do item: ");
            String itemTipo = scanner.nextLine();

            System.out.print("Digite o valor do item: ");
            double itemValor = scanner.nextDouble();
            scanner.nextLine(); 

            Item item = new Item(itemId, itemNome, itemTipo, itemValor);
            pedido.adicionarItem(item);
        }

        
        pedido.gerarDescricaoVenda();

       
        if (processaPedido.confirmarPagamento(pedido)) {
            System.out.println("Pagamento confirmado.");
        } else {
            System.out.println("Pagamento não confirmado. Reserva vencida.");
        }

        scanner.close();
    }
}