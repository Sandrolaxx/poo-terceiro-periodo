package EDILSON_ALVES.primeirob.listas.listaseis;

public class Item {
     public int id;
     public String nome;
     public String tipo;
     public double valor;

    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }

    public void gerarDescricao(){


    }

}
