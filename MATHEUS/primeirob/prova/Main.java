package MATHEUS.primeirob.prova;

import java.util.Date;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente[] clientes = new Cliente[50];
        Quarto[] quartos = new Quarto[100];


        for(int i = 0; i < 10; i++){
            quartos[i+1] = new Quarto(i, false, 45);
        }
        for(int i = 0; i < 10; i++){
            clientes[i] = new Cliente("nome padrão", "123456789-87");
        }

        int menu;
        Scanner scanner = new Scanner(System.in);
        do {
            menu = Menu.exibeMenu();
            switch (menu) {
                case 0 :
                    System.out.println("finalizando o sistema");
                break;

                case 1:
                System.out.println("cadastrando item");
                System.out.println("digite o nome do cliente");
                String nomeDoCliente = scanner.nextLine();
                System.out.println("digite o cpf do cliente");
                String valroDoItem = scanner.nextLine();
                

                for (int i = 0; i < 50; i++) {
                    if (clientes[i] == null ) {
                        clientes[i] = new Cliente(nomeDoCliente, valroDoItem);
                        System.out.println("cliente cadastrado com sucesso");
                        break;
                    }else if (i == 49 && clientes[i] != null) {
                        
                        System.out.println("O total de 50 Clentes já foi atingido");
                    }
                }
                break;

                case 2:
                System.out.println("cadastrando item");
                System.out.println("digite o numero do quarto");
                int numeroDoQuarto = scanner.nextInt();
                System.out.println("insira o valor da diraria do quarto");
                float ValorDaDiaria = scanner.nextFloat();
                scanner.nextLine();

                for (int i = 0; i < 100; i++) {
                    if (quartos[i] == null ) {
                        quartos[i] = new Quarto(numeroDoQuarto,true , ValorDaDiaria);
                        break;
                    }else if (i == 99 && quartos[i] != null) {
                        
                        System.out.println("O total de 100 quartos já foi atingido");
                    }
                }                    
                break;

                case 3:
                    Quarto.listarQuarto(quartos);
                    break;

                case 4:
                    System.out.println("começo da reserva digite o dia:");
                    int[] comecoReserva = new int[3];
                    comecoReserva[0] = scanner.nextInt();
                    System.out.println("o mês:"); 
                    comecoReserva[1] = scanner.nextInt();
                    System.out.println("o ano:");
                    comecoReserva[2] = scanner.nextInt();

                    System.out.println("Fim da reserva da reserva digite o dia:");
                    int[] fimReserva = new int[3];
                    fimReserva[0] = scanner.nextInt();
                    System.out.println("o mês:"); 
                    fimReserva[1] = scanner.nextInt();
                    System.out.println("o ano:");
                    fimReserva[2] = scanner.nextInt();  
                    
                    @SuppressWarnings("deprecation") Date comecoReservaDate = new Date(comecoReserva[0], comecoReserva[1], comecoReserva[2]);
                    @SuppressWarnings("deprecation") Date fimReservDate = new Date(fimReserva[0], fimReserva[1], fimReserva[2]);
                    
                    System.out.println("digite o numero do quarto");
                    int numeroDoQuartoreserva = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("insira o nome do cliente");
                    String nomecliente = scanner.nextLine();
                    Cliente reserva = Cliente.buscarPornome(clientes, nomecliente);
                    Quarto quaroParareserva = Gerenciahotel.buscaQuarto(quartos, numeroDoQuartoreserva);
                    Gerenciahotel.reservaQuarto(quaroParareserva,comecoReservaDate,fimReservDate,reserva);
                                       
                break;

                case 6:
                System.out.println("digite o numero do quarto");
                int resrvaquarto = scanner.nextInt();
                
                Quarto aQuartoencontrado = Gerenciahotel.buscaQuarto(quartos, resrvaquarto);
                Gerenciahotel.calcularValorDiarias(aQuartoencontrado);

                break;
                default:
                    System.out.println("Opção não encontrada");
                break;
            }
        } while (menu != 0);
        scanner.close();
    }    
}