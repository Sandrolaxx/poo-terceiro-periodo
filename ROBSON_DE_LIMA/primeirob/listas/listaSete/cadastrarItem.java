package ROBSON_DE_LIMA.primeirob.listas.listaSete;

private static List<Item> itensCadastrados = new ArrayList<>();

public static void cadastrarItem(Scanner scanner) {
    System.out.print("Digite o ID do item: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha

    System.out.print("Digite o nome do item: ");
    String nome = scanner.nextLine();

    System.out.print("Digite o tipo do item: ");
    String tipo = scanner.nextLine();

    System.out.print("Digite o valor do item: ");
    double valor = scanner.nextDouble();

    Item item = new Item(id, nome, tipo, valor);
    itensCadastrados.add(item);
    System.out.println("Item cadastrado com sucesso!");
}

public static void listarItens() {
    System.out.println("Itens cadastrados:");
    for (Item item : itensCadastrados) {
        System.out.println(item.gerarDescricao());
    }
    if (itensCadastrados.isEmpty()) {
        System.out.println("Nenhum item cadastrado.");
    }
}

public static void buscarItemPorNome(Scanner scanner) {
    System.out.print("Digite o nome do item: ");
    String nome = scanner.nextLine();
    
    for (Item item : itensCadastrados) {
        if (item.getNome().equalsIgnoreCase(nome)) {
            System.out.println(item.gerarDescricao());
            return;
        }
    }
    System.out.println("Item não encontrado.");
}
