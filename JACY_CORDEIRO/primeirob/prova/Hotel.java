package JACY_CORDEIRO.primeirob.prova;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Cliente> clientes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        clientes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, String cpf, String telefone, String email) {
        Cliente novoCliente = new Cliente(nome, cpf, telefone, email);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado: " + nome);
    }

    public void cadastrarQuarto(int numero, String tipo, double precoDiaria) {
        Quarto novoQuarto = new Quarto(numero, tipo, precoDiaria);
        quartos.add(novoQuarto);
        System.out.println("Quarto cadastrado: " + numero);
    }

    public Cliente encontrarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    public Quarto encontrarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null; // Quarto não encontrado
    }

    public void realizarReserva(Cliente cliente, Quarto quarto, int dias) {
        Reserva novaReserva = new Reserva(cliente, quarto, dias);
        reservas.add(novaReserva);
        System.out.println("Reserva realizada: " + cliente.getNome() + " - Quarto " + quarto.getNumero() + " por " + dias + " dias.");
    }

    public void listarClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void listarQuartos() {
        System.out.println("Lista de Quartos:");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public void listarReservas() {
        System.out.println("Lista de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
}
