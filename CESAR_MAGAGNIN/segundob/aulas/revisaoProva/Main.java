package CESAR_MAGAGNIN.segundob.aulas.revisaoProva;
import java.util.Scanner;
public class Main {
    static Scanner input = new Scanner(System.in);
public static void main(String[]args) {
    
 Cliente[] clientes = new Cliente[100];
 Quarto[] quartos = new Quarto[100];
 Reserva[] reservas = new Reserva[100];
 int idCliente = 1;
 int idQuarto = 1;
 int idReserva = 1;
}
public void cadastroCliente(Cliente[] clientes, int idCliente) {
    Cliente cliente = new Cliente();
    cliente.setId(idCliente);
    System.out.println("Nome: ");
    cliente.setNome(input.nextLine());
}
public void cadastroQuarto(Quarto[] quartos, int idQuarto) {
    Quarto quarto = new Quarto();
    quarto.setId(idQuarto);
    System.out.println("Descrição do quarto");
    quarto.setDescricao(input.nextLine());
}
}