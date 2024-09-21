package ENZO_PRADO.primeirob.listas.listaseis;

public class Item {

    int id;

    String nome;

    String tipo;

    double valor;


    void gerarDescricao(){

        System.out.println("ID: " + id);
        System.out.println("Nome: ".concat(nome));
        System.out.println("Tipo: ".concat(tipo));
        System.out.println("Valor: " + valor);
    }
    
    
}
