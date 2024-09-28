package MURILO_WOLFF.primeirob.prova.sistemahotel.servicos;

public class Checkout {
    public void realizarCheckout(Reserva reserva) {
        reserva.getQuarto().setDisponivel(true);
        System.out.println("Checkout realizado com sucesso para o cliente " + reserva.getCliente().getNome());
        reserva.valorTotal();
    }
}