package MARCUS_PENSO.primeirob.prova;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Cliente> clientes;
    private ArrayList<Quarto> quartos;
    private ArrayList<Reserva> reservas;

    public Hotel(int totalQuartos) {
        this.clientes = new ArrayList<>();
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();


        for (int i = 0; i < totalQuartos; i++) {
            quartos.add(new Quarto(i + 1)); 
        }
    }

    public void cadastrarCliente(String nome, String cpf) {
        clientes.add(new Cliente(nome, cpf));
    }

    public void listarQuartos() {
        for (Quarto quarto : quartos) {
            System.out.println("Quarto " + quarto.getNumero() + " - Disponível: " + quarto.isDisponivel());
        }
    }

    public void reservarQuarto(String cpf, int numeroQuarto, int dias) {
        Cliente cliente = encontrarCliente(cpf);
        if (cliente != null) {
            Quarto quarto = quartos.get(numeroQuarto - 1); 
            if (quarto.isDisponivel()) {
                quarto.setDisponivel(false);
                reservas.add(new Reserva(cliente, quarto, dias));
                System.out.println("Quarto " + numeroQuarto + " reservado com sucesso.");
            } else {
                System.out.println("Quarto não disponível.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void realizarCheckOut(String cpf) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getCpf().equals(cpf) && !reserva.isCheckOut()) {
                reserva.realizarCheckOut();
                System.out.println("Check-out realizado com sucesso. Total a pagar: " + reserva.calcularTotal(100.0));
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    private Cliente encontrarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(3); 

        
        hotel.cadastrarCliente("João", "12345678900");
        hotel.cadastrarCliente("Maria", "09876543211");

        
        System.out.println("Quartos disponíveis inicialmente:");
        hotel.listarQuartos();

        
        hotel.reservarQuarto("12345678900", 1, 5);
        System.out.println("\nApós reserva de João:");
        hotel.listarQuartos();

        
        hotel.realizarCheckOut("12345678900");
        System.out.println("\nApós check-out de João:");
        hotel.listarQuartos();

        
        scanner.close();
    }
}
