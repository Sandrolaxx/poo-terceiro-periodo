package ISAQUI_CAMARGO_BARAI.primeirob.listas.listatres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Salvandodados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Venda venda = new Venda();
        RegistroVendas registroVendas = new RegistroVendas();
        RegistroVendasPorData registroVendasPorData = new RegistroVendasPorData();
        int opcao;

        do {
            System.out.println("===== Calculadora de Vendas =====");
            System.out.println("[1] - Calcular Preço Total");
            System.out.println("[2] - Calcular Troco");
            System.out.println("[3] - Registrar Venda");
            System.out.println("[4] - Ver Registro de Vendas");
            System.out.println("[5] - Salvar Vendas Totais por Dia");
            System.out.println("[6] - Buscar Vendas Totais por Dia");
            System.out.println("[7] - Sair");
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
                    salvarVendasPorData(scanner, registroVendasPorData);
                    break;
                case 6:
                    buscarVendasPorData(scanner, registroVendasPorData);
                    break;
                case 7:
                    System.out.println("Encerrando a calculadora...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 7);

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

    private static void salvarVendasPorData(Scanner scanner, RegistroVendasPorData registroVendasPorData) {
        System.out.print("Digite o dia: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês: ");
        int mes = scanner.nextInt();
        System.out.print("Digite a quantidade total de vendas do dia: ");
        int quantidadeVendas = scanner.nextInt();
        
        registroVendasPorData.salvarVendasPorDia(mes, dia, quantidadeVendas);
        System.out.println("Vendas salvas com sucesso para o dia " + dia + "/" + mes);
    }

    private static void buscarVendasPorData(Scanner scanner, RegistroVendasPorData registroVendasPorData) {
        System.out.print("Digite o dia: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês: ");
        int mes = scanner.nextInt();
        
        Integer vendas = registroVendasPorData.buscarVendasPorDia(mes, dia);
        if (vendas != null) {
            System.out.println("Total de vendas no dia " + dia + "/" + mes + ": " + vendas);
        } else {
            System.out.println("Nenhum registro encontrado para o dia " + dia + "/" + mes);
        }
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

class RegistroVendasPorData {
    private Map<String, Integer> vendasPorData;

    public RegistroVendasPorData() {
        vendasPorData = new HashMap<>();
    }

    public void salvarVendasPorDia(int mes, int dia, int quantidadeVendas) {
        String chave = gerarChave(mes, dia);
        vendasPorData.put(chave, quantidadeVendas);
    }

    public Integer buscarVendasPorDia(int mes, int dia) {
        String chave = gerarChave(mes, dia);
        return vendasPorData.get(chave);
    }

    private String gerarChave(int mes, int dia) {
        return mes + "-" + dia;
    }
}
