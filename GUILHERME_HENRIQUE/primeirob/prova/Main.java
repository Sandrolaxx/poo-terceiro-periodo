package GUILHERME_HENRIQUE.primeirob.prova;

import java.util.Date;  

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(10, 5, 5);

        hotel.cadastrarQuarto(101);
        hotel.cadastrarQuarto(102);

        hotel.cadastrarCliente("Pedro", "448556236144");

        Date checkIn = new Date();  
        Date checkOut = new Date(checkIn.getTime() + (3 * 24 * 60 * 60 * 1000));  

        hotel.reservarQuarto(101, "448556236144", checkIn, checkOut);
        hotel.verificarDisponibilidade(102, checkIn);

        hotel.realizarCheckOut("448556236144");
    }
}
