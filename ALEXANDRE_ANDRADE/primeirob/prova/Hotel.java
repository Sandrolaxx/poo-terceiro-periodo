package primeirob.prova;

import java.util.Scanner;

public class Hotel {
    static Quarto[] quartos = new Quarto[10];
    static Cliente[] clientes = new Cliente[10];
    static int totalDiarias = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < quartos.length; i++) {
            quartos[i] = new Quarto(i + 1);
        }

        while (true) {
            System.out.println("\n1. Cadastrar Cliente");
            System.out.println("2. Listar Quartos");
            System.out.println("3. Reservar Quarto");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Documento do Cliente: ");
                    String documento = scanner.nextLine();
                    clientes[totalDiarias] = new Cliente(nome, documento);
                    totalDiarias++;
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de Quartos:");
                    for (Quarto quarto : quartos) {
                        System.out.println("Quarto " + quarto.numero + ": " + (quarto.disponivel ? "Disponível" : "Indisponível"));
                    }
                    break;

                case 3:
                    System.out.print("Número do Quarto para reserva: ");
                    int numeroQuarto = scanner.nextInt();
                    if (numeroQuarto > 0 && numeroQuarto <= quartos.length) {
                        if (quartos[numeroQuarto - 1].disponivel) {
                            quartos[numeroQuarto - 1].disponivel = false;
                            System.out.println("Quarto " + numeroQuarto + " reservado com sucesso!");
                        } else {
                            System.out.println("Quarto " + numeroQuarto + " não está disponível.");
                        }
                    } else {
                        System.out.println("Número de quarto inválido.");
                    }
                    break;

                case 4:
                    System.out.print("Número do Quarto para check-out: ");
                    int checkOutQuarto = scanner.nextInt();
                    if (checkOutQuarto > 0 && checkOutQuarto <= quartos.length) {
                        if (!quartos[checkOutQuarto - 1].disponivel) {
                            quartos[checkOutQuarto - 1].disponivel = true;
                            System.out.println("Check-out realizado com sucesso do Quarto " + checkOutQuarto);
                        } else {
                            System.out.println("Quarto " + checkOutQuarto + " já está disponível.");
                        }
                    } else {
                        System.out.println("Número de quarto inválido.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

