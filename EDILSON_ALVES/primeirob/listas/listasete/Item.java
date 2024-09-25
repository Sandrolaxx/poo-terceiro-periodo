package EDILSON_ALVES.primeirob.listas.listasete;

public class Item {
     public int id;
     public String nome;
     public String tipo;
     public double valor;

     public Item(){

     }
    public Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    

    public void setId(int id) {
        this.id = id;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public void setValor(double valor) {
        this.valor = valor;
    }

    


    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public double getValor(){
        return this.valor;
    }

    public void gerarDescricao(){
        System.out.println("peofuto para escrever");

    }

}
