package ISAQUI_CAMARGO_BARAI.primeirob.listas.listadois;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoquedevendas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Venda venda = new Venda();
        RegistroVendas registroVendas = new RegistroVendas();
        int opcao;

        do {
            System.out.println("===== Calculadora de Vendas =====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Ver Registro de Vendas");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calcularPrecoTotal(scanner);
                    break;
                case 2:
                    calcularTroco(scanner);
                    break;
                case 3:
                    registrarVenda(scanner, venda, registroVendas);
                    break;
                case 4:
                    registroVendas.exibirVendas();
                    break;
                case 5:
                    System.out.println("Encerrando a calculadora...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);

        scanner.close();
    }

    private static void calcularPrecoTotal(Scanner scanner) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double precoUnitario = scanner.nextDouble();
        
        double precoTotal = quantidade * precoUnitario;
        System.out.println("O preço total é: R$ " + precoTotal);
    }

    private static void calcularTroco(Scanner scanner) {
        System.out.print("Digite o valor recebido do cliente: ");
        double valorRecebido = scanner.nextDouble();
        System.out.print("Digite o valor total da compra: ");
        double valorTotal = scanner.nextDouble();
        
        double troco = valorRecebido - valorTotal;
        System.out.println("O troco a ser devolvido é: R$ " + troco);
    }

    private static void registrarVenda(Scanner scanner, Venda venda, RegistroVendas registroVendas) {
        System.out.print("Digite a quantidade de plantas: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço unitário da planta: ");
        double preco = scanner.nextDouble();
        
        double valorFinal = venda.calcularValorFinal(quantidade, preco);
        System.out.println("Valor Final com desconto (se aplicável): R$ " + valorFinal);
        registroVendas.registrarVenda(quantidade, preco, valorFinal);
    }
}

class Venda {

    public double calcularValorFinal(int quantidade, double preco) {
        double valorTotal = quantidade * preco;
        if (quantidade > 10) {
            valorTotal *= 0.95; // Aplica 5% de desconto
        }
        return valorTotal;
    }
}

class RegistroVendas {
    private List<String> vendas;

    public RegistroVendas() {
        vendas = new ArrayList<>();
    }

    public void registrarVenda(int quantidade, double precoUnitario, double valorFinal) {
        String venda = "Quantidade: " + quantidade + ", Preço Unitário: R$" + precoUnitario + ", Valor Final: R$" + valorFinal;
        vendas.add(venda);
    }

    public void exibirVendas() {
        System.out.println("\n===== Registro de Vendas =====");
        for (String venda : vendas) {
            System.out.println(venda);
        }
    }
    
}
