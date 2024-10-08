package MURILO_WOLFF.primeirob.prova.sistemahotel;

import java.util.Date;

import MURILO_WOLFF.primeirob.prova.sistemahotel.servicos.Cadastro;
import MURILO_WOLFF.primeirob.prova.sistemahotel.servicos.Checkout;
import MURILO_WOLFF.primeirob.prova.sistemahotel.servicos.Disponibilidade;
import MURILO_WOLFF.primeirob.prova.sistemahotel.servicos.Reserva;

public class Sistema {
    public static void main(String[] args) {
        System.out.println("Sistema Hotel");

        Cadastro cadastro = new Cadastro();
        Disponibilidade disponibilidade = new Disponibilidade();
        Checkout checkout = new Checkout();

        Date dataEntrada1 = new Date(2024, 10, 10);
        Date dataSaida1 = new Date(2024, 10, 15);

        Date dataEntrada2 = new Date(2024, 10, 21);
        Date dataSaida2 = new Date(2024, 10, 25);

        cadastro.cadastrarCliente("Murilo Wolff", "021.080.211-01", "99968-1939", "murilo.klug@gmail.com");
        cadastro.cadastrarCliente("João da Silva", "021.080.211-02", "99968-1939", "Joao.silva@gmail.com");
        cadastro.cadastrarQuarto(101, 1, "Simples", 100.0);
        cadastro.cadastrarQuarto(102, 1, "Luxo", 500.0);

        System.out.println("Lista de Quartos:");
        cadastro.listarQuartos();

        Reserva reserva = new Reserva(cadastro.getCliente(0), cadastro.getQuarto(0), dataEntrada1, dataSaida1, 1);
        reserva.realizarReserva(disponibilidade);

        Reserva reserva2 = new Reserva(cadastro.getCliente(1), cadastro.getQuarto(1), dataEntrada2, dataSaida2, 2);
        reserva2.realizarReserva(disponibilidade);

        Date dataExemplo = new Date(2024, 10, 11);

        boolean disponivel = disponibilidade.verificarDisponibilidadeEmData(cadastro.getQuarto(0), dataExemplo);
        System.out.println("Disponibilidade na data especificada: " + (disponivel ? "Sim" : "Não"));

        checkout.realizarCheckout(reserva);
        checkout.realizarCheckout(reserva2);
    }
}