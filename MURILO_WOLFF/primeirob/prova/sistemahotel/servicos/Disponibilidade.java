package MURILO_WOLFF.primeirob.prova.sistemahotel.servicos;

import MURILO_WOLFF.primeirob.prova.sistemahotel.entidades.Quarto;
import java.util.Date;

public class Disponibilidade {
    public boolean verificarDisponibilidade(Quarto quarto, Date dataEntrada, Date dataSaida) {
        for (int i = 0; i < quarto.getTotalReservas(); i++) {
            Reserva reserva = quarto.getReservas()[i];
            if (dataEntrada.before(reserva.getDataSaida()) && dataSaida.after(reserva.getDataEntrada())) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarDisponibilidadeEmData(Quarto quarto, Date data) {
        for (int i = 0; i < quarto.getTotalReservas(); i++) {
            Reserva reserva = quarto.getReservas()[i];
            if (!data.before(reserva.getDataEntrada()) && !data.after(reserva.getDataSaida())) {
                return false;
            }
        }
        return true;
    }
}