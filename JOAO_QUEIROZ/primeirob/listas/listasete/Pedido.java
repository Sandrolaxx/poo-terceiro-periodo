package primeirob.listas.listasete;

import java.util.ArrayList;
import java.util.Date;
import primeirob.listas.listasete.Item;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private String cliente;
    private String vendedor;
    private String loja;
    private ArrayList<Item> itens;

    public Pedido(int id, Date dataCriacao, Date dataVencimentoReserva, String cliente, String vendedor, String loja, ArrayList<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Pedido criado em: " + dataCriacao + ", Valor total: " + calcularValorTotal());
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

    public Date getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(Date dataPagamento) { this.dataPagamento = dataPagamento; }

    public Date getDataVencimentoReserva() { return dataVencimentoReserva; }
    public void setDataVencimentoReserva(Date dataVencimentoReserva) { this.dataVencimentoReserva = dataVencimentoReserva; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getVendedor() { return vendedor; }
    public void setVendedor(String vendedor) { this.vendedor = vendedor; }

    public String getLoja() { return loja; }
    public void setLoja(String loja) { this.loja = loja; }

    public ArrayList<Item> getItens() { return itens; }
    public void setItens(ArrayList<Item> itens) { this.itens = itens; }
}