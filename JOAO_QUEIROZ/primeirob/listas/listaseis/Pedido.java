package primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    public int id;
    public Date dataCriacao;
    public Date dataPagamento;
    public Date dataVencimentoReserva;
    public Cliente cliente;
    public Vendedor vendedor;
    public Loja loja;
    public ArrayList<Item> itens = new ArrayList<>();

    public void inicializarPedido() {
        id = 101;
        dataCriacao = new Date(); 
        dataPagamento = new Date(); 
        dataVencimentoReserva = new Date(dataCriacao.getTime() + (3 * 24 * 60 * 60 * 1000)); 
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.valor;
        }
        return total;
    }
    public void gerarDescricaoVenda() {
        System.out.println("Pedido criado em: " + dataCriacao + ", Valor Total: " + calcularValorTotal());
    }
}
