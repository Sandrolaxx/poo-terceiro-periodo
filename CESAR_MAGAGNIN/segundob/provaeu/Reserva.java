package primeirob.provaeu;

import java.util.Date;
import java.util.List;

public class Reserva {
    private int id;
    private Date dataChekin;
    private Date dataChekout;
   // private Hospede hospede;
  //  private Hotel hotel;
    private List<Quartos> quartos;

    public Reserva(int id, Date dataChekin, Date dataChekout, Hospede hospede, Hotel hotel, List<Quartos> quartos) {
        this.id = id;
        this.dataChekin = dataChekin;
        this.dataChekout = dataChekout;
    //    this.hospede = hospede;
    //    this.hotel = hotel;
        this.quartos = quartos;
    }
    public double calcularValorTotal() {
        return quartos.stream().mapToDouble(Quartos::getValorDiaria).sum();
    }

    public void gerarDescricaoReserva(Double calcularValorTotal) {
        System.out.println("Data Chek-in: " + getDataChekin() + "\nData Check-out: " + getDataChekout() + "Valor total das diárias: R$ " + calcularValorTotal);
        //JOptionPane.showMessageDialog(null, "Data de criação: " + dataCriacao + "\nValor total: " + calcularValorTotal());
    }

    public Date getDataChekin() {
        return dataChekin;
    }

    public Date getDataChekout() {
        return dataChekout;
    }

    public int getId() {
        return id;
    }
}

