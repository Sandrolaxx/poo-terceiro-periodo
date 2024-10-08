package ENZO_PRADO.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    public Date dataCriacao;
    public Date dataPagamento;
    public Date dataVencimentoReserva;
    public Cliente cliente;
    public Vendedor vendedor;
    public Loja loja;
    public List<Item> itens = new ArrayList<>();
    public double total;

    public void calcularValorTotal() {
        total = 0;
        for (Item item : itens) {
            total += item.valor;  
        }
        System.out.println("Valor total: " + total);
    }

    public void gerarDescricaoVenda() {
        System.out.println("Data de criação: " + dataCriacao);
        System.out.println("Vendedor: " + vendedor.nome);
        System.out.println("Cliente: " + cliente.nome);
        calcularValorTotal();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }
}
