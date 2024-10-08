package primeirob.listas.listacinco;

public class Vendedor {
    
    private String nome;

    private Integer idade;

    public Vendedor(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

}
