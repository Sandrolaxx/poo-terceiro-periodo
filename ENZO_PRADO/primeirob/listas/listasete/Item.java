package ENZO_PRADO.primeirob.listas.listasete;

public class Item {

   private int id;

   private String nome;

   private String tipo;

   private double valor;

    public Item(int id, String nome, String tipo, double valor){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;

    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getTipo(){
        return tipo;
    }

    public double getvalor(){
        return valor;
    }

    
    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setvalor(double valor){
        this.valor = valor;
    }
    

    void gerarDescricao(){

        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Tipo: ".concat(getTipo()));
        System.out.println("Valor: " + getvalor());
    }
    
    
}
