package ROBSON_DE_LIMA.primeirob.listas.listaSeis;

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
        System.out.printf("ID: %d, Nome: %s, Tipo: %s, Valor: R$ %.2f%n", id, nome, tipo, valor);
    }

    public double getValor() {
        return valor;
    }
}

