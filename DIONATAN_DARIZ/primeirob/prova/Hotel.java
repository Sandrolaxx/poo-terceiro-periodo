package DIONATAN_DARIZ.primeirob.prova;

import java.util.Date;

public class Hotel {
    private Cliente[] clientes = new Cliente[100];
    private Quarto[] quartos = new Quarto[100];
    private Reserva[] reservas = new Reserva[100];
    private int numClientes = 0;
    private int numQuartos = 0;
    private int numReservas = 0;

    public void cadastrarCliente(String nome, String cpf, String telefone) {
        if (numClientes < 100) {
            clientes[numClientes] = new Cliente(nome, cpf, telefone);
            numClientes++;
        }
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void cadastrarQuarto(int numero, double precoDiaria) {
        if (numQuartos < 100) {
            quartos[numQuartos] = new Quarto(numero, precoDiaria);
            numQuartos++;
        }
    }

    public void listarQuartos() {
        for (int i = 0; i < numQuartos; i++) {
            System.out.println("Quarto " + quartos[i].getNumero() +
                               " - R$" + quartos[i].getPrecoDiaria() + " por diária" + 
                               " - Disponível: " + (quartos[i].isDisponivel() ? "Sim" : "Não"));
        }
    }

    public boolean verificarDisponibilidade(int numeroQuarto, Date dataEntrada, Date dataSaida) {
        for (int i = 0; i < numReservas; i++) {
            if (reservas[i].getQuarto().getNumero() == numeroQuarto) {
                if (reservas[i].conflitoDeDatas(dataEntrada, dataSaida)) {
                    return false; // O quarto está reservado no período desejado
                }
            }
        }
        return true; // O quarto está disponível
    }

    public void reservarQuarto(int numeroQuarto, Cliente cliente, Date dataEntrada, Date dataSaida) {
        for (int i = 0; i < numQuartos; i++) {
            if (quartos[i].getNumero() == numeroQuarto && quartos[i].isDisponivel()) {
                if (verificarDisponibilidade(numeroQuarto, dataEntrada, dataSaida)) {
                    reservas[numReservas] = new Reserva(cliente, quartos[i], dataEntrada, dataSaida);
                    quartos[i].setDisponivel(false);
                    numReservas++;
                    System.out.println("Reserva realizada com sucesso!");
                } else {
                    System.out.println("O quarto não está disponível no período informado.");
                }
                break;
            }
        }
    }

    public void realizarCheckOut(int numeroQuarto) {
        for (int i = 0; i < numReservas; i++) {
            if (reservas[i].getQuarto().getNumero() == numeroQuarto) {
                double valorTotal = reservas[i].calcularValorTotal();
                System.out.println("Valor total a pagar: R$ " + valorTotal);
                reservas[i].getQuarto().setDisponivel(true);
                break;
            }
        }
    }
}
