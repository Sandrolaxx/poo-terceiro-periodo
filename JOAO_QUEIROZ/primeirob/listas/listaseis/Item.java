package listas.listaseis;

public class Item {
    public int id;
    public String nome;
    public String tipo;
    public double valor;

    public void inicializarItem() {
        id = 1;
        nome = "Produto A";
        tipo = "Eletrônico";
        valor = 150.0;
    }

    public void gerarDescricao() {
        System.out.println("ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: " + valor);
    }
}