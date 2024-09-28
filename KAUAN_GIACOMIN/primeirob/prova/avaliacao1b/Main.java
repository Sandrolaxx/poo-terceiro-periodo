package KAUAN_GIACOMIN.primeirob.prova.avaliacao1b;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Cliente {
    private String nome;
    private String documento;

    public Cliente(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " | Documento: " + documento;
    }
}

class Quarto {
    private int numero;
    private boolean disponivel;
    private double precoDiaria;

    public Quarto(int numero, double precoDiaria) {
        this.numero = numero;
        this.precoDiaria = precoDiaria;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + " | Preço diária: " + precoDiaria + " | Disponível: " + disponivel;
    }
}

class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;

    public Reserva(Cliente cliente, Quarto quarto, Date dataEntrada, Date dataSaida) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Quarto getQuarto() {
        return quarto;
    }
    public Date getDataEntrada() {
        return dataEntrada;
    }
    public Date getDataSaida() {
        return dataSaida;
    }
    public int calcularDiarias() {
        long diff = dataSaida.getTime() - dataEntrada.getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }
    public double calcularTotal() {
        return calcularDiarias() * quarto.getPrecoDiaria();
    }
    @Override
    public String toString() {
        return "Reserva do cliente " + cliente.getNome() + " no quarto " + quarto.getNumero();
    }
}

class Hotel {
    private Cliente[] clientes = new Cliente[100];
    private Quarto[] quartos = new Quarto[100];
    private Reserva[] reservas = new Reserva[100];
    private int qtdClientes = 0;
    private int qtdQuartos = 0;
    private int qtdReservas = 0;

    public void cadastrarCliente(String nome, String documento) {
        clientes[qtdClientes++] = new Cliente(nome, documento);
    }

    public void cadastrarQuarto(int numero, double precoDiaria) {
        quartos[qtdQuartos++] = new Quarto(numero, precoDiaria);
    }

    public boolean verificarDisponibilidade(int numeroQuarto, Date dataEntrada, Date dataSaida) {
        for (int i = 0; i < qtdReservas; i++) {
            Reserva reserva = reservas[i];
            if (reserva.getQuarto().getNumero() == numeroQuarto &&
                    !(dataSaida.before(reserva.getDataEntrada()) || dataEntrada.after(reserva.getDataSaida()))) {
                return false;
            }
        }
        return true;
    }

    public void reservarQuarto(String documento, int numeroQuarto, Date dataEntrada, Date dataSaida) {
        Cliente cliente = buscarCliente(documento);
        Quarto quarto = buscarQuarto(numeroQuarto);

        if (cliente != null && quarto != null && verificarDisponibilidade(numeroQuarto, dataEntrada, dataSaida)) {
            reservas[qtdReservas++] = new Reserva(cliente, quarto, dataEntrada, dataSaida);
            quarto.setDisponivel(false);
            System.out.println("Reserva realizada com sucesso.");
        } else {
            System.out.println("Não foi possível realizar a reserva.");
        }
    }

    public void realizarCheckOut(int numeroQuarto) {
        for (int i = 0; i < qtdReservas; i++) {
            if (reservas[i].getQuarto().getNumero() == numeroQuarto) {
                double total = reservas[i].calcularTotal();
                System.out.println("Check-out realizado. Total a pagar: R$ " + total);
                reservas[i].getQuarto().setDisponivel(true);
                reservas[i] = null; // Remove a reserva
                return;
            }
        }
        System.out.println("Quarto não encontrado ou não ocupado.");
    }

    private Cliente buscarCliente(String documento) {
        for (int i = 0; i < qtdClientes; i++) {
            if (clientes[i].getDocumento().equals(documento)) {
                return clientes[i];
            }
        }
        return null;
    }

    private Quarto buscarQuarto(int numero) {
        for (int i = 0; i < qtdQuartos; i++) {
            if (quartos[i].getNumero() == numero) {
                return quartos[i];
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) throws ParseException {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        hotel.cadastrarCliente("João Silva", "123456789");
        hotel.cadastrarQuarto(101, 200.0);

        System.out.println("Digite a data de entrada (dd/MM/yyyy): ");
        Date dataEntrada = sdf.parse(scanner.nextLine());
        System.out.println("Digite a data de saída (dd/MM/yyyy): ");
        Date dataSaida = sdf.parse(scanner.nextLine());

        hotel.reservarQuarto("123456789", 101, dataEntrada, dataSaida);

        hotel.realizarCheckOut(101);
    }
}