package ENZO_PRADO.primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private List<Item> itens = new ArrayList<>();
    private double total;

    public Pedido(Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens, double total  ){
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
        this.total = total;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Loja getLoja() {
        return loja;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }


    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setDataVencimentoReserva(Date dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void calcularValorTotal() {
        total = 0;
        for (Item item : itens) {
            total += item.getvalor();  
        }
        System.out.println("Valor total: " + total);
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data de criação: " + getDataCriacao());
        System.out.println("Vendedor: " + vendedor.getNome());
        System.out.println("Cliente: " + cliente.getNome());
        calcularValorTotal();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }
}
