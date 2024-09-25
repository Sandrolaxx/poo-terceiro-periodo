package JOAO_VITOR_SOUZA.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private Date dataVencimentoReserva;
    private Cliente cliente;
    private Vendedor vendedor;
    private String loja;
    private List<Item> itens;

    
    public Pedido(int id, Cliente cliente, Vendedor vendedor, String loja, Date dataPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.dataCriacao = new Date();
        this.dataVencimentoReserva = new Date(dataCriacao.getTime() + (3 * 24 * 60 * 60 * 1000)); // Vencimento em 3 dias
        this.dataPagamento = dataPagamento; // Atribui dataPagamento recebida ao atributo
        this.itens = new ArrayList<>();
    }

    
    public void adicionarItem(Item item) {
        if (item != null) {
            itens.add(item);
        } else {
            System.out.println("Item não pode ser nulo.");
        }
    }

    
    public double calcularValorTotal() {
        return itens.stream().mapToDouble(Item::getValor).sum();
    }

    
    public void gerarDescricaoVenda() {
        System.out.println("Data de Criação: " + dataCriacao + ", Valor Total: R$ " + String.format("%.2f", calcularValorTotal()));
    }

   
    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public String getLoja() {
        return loja;
    }

    public List<Item> getItens() {
        return itens;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }
}

