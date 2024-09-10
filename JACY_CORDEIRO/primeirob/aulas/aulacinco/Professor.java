package JACY_CORDEIRO.primeirob.aulas.aulacinco;

public class Professor {
    private String nome;
    private String cargo;
    private String descricao;

    // Construtor
    public Professor(String nome, String cargo, String descricao) {
        this.nome = nome;
        this.cargo = cargo;
        this.descricao = descricao;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método para exibir informações do professor
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Descrição: " + descricao);
    }
}
