package ALEX_HOFFMANN.primeirob.projetopoo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csv {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar o número de colunas e seus nomes
        System.out.print("Informe o número de colunas: ");
        int numColunas = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        String[] colunas = new String[numColunas];
        for (int i = 0; i < numColunas; i++) {
            System.out.print("Nome da coluna " + (i + 1) + ": ");
            colunas[i] = scanner.nextLine();
        }

        // Solicitar o número de linhas
        System.out.print("Informe o número de linhas: ");
        int numLinhas = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        // Criar lista para armazenar os dados
        List<String[]> dados = new ArrayList<>();

        // Solicitar os dados do usuário
        for (int i = 0; i < numLinhas; i++) {
            String[] linha = new String[numColunas];
            System.out.println("Informe os dados para a linha " + (i + 1) + ":");
            for (int j = 0; j < numColunas; j++) {
                System.out.print(colunas[j] + ": ");
                linha[j] = scanner.nextLine();
            }
            dados.add(linha);
        }

        // Gerar arquivo CSV
        gerarCSV("saida.csv", colunas, dados);
        scanner.close();
        System.out.println("Arquivo CSV gerado com sucesso!");
    }

    public static void gerarCSV(String nomeArquivo, String[] colunas, List<String[]> dados) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            // Escrever cabeçalho
            for (int;