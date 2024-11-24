package primeirob.prova.Teste;

import java.util.Scanner;

import primeirob.prova.Dominio.Cliente;

import primeirob.prova.Dominio.Quarto;

public class HotelTest {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Quarto[] quartos = new Quarto[100];
        Cliente[] clientes = new Cliente[100];

        int opcao = 0;
        int contadorCliente = 0;
        int contadorQuarto = 0;

        do {
            System.out.println("[1] Cadastrar clientes/Checkout");
            System.out.println("[2] Cadastrar quartos");
            System.out.println("[3] Listar quartos");
            System.out.println("[4] Reservar quartos");
            System.out.println("[5] Calcular o total de diárias a pagar");
            System.out.println("[6] Verificar disponibilidade");
            System.out.println("[0] Sair");
            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1:
                    if (contadorCliente < clientes.length) {
                        Cliente cliente = new Cliente();
    System.out.println("Nome do cliente:");
    cliente.setNome(input.nextLine());

    System.out.println("Idade do cliente:");
    cliente.setIdade(input.nextInt());
    input.nextLine(); 

                    clientes[contadorCliente++] = cliente;
                    } else {
                        System.out.println("Número máximo de clientes atingido.");
                    }
                    break;

                case 2:
                    if (contadorQuarto < quartos.length) {
                Quarto quarto = new Quarto();
                        System.out.println("Qual número do quarto você gostaria de cadastrar?");
                quarto.setNumeroQuarto(input.nextInt());

        System.out.println("Qual dia gostaria de cadastrar?");    
                                           quarto.setDia(input.nextInt());
                input.nextLine(); 

                       quartos[contadorQuarto++] = quarto;
                    } else {
            System.out.println("Limite máximo de quartos atingido.");
        }
        break;

    case 3:
        System.out.println("Lista de quartos:");
        for (int i = 0; i < contadorQuarto; i++) {
            if (quartos[i] != null) {
                System.out.println("Quarto: " + quartos[i].getNumeroQuarto() + ", Dia: " + quartos[i].getDia());




            }
                    }
                    break;

               case 4:
                    System.out.println("Qual dia você gostaria de reservar?");
                    int diaReserva = input.nextInt();
                input.nextLine(); 
                    boolean reservado = false;
                  for (int i = 0; i < contadorQuarto; i++) {
            if (quartos[i] != null && diaReserva == quartos[i].getDia()) {
                System.out.println("Data já cadastrada, favor cadastre outra.");
    reservado = true;
                break;
            }
        }

        if (!reservado) {
            Quarto quartoReserva = new Quarto();
            System.out.println("Qual número do quarto você gostaria de reservar?");
        quartoReserva.setNumeroQuarto(input.nextInt());
            quartoReserva.setDia(diaReserva);
        input.nextLine(); 

            System.out.println("Reserva realizada com sucesso!");
        }
        break;

    case 5:
            System.out.println("Quantos dias o cliente gostaria?");
            int dias = input.nextInt();
            input.nextLine(); 

            int total = 50 * dias; 
            System.out.println("Valor total: R$ " + total);
                                break;


        case 6:
        System.out.println("Verificar data de disponibilidade de um quarto em uma data específica:");
        System.out.println("Escolha um número do quarto:");
        int numeroDoQuarto = input.nextInt();
        input.nextLine(); 
        System.out.println("Escolha uma data específica:");
        int dataEspecifica = input.nextInt();
        input.nextLine(); 
    
        boolean quartoIndisponivel = true; 
        for (int i = 0; i < contadorQuarto; i++) {
            if (quartos[i] != null && dataEspecifica == quartos[i].getDia() && numeroDoQuarto == quartos[i].getNumeroQuarto()) {
                System.out.println("Quarto não disponível.");
                quartoIndisponivel = false;
                break;
            }
        }
        if (quartoIndisponivel) {
            System.out.println("Quarto disponível.");
        }
            



        break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        input.close();
    }
}
