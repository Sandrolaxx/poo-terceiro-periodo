
package CESAR_MAGAGNIN.primeirob.listas.listaseis;
// Cliente.java

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int idade;
    private Endereco endereco;

    // Construtor
    public Cliente(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Método para apresentar-se
    public void apresentarSe() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        if (endereco != null) {
            endereco.apresentarLogradouro();
        }
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "Cliente{" +
               "nome='" + nome + '\'' +
               ", idade=" + idade +
               ", endereco=" + endereco +
               '}';
    }
}
