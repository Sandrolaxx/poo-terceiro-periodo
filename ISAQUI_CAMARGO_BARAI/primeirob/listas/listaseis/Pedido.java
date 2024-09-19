package ISAQUI_CAMARGO_BARAI.primeirob.listas.listaseis;

import java.util.ArrayList;
import java.util.Date;

class Pedido {
    int id;
    Date dataCriacao;
    Date dataPagamento;
    Date dataVencimentoReserva;
    String cliente;
    String vendedor;
    String loja;
    ArrayList<Item> itens = new ArrayList<>();

    Pedido(int id, Date dataCriacao, Date dataVencimentoReserva, String cliente, String vendedor, String loja) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.loja = loja;
    }

    double calcularValorTotal() {
        double total = 0;
        for(Item item : itens) {
            total += item.valor;
        }
        return total;
    }

    // Método para gerar a descrição da venda
    void gerarDescricaoVenda() {
        System.out.println("Pedido criado em: " + dataCriacao + ", Valor total: " + calcularValorTotal());
    }
}
