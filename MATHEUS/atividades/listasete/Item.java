public class Item {
    private int id;
    private String nome;
    private String tipo;
    private float valor;

    

    public Item(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
        this.id = Testaobjeto.itemid;
        Testaobjeto.itemid++;
    }

    public void gerarDescricao(){
        System.out.println("ID: " + id +  " Nome: " + nome + " Tipo: " + tipo + " Valor: " + valor);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
