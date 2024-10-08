package ROBSON_DE_LIMA.primeirob.listas.listaSete;

import ROBSON_DE_LIMA.primeirob.listas.listaSeis.Pedido;

public class criarPedido {
    
    public static void criarPedido(Scanner scanner) {
    System.out.print("Digite o ID do item que deseja comprar: ");
    int id = scanner.nextInt();
    
    Item itemEscolhido = null;
    for (Item item : itensCadastrados) {
        if (item.getId() == id) {
            itemEscolhido = item;
            break;
        }
    }

    if (itemEscolhido == null) {
        System.out.println("Item não encontrado.");
        return;
    }

    System.out.print("Digite a quantidade: ");
    int quantidade = scanner.nextInt();

    // Criar o pedido com os dados do cliente e vendedor
    Pedido pedido = new Pedido(1, new Date(), null, null, null, null, null, Arrays.asList(itemEscolhido));
    double valorTotal = pedido.calcularValorTotal();
    System.out.printf("Pedido criado! Valor total: R$ %.2f%n", valorTotal);
}

}
