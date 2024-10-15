package JOAO_VITOR_NOVAK_GAVA.primeirob.prova;

import JOAO_VITOR_NOVAK_GAVA.primeirob.prova.classes.Cliente;
import JOAO_VITOR_NOVAK_GAVA.primeirob.prova.classes.Quarto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws ParseException {
        try (Scanner leitor = new Scanner(System.in)) {
            Quarto[] quartos = new Quarto[100];
            Cliente[] clientes = new Cliente[100];
            
            int escolha;
            int totalQuartos = 0;
            int totalClientes = 0;
            
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            
            do {
                System.out.println(
                        "Menu--\n[1] Registrar quarto\n[2] Registrar cliente\n[3] Quartos disponíveis\n[4] Reservar quarto\n[5] Fazer checkout\n[0] Sair");
                escolha = leitor.nextInt();
                
                switch (escolha) {
                    case 1 -> {
                        System.out.print("Digite o número do quarto: ");
                        int numero = leitor.nextInt();
                        System.out.print("Digite o valor da diária: ");
                        double valor = leitor.nextDouble();
                        
                        quartos[totalQuartos] = new Quarto(numero, valor);
                        totalQuartos++;
                        System.out.println("Quarto registrado com sucesso!");
                    }
                    case 2 -> {
                        System.out.print("Digite o nome do cliente: ");
                        leitor.nextLine();
                        String nome = leitor.nextLine();
                        System.out.print("Digite o CPF do cliente: ");
                        String cpf = leitor.nextLine();
                        
                        clientes[totalClientes] = new Cliente(nome, cpf);
                        totalClientes++;
                        System.out.println("Cliente registrado com sucesso!");
                    }
                    case 3 -> {
                        System.out.println("Quartos disponíveis:");
                        for (int i = 0; i < totalQuartos; i++) {
                            if (quartos[i].isDisponivel()) {
                                System.out.println(quartos[i]);
                            }
                        }
                    }
                    case 4 -> {
                        System.out.print("Digite o número do quarto que deseja reservar: ");
                        int numeroQuarto = leitor.nextInt();
                        Quarto quartoEscolhido = null;
                        
                        for (int i = 0; i < totalQuartos; i++) {
                            if (quartos[i].getNumero() == numeroQuarto && quartos[i].isDisponivel()) {
                                quartoEscolhido = quartos[i];
                                break;
                            }
                        }
                        
                        if (quartoEscolhido != null) {
                            System.out.print("Digite a data de check-in (dd/MM/yyyy): ");
                            leitor.nextLine();
                            String checkinStr = leitor.nextLine();
                            Date checkin = formatoData.parse(checkinStr);
                            
                            System.out.print("Digite a data de check-out (dd/MM/yyyy): ");
                            String checkoutStr = leitor.nextLine();
                            Date checkout = formatoData.parse(checkoutStr);
                            
                            quartoEscolhido.reservar(checkin, checkout);
                            System.out.println("Quarto reservado com sucesso!");
                        } else {
                            System.out.println("Quarto não disponível ou inexistente.");
                        }
                    }
                    case 5 -> {
                        System.out.print("Digite o número do quarto para fazer o checkout: ");
                        int numeroQuarto = leitor.nextInt();
                        Quarto quartoEscolhido = null;
                        
                        for (int i = 0; i < totalQuartos; i++) {
                            if (quartos[i].getNumero() == numeroQuarto && !quartos[i].isDisponivel()) {
                                quartoEscolhido = quartos[i];
                                break;
                            }
                        }
                        
                        if (quartoEscolhido != null) {
                            double valorTotal = quartoEscolhido.calcularValorTotal();
                            System.out.println("Valor total a ser cobrado: R$ " + valorTotal);
                            quartoEscolhido.liberar();
                            System.out.println("Checkout realizado com sucesso!");
                        } else {
                            System.out.println("Quarto não está reservado.");
                        }
                    }
                    case 0 -> System.out.println("Você saiu ;)");
                    default -> System.out.println("Opção inválida");
                }
                
            } while (escolha != 0);
        }
    }
}
