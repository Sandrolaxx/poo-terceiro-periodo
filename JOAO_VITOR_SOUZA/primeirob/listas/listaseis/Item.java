package JOAO_VITOR_SOUZA.primeirob.listas.listaseis;

public class Item {
    private int id;
    private String nome;
    private String tipo;
    private double valor;

    
    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public void gerarDescricao() {
        System.out.println("ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: R$" + String.format("%.2f", valor));
    }

    public double getValor() {
        return valor;
    }
}

