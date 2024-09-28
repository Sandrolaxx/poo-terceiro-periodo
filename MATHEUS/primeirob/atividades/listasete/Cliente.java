package MATHEUS.primeirob.atividades.listasete;
public class Cliente{
    private String nome;
    private int idade;
    private Endereco endereco;

  public Cliente(String nome, int idade, Endereco endereco){
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
  }

  public void Apresentarse(){
    System.out.println("Nome: " + nome + "\nIdade: " + idade);
    this.endereco.apresentarLogradouro();
  }
}