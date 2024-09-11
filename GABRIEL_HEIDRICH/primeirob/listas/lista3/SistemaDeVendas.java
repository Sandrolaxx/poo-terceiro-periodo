package lista3;
import java.util.Scanner;

class Venda {
    private static final int MESES = 12;    
    private static final int DIAS_POR_MES = 30; 
    
    private int[][] vendas; 

    public Venda() {
        vendas = new int[MESES][DIAS_POR_MES]; 
    }

    public void registrarVenda(int mes, int dia, int quantidade) {
        if (validarMesEDia(mes, dia)) {
            vendas[mes - 1][dia - 1] = quantidade;
            System.out.println("Venda registrada com sucesso para o dia " + dia + " do mês " + mes);
        } else {
            System.out.println("Erro: Mês ou dia inválido. Tente novamente.");
        }
    }

    public void consultarVendaDia(int mes, int dia) {
        if (validarMesEDia(mes, dia)) {
            int quantidadeVendas = vendas[mes - 1][dia - 1];
            System.out.println("Venda do dia " + dia + " do mês " + mes + ": " + quantidadeVendas + " vendas");
        } else {
            System.out.println("Erro: Mês ou dia inválido. Tente novamente.");
        }
    }

    public void consultarVendaMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            int totalVendas = 0;
            for (int dia = 0; dia < DIAS_POR_MES; dia++) {
                totalVendas += vendas[mes - 1][dia];
            }
            System.out.println("Total de vendas no mês " + mes + ": " + totalVendas + " vendas");
        } else {
            System.out.println("Erro: Mês inválido. Tente novamente.");
        }
    }

    private boolean validarMesEDia(int mes, int dia) {
        return (mes >= 1 && mes <= 12) && (dia >= 1 && dia <= 30);
    }
}

public class SistemaDeVendas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Venda venda = new Venda(); // Instancia a classe Venda
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarVenda(scanner, venda);
                    break;
                case 2:
                    consultarVendaDia(scanner, venda);
                    break;
                case 3:
                    consultarVendaMes(scanner, venda);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== Sistema de Vendas =====");
        System.out.println("1. Registrar venda do dia");
        System.out.println("2. Consultar venda de um dia específico");
        System.out.println("3. Consultar total de vendas do mês");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void registrarVenda(Scanner scanner, Venda venda) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();
        
        System.out.print("Digite o dia (1-30): ");
        int dia = scanner.nextInt();

        System.out.print("Digite a quantidade de vendas: ");
        int quantidadeVendas = scanner.nextInt();

        venda.registrarVenda(mes, dia, quantidadeVendas);
    }

    private static void consultarVendaDia(Scanner scanner, Venda venda) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();

        System.out.print("Digite o dia (1-30): ");
        int dia = scanner.nextInt();

        venda.consultarVendaDia(mes, dia);
    }

    private static void consultarVendaMes(Scanner scanner, Venda venda) {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();

        venda.consultarVendaMes(mes);
    }
}
