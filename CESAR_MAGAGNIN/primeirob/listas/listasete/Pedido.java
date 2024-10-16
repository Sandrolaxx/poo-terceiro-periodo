
package primeirob.listas.listasete;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private LocalDateTime dataHora;
    private Cliente cliente;
    private Vendedor vendedor;
    private Loja loja;
    private List<Item> itens;
    private LocalDateTime dataPagamento;
    private LocalDateTime dataVencimentoReserva;

    public Pedido(int id, Cliente cliente, Vendedor vendedor, List<Item> itens) {
        this.id = id;
        this.dataHora = LocalDateTime.now();
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }

    public Pedido(int id, LocalDateTime dataHora, Cliente cliente, Vendedor vendedor, Loja loja, List<Item> itens) {
        this.id = id;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
        this.itens = itens;
    }

    // Getter e Setter para data de pagamento
    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    // Método para calcular o valor total do pedido
    public double getValorTotal() {
        double total = 0;
        for (Item item : this.itens) {
            total += item.getValor();
        }
        return total;
    }

    // Getter e Setter para data de vencimento da reserva
    public LocalDateTime getDataVencimentoReserva() {
        return dataVencimentoReserva;
    }

    public void setDataVencimentoReserva(LocalDateTime dataVencimentoReserva) {
        this.dataVencimentoReserva = dataVencimentoReserva;
    }

    // Getters e Setters adicionais
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", dataHora=" + dataHora + ", cliente=" + cliente.getNome() + ", vendedor=" + vendedor.getNome() + ", itens=" + itens + "]";
    }
}
