
package CESAR_MAGAGNIN.primeirob.listas.listaseis;
// Pedido.java

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataPagamento;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private List<Item> itens;

    // Construtor
    public Pedido(int id, LocalDateTime dataCriacao, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    // Método para calcular o valor total do pedido
    public double getValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValor();
        }
        return total;
    }

    // Método para gerar descrição da venda
    public void gerarDescricaoVenda() {
        System.out.println("=== Descrição da Venda ===");
        System.out.println("Pedido ID: " + id);
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Vendedor: " + vendedor.getNome());
        System.out.println("Loja: " + loja.getNomeFantasia());
        System.out.println("Itens:");
        for (Item item : itens) {
            System.out.println("- " + item.getNome() + " (R$ " + item.getValor() + ")");
        }
        System.out.println("Valor Total: R$ " + getValorTotal());
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
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

    // Método para obter a data de vencimento da reserva (por exemplo, 48 horas após a criação)
    public LocalDateTime getDataVencimentoReserva() {
        return dataCriacao.plusHours(48);
    }
}
