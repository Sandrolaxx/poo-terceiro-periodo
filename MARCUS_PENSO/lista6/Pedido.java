package MARCUS_PENSO.lista6;

import java.util.ArrayList;
import java.util.Date;
public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Loja loja;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<Item> itens;
    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Loja loja, Cliente cliente, Vendedor vendedor, ArrayList<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.loja = loja;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public void setDataVencimentoReserva(Date dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }
    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }
    public void gerarDescricaoVenda() {
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Valor Total: " + calcularValorTotal());
    }
}