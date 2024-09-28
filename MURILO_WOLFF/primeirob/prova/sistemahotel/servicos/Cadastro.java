package MURILO_WOLFF.primeirob.prova.sistemahotel.servicos;

import MURILO_WOLFF.primeirob.prova.sistemahotel.entidades.Cliente;
import MURILO_WOLFF.primeirob.prova.sistemahotel.entidades.Quarto;

public class Cadastro {
    private Quarto[] quartos;
    private Cliente[] clientes;
    private int totalQuartos;
    private int totalClientes;

    public Cadastro() {
        this.quartos = new Quarto[100];
        this.clientes = new Cliente[100];
        this.totalQuartos = 0;
        this.totalClientes = 0;
    }

    public void cadastrarCliente(String nome, String cpf, String telefone, String email) {
        if (totalClientes < 100) {
            clientes[totalClientes++] = new Cliente(nome, cpf, telefone, email);
        } else {
            System.out.println("Capacidade máxima de clientes atingida.");
        }
    }

    public void cadastrarQuarto(int numero, int andar, String tipo, double valorDiaria) {
        if (totalQuartos < 100) {
            quartos[totalQuartos++] = new Quarto(numero, andar, tipo, valorDiaria);
        } else {
            System.out.println("Capacidade máxima de quartos atingida.");
        }
    }

    public void listarQuartos() {
        for (int i = 0; i < totalQuartos; i++) {
            quartos[i].apresentarQuarto();
        }
    }

    public Cliente getCliente(int i) {
        return clientes[i];
    }

    public Quarto getQuarto(int i) {
        return quartos[i];
    }
}