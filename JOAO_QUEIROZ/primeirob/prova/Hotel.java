package JOAO_QUEIROZ.primeirob.prova;

import java.time.LocalDate;

public class Hotel {
    private Cliente[] clientes = new Cliente[100];
    private Quarto[] quartos = new Quarto[100];
    private Reserva[] reservas = new Reserva[100];
    private int totalClientes = 0;
    private int totalQuartos = 0;
    private int totalReservas = 0;

    public void cadastrarCliente(String nome, String cpf) {
        clientes[totalClientes] = new Cliente(nome, cpf);
        totalClientes++;
    }

    public void cadastrarQuarto(int numero, double valorDiaria) {
        quartos[totalQuartos] = new Quarto(numero, valorDiaria);
        totalQuartos++;
    }

    public void listarQuartos() {
        for (int i = 0; i < totalQuartos; i++) {
            Quarto quarto = quartos[i];
            System.out.println("Quarto " + quarto.getNumero() + " - Disponível: " + quarto.isDisponivel() + " - Valor da diária: R$ " + quarto.getValorDiaria());
        }
    }

    public void reservarQuarto(String cpfCliente, int numeroQuarto, LocalDate dataEntrada, LocalDate dataSaida) {
        Cliente cliente = buscarClientePorCpf(cpfCliente);
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);

        if (cliente != null && quarto != null && quarto.isDisponivel()) {
            reservas[totalReservas] = new Reserva(cliente, quarto, dataEntrada, dataSaida);
            quarto.setDisponivel(false);
            totalReservas++;
            System.out.println("A reserva foi realizada com sucesso!");
        } else {
            System.out.println("Quarto não está disponível ou cliente não encontrado.");
        }
    }

    public void realizarCheckout(int numeroQuarto) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);

        if (quarto != null && !quarto.isDisponivel()) {
            for (int i = 0; i < totalReservas; i++) {
                if (reservas[i].getQuarto().getNumero() == numeroQuarto) {
                    System.out.println("Cliente: " + reservas[i].getCliente().getNome());
                    System.out.println("Total de diárias: " + reservas[i].calcularDiarias());
                    System.out.println("Total a pagar: R$ " + reservas[i].calcularTotalAPagar());
                    quarto.setDisponivel(true);
                    break;
                }
            }
        } else {
            System.out.println("Quarto não encontrado ou já disponível.");
        }
    }

    public void verificarDisponibilidade(int numeroQuarto, LocalDate data) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        if (quarto != null && quarto.isDisponivel()) {
            System.out.println("Quarto " + numeroQuarto + " está disponível na data " + data);
        } else {
            System.out.println("Quarto " + numeroQuarto + " não está disponível na data " + data);
        }
    }

    private Cliente buscarClientePorCpf(String cpf) {
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i].getCpf().equals(cpf)) {
                return clientes[i];
            }
        }
        return null;
    }

    private Quarto buscarQuartoPorNumero(int numero) {
        for (int i = 0; i < totalQuartos; i++) {
            if (quartos[i].getNumero() == numero) {
                return quartos[i];
            }
        }
        return null;
    }
}
