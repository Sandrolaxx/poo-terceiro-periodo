import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String nome;
    private double preco;

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Item: " + nome + ", Preço: " + preco;
    }
}

class Pedido {
    private String usuario;
    private Item item;
    private int quantidade;

    public Pedido(String usuario, Item item, int quantidade) {
        this.usuario = usuario;
        this.item = item;
        this.quantidade = quantidade;
    }

    public double calcularTotal() {
        return item.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return "Usuário: " + usuario + ", Item: " + item.getNome() + ", Quantidade: " + quantidade + ", Total: R$ " + calcularTotal();
    }
}

public class Main {
    static ArrayList<Item> itens = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar item");
            System.out.println("2. Listar itens");
            System.out.println("3. Buscar item por nome");
            System.out.println("4. Criar pedido");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarItem(scanner);
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    buscarItem(scanner);
                    break;
                case 4:
                    criarPedido(scanner);
                    break;
                case 5:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    public static void cadastrarItem(Scanner scanner) {
        System.out.print("Digite o nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do item: ");
        double preco = scanner.nextDouble();
        itens.add(new Item(nome, preco));
        System.out.println("Item cadastrado com sucesso!");
    }

    public static void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }

    public static void buscarItem(Scanner scanner) {
        System.out.print("Digite o nome do item que deseja buscar: ");
        String nome = scanner.nextLine();
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                System.out.println(item);
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }

    public static void criarPedido(Scanner scanner) {
        System.out.print("Digite o nome do usuário: ");
        String usuario = scanner.nextLine();
        listarItens();
        System.out.print("Digite o nome do item que deseja comprar: ");
        String nomeItem = scanner.nextLine();
        Item itemEscolhido = null;
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
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
        Pedido pedido = new Pedido(usuario, itemEscolhido, quantidade);
        System.out.println("Pedido criado com sucesso:");
        System.out.println(pedido);
    }
}
