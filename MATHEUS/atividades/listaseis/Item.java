public class Item {
    public int id;
    public String nome;
    public String tipo;
    public float valor;

    public Item(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public void gerarDescricao(){
        System.out.println("ID:" + id + "Nome:" + nome + "Tipo:" + tipo + "Valor:" + valor);
    }
}
