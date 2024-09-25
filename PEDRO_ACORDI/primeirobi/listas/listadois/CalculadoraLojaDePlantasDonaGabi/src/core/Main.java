package core;

import domain.entities.Item;
import domain.entities.Sale;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import static infra.DataStructures.salesList;

public class Main {

    public static int option;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            showOptions();
        } while (option != 0);
    }


    public static void showOptions() {
        System.out.println("O que você deseja fazer? (Insira o dígito):\n[0] - Sair.\n[1] - Calcular preço total.\n[2] - Calcular troco.\n[3] - Mostrar vendas.");
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Apenas números inteiros são válidos.");
            scanner.nextLine();
        }
        switch (option) {
            case 1:
                showComputeTotalPriceOption();
                break;
            case 2:
                showComputeChangeOption();
                break;
            case 3:
                showSalesTable();
                break;
            case 0:
                shutDown();
                break;
            default:
                System.out.println("Não foi possível reconhecer a entrada. Tente novamente");
                break;
        }
    }

    public static void showComputeTotalPriceOption() {
        try {
            System.out.println("Insira a quantidade vendida do item: ");
            int qtd = scanner.nextInt();
            System.out.println("Insira o preço do item vendido: ");
            double price = scanner.nextDouble();

            Item item = new Item(price);
            Sale sale = new Sale();
            sale.addItem(item, qtd);
            salesList.add(sale);

            System.out.printf("\nO valor bruto é de R$%.2f e o valor líquido é de R$%.2f.\n", sale.getGrossValue(), sale.getNetValue());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, apenas números são aceitos.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static double getChange(double price, double given) throws Exception {
        if (price > given) {
            throw new Exception("O preço é maior do que o valor recebido pelo cliente.");
        }
        if (price == given) {
            return 0;
        }

        return given - price;
    }

    public static void showComputeChangeOption() {
        try {
            System.out.println("Insira o valor recebido pelo cliente: ");
            double receivedValue = scanner.nextDouble();
            System.out.println("Insira o preço do produto: ");
            double price = scanner.nextDouble();
            double change = getChange(price, receivedValue);
            System.out.printf("\nO troco é de R$%.2f.\n", change);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, apenas números são aceitos.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void showSalesTable(){
        String leftAlignFormat = "| %-7d | %-12s | %-13s | %-13s | %-10s |%n";
        DecimalFormat moneyFormat = new DecimalFormat("$#,##0.00");

        System.out.format("+---------+--------------+---------------+---------------+------------+%n");
        System.out.format("| Venda   | Qtd. Plantas | Valor Bruto   | Valor Líquido | Desconto   |%n");
        System.out.format("+---------+--------------+---------------+---------------+------------+%n");
        for(int i=0; i<salesList.size(); i++){
            Sale sale = salesList.get(i);
            System.out.format(leftAlignFormat,
                    i+1,
                    sale.getTotalQuantity(),
                    moneyFormat.format(sale.getGrossValue()),
                    moneyFormat.format(sale.getNetValue()),
                    moneyFormat.format(sale.getTotalDiscountValue())
                    );
        }
        System.out.format("+---------+--------------+---------------+---------------+------------+%n");
    }

    public static void shutDown() {
        System.out.println("Adeus.");
        System.exit(0);
    }

}