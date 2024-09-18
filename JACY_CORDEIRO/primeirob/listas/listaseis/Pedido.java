package JACY_CORDEIRO.primeirob.listas.listaseis;

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

    public Pedido(int id, Date dataCriacao, Cliente cliente, Vendedor vendedor, String loja, List<Item> itens) {
        if (dataCriacao == null) {
            throw new IllegalArgumentException("Data de criação não pode ser nula.");
        }
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("A lista de itens não pode ser nula ou vazia.");
        }

        this.id = id;
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
        this.dataVencimentoReserva = new Date(dataCriacao.getTime() + 3 * 24 * 60 * 60 * 1000); // Reserva vence em 3 dias
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data de Criação: " + dataCriacao + ", Valor Total: " + calcularValorTotal());
    }

    public Date getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dataCriacao=" + dataCriacao +
                ", dataPagamento=" + dataPagamento +
                ", dataVencimentoReserva=" + dataVencimentoReserva +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", loja='" + loja + '\'' +
                ", itens=" + itens +
                '}';
    }
}
