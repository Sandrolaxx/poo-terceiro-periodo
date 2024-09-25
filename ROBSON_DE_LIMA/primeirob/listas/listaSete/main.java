package ROBSON_DE_LIMA.primeirob.listas.listaSete;

public class main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
    
        do {
            System.out.println(" --------------------------------");
            System.out.println("| Menu:                           |");
            System.out.println("| [1] - Calcular Preço Total      |");
            System.out.println("| [2] - Calcular Troco            |");
            System.out.println("| [3] - Exibir Registro de Vendas |");
            System.out.println("| [4] - Registrar Vendas Diárias  |");
            System.out.println("| [5] - Buscar Vendas por Data    |");
            System.out.println("| [6] - Cadastro de Item          |");
            System.out.println("| [7] - Listar Itens              |");
            System.out.println("| [8] - Buscar Item por Nome      |");
            System.out.println("| [9] - Criar Pedido              |");
            System.out.println("| [10] - Sair                     |");
            System.out.println(" --------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
    
            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    exibirRegistroVendas();
                    break;
                case 4:
                    registrarVendasDiarias(scanner);
                    break;
                case 5:
                    buscarVendasPorData(scanner);
                    break;
                case 6:
                    cadastrarItem(scanner);
                    break;
                case 7:
                    listarItens();
                    break;
                case 8:
                    buscarItemPorNome(scanner);
                    break;
                case 9:
                    criarPedido(scanner);
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 10);
    
        scanner.close();
    }
    
}
