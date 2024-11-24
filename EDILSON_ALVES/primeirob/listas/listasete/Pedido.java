package primeirob.listas.listasete;

import java.util.Date;

public class Pedido{
    public int id;
    public Date dataCriacao;
    public Date dataPagamento;
    public Date dataVencimentoReserva;
    public String cliente;
    public String vendedor;
    public String Loja;    
    public Item[] itens;   
    public double soma = 0.0;                                                                                                 
    
    
    public void imprime(){
        System.out.println("data de vencimento "+this.getDataVencimento());
        System.out.println("data da criação "+ this.getDataCriacao());
        System.out.println("data de pagamento "+ this.getDatapagamento());
        System.out.println("id "+this.getId());
        System.out.println("cliente "+ this.getCliente());
        System.out.println("vendedor "+this.getVendedor());
        System.out.println("nome da loja "+this.getLoja());
        System.out.println("valor do produto: "+calcularValorTotal(itens));
        System.out.println();
    }
    
    public Pedido(int id, Date dataCriacao, Date dataPagamento, Date dataVencimentoReserva, String cliente,String vendedor, String loja, Item[] itens) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.dataVencimentoReserva = dataVencimentoReserva;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.Loja = loja;
        this.itens = itens;
    }
    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getLoja() {
        return Loja;
    }
    public Date getDatapagamento(){
        return dataPagamento;
    }

    public Date getDataCriacao(){
        return dataCriacao;
    }

    public Date getDataVencimento(){
        return dataVencimentoReserva;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setLoja(String loja) {
        Loja = loja;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public double calcularValorTotal(Item[] item){

        for (Item itemm : itens) {
           soma += itemm.getValor();
        }

        return soma;
    }



}
