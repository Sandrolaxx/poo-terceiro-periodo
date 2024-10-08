package GUILHERME_HENRIQUE.primeirob.prova;

import java.util.Date;

public class Hotel {
    private Quarto[] quartos;
    private Cliente[] clientes;
    private Reserva[] reservas;
    private int totalQuartos;
    private int totalClientes;
    private int totalReservas;

    public Hotel(int capacidadeQuartos, int capacidadeClientes, int capacidadeReservas) {
        quartos = new Quarto[capacidadeQuartos];
        clientes = new Cliente[capacidadeClientes];
        reservas = new Reserva[capacidadeReservas];
        totalQuartos = 0;
        totalClientes = 0;
        totalReservas = 0;
    }

    public void cadastrarQuarto(int numero) {
        if (totalQuartos < quartos.length) {
            quartos[totalQuartos++] = new Quarto(numero);
        } else {
            System.out.println("Capacidade máxima de quartos atingida.");
        }
    }

    public void cadastrarCliente(String nome, String cpf) {
        if (totalClientes < clientes.length) {
            clientes[totalClientes++] = new Cliente(nome, cpf);
        } else {
            System.out.println("Capacidade máxima de clientes atingida.");
        }
    }

    public void listarQuartos() {
        for (int i = 0; i < totalQuartos; i++) {
            System.out.println("Quarto " + quartos[i].getNumero() + " - Disponível: " + quartos[i].isDisponivel());
        }
    }

    public boolean verificarDisponibilidade(int numeroQuarto, Date dataCheckIn) {
        for (int i = 0; i < totalQuartos; i++) {
            if (quartos[i].getNumero() == numeroQuarto) {
                if (quartos[i].isDisponivel()) {
                    System.out.println("Quarto " + numeroQuarto + " está disponível.");
                    return true;
                } else {
                    System.out.println("Quarto " + numeroQuarto + " não está disponível.");
                    return false;
                }
            }
        }
        return false;
    }

    public void reservarQuarto(int numeroQuarto, String cpfCliente, Date dataCheckIn, Date dataCheckOut) {
        if (totalReservas < reservas.length) {
            for (int i = 0; i < totalQuartos; i++) {
                if (quartos[i].getNumero() == numeroQuarto && quartos[i].isDisponivel()) {
                    quartos[i].setDisponivel(false);
                    reservas[totalReservas++] = new Reserva(numeroQuarto, cpfCliente, dataCheckIn, dataCheckOut);
                    System.out.println("Reserva feita com sucesso para o quarto " + numeroQuarto);
                    return;
                }
            }
            System.out.println("Quarto nao disponível ou nao encontrado.");
        } else {
            System.out.println("Capacidade maxima de reservas atingida.");
        }
    }

    public void realizarCheckOut(String cpfCliente) {
        for (int i = 0; i < totalReservas; i++) {
            if (reservas[i].getCpfCliente().equals(cpfCliente)) {
                for (int j = 0; j < totalQuartos; j++) {
                    if (quartos[j].getNumero() == reservas[i].getNumeroQuarto()) {
                        quartos[j].setDisponivel(true);
                        System.out.println("Check out realizado para o cliente " + cpfCliente);
                        return;
                    }
                }
            }
        }
        System.out.println("Reserva não encontrada para o cliente " + cpfCliente);
    }
}
