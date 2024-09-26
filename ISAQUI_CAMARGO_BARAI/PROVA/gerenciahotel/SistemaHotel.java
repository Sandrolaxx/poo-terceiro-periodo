package ISAQUI_CAMARGO_BARAI.PROVA.gerenciahotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente{
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
}

class Quarto{
    private int numero;
    private boolean disponivel;
    private double valorDiaria;

    public Quarto(int numero, double valorDiaria) {
        this.numero = numero;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public int getNumero(){
        return numero;

    }

    public boolean isDisponivel(){
        return disponivel;

    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}

class Reserva{
    private Cliente cliente;
    private Quarto quarto;
    private int diasReservados;

    public Reserva(Cliente cliente, Quarto quarto, int diasReservados){
        this.cliente = cliente;
        this.quarto = quarto;
        this.diasReservados = diasReservados;
        quarto.setDisponivel(false );
    }

    public Quarto getQuarto(){
        return quarto;

    }

    public Cliente getCliente(){
        return cliente;

    }

    public int getdiasReservados(){
        return diasReservados;

    }

    public double calcularTotal(){
        return diasReservados * quarto.getValorDiaria();

    }

    public void realizarCheckOut(){

        quarto.setDisponivel(true);
        System.out.println("Checkout realizado para " + cliente.getNome() + "Total a pagar: R$ " +calcularTotal());

    }
}


public class SistemaHotel {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int opcao;
        
        
    }
    
}
