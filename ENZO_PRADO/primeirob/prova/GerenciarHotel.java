package ENZO_PRADO.primeirob.prova;

import java.util.Date;

public class GerenciarHotel {

    private Cliente[] clientes;
    private Quarto[] quartos;
    private Reserva[] reservas;

    private int totalQuartos = 0;
    private int totalClientes = 0;
    private int totalReserva = 0;


    public GerenciarHotel(int capcidadeClientes, int capacidadeQuartos, int capacidadeReservas){
        clientes = new Cliente[capcidadeClientes];
        quartos = new Quarto[capacidadeQuartos];
        reservas = new Reserva[capacidadeReservas];
        }
    

    public void cadastrarCliente(String nome, int idade, String cpf, int sexo){
        if(totalClientes < clientes.length){
            clientes[totalClientes++] = new Cliente(nome, idade, cpf, sexo);
            System.out.println("Cliente cadastrado com sucesso! \nNome: " + nome 
            + "\nCPF: " + cpf);
        }else{
            System.out.println("Limite maximo de cientes atingidos");
        }
    }

    public void cadastrarQuarto(int numero, int tipoQuarto, int qtdCama, double valor){
        if(totalQuartos < quartos.length){
            quartos[totalQuartos++] = new Quarto(numero, tipoQuarto, qtdCama, valor);
            System.out.println("Quarto adicionado com sucesso! \nNumero: " + numero
            + "\nTipo: " + tipoQuarto);
        }else{
            System.out.println("Limite maximo de quartos atingidos");
        }
    }

    public void fazerReserva(Cliente clientes, Quarto quartos, Date  dataEntrada, Date dataSaida){
        if(quartos.getDisponivel()){
            Reserva reserva = new Reserva(clientes, quartos, dataEntrada, dataSaida);
            reservas[totalReserva++] = reserva;
            quartos.setDisponivel(false);
            System.out.println("Quarto reservado para " + clientes.getNome() + "com CPF: " + clientes.getCpf() 
            + " do dia " + dataEntrada + " ao dia " + dataSaida);
        }
    }

    /*public void fazerCheckout(Quarto quarto){
        for(int i = 0; i < totalReserva; i++){
            if (reservas[i].getQuarto().equals(quarto)) {
                reservas[i].checkout(reservas[i].getDataSaida());
                return;
                
            }
        }
        System.out.println("Quarto não encontrado");

    }*/

    public boolean fazerCheckout(Quarto quarto, int numero){
        for(int i = 0; i < totalReserva; i++){
            if (reservas[i].getQuarto().getNumero() == numero) {
                reservas[i].checkout(reservas[i].getDataSaida(), reservas[i].getDataEntrada());
                return true;
            }
        }
        System.out.println("Quarto não encontrado");
        return false;
    }
    

    public void verificarDisponibilidade(int numero, Date data){
    boolean quartoEncontrado = false;
    for(int i = 0; i < totalQuartos; i++){
        if (quartos[i].getNumero() == numero) {

            quartoEncontrado = true;
            if(quartos[i].getDisponivel()){
                System.out.println("Quarto disponível para empréstimo na data" + data);
            } else {
                System.out.println("Quarto indisponível para empréstimo na data" + data);
            }
            return;  
            }
            
        }
        if(!quartoEncontrado){
            System.out.println("Quarto não encontrado");
        }
    }

    public void exibirQuartos(){
        if(totalQuartos == 0){
            System.out.println("Nenhum quarto disponivel");
        }else{
            System.out.println("Lista de quartos cadastrados: ");
            for(int i = 0; i < totalQuartos; i++){
                System.out.println("Numero: " + quartos[i].getNumero() 
                + "\nTipo [1]comum / [2] suite: " + quartos[i].getTipodeDoQuarto() 
                + "\nQuantidade de camas: " + quartos[i].getQtdCama() 
                + "\nValor: R$" + quartos[i].getValor());
            System.out.println("---------------------------------------");
            }
        }
    }
    public Cliente buscarClienteCPF(String cpf) {
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i].getCpf().equals(cpf)) {
                return clientes[i];
            }
        }
        return null;
    }

    public Quarto buscarQuartoNumero(int numero) {
        for (int i = 0; i < totalQuartos; i++) {
            if (quartos[i].getNumero() == numero) {
                return quartos[i];
            }
        }
        return null;
    }


    }




