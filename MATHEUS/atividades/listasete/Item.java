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

    public static Item buscarPornome(Item[] itens, String busca){
        for (Item item : itens) {
            if(item != null){
                if (item.getNome().contains(busca)) {
                    return item;
                }
            }
        }
        System.out.println("este item não foi encontrado, por favor refaça a sua busca");
        return null;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
