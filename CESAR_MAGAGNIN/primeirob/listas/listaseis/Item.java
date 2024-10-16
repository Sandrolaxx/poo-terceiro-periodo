
package primeirob.listas.listaseis;
import java.io.Serializable;

public class Item implements Serializable {
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

    // Método para gerar a descrição do item
    public void gerarDescricao() {
        System.out.println("Item ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.printf("Valor: R$ %.2f\n", valor);
    }

    // Getter para valor
    public double getValor() {
        return valor;
    }

    // Getters e Setters adicionais (se necessário)
    public String getNome() {
        return nome;
    }
}
