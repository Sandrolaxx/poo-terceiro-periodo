package ISAQUI_CAMARGO_BARAI.primeirob.listas.listaseis;

class Item {
    int id;
    String nome;
    String tipo;
    double valor;

    Item(int id, String nome, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    void gerarDescricao() {
        System.out.println("ID: " + id + ", Nome: " + nome + ", Tipo: " + tipo + ", Valor: " + valor);
    }
}