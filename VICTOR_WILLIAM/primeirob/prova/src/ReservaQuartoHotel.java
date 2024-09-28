package VICTOR_WILLIAM.primeirob.prova.src;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReservaQuartoHotel {
    private DadosBasicosCliente dadosBasicosCliente;
    private QuartoHotel quartoHotel;
    private LocalDate dataReserva;
    private LocalDate dataCheckOut;

    public ReservaQuartoHotel(DadosBasicosCliente dadosBasicosCliente, QuartoHotel quartoHotel, LocalDate dataReserva, LocalDate dataCheckOut) {
        this.dadosBasicosCliente = dadosBasicosCliente;
        this.quartoHotel = quartoHotel;
        this.dataReserva = dataReserva;
        this.dataCheckOut = dataCheckOut;
    }

    public DadosBasicosCliente getDadosBasicosCliente() {
        return dadosBasicosCliente;
    }

    public QuartoHotel getQuartoHotel() {
        return quartoHotel;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public long getQuantidadeDiasReserva() {
        return ChronoUnit.DAYS.between(dataReserva, dataCheckOut);
    }

    public double getValorTotalReserva() {
        return getQuantidadeDiasReserva() * quartoHotel.getValorDiaria();
    }
}
