package MATHEUS.primeirob.atividades.listacinco;
public class Cliente{
    public String nome;
    public int idade;
    public Endereco endereco;

  public Cliente(String nome, int idade, Endereco endereco){
    this.nome = nome;
    this.idade = idade;
    this.endereco = endereco;
  }

  public void Apresentarse(){
    System.out.println("Nome: " + nome + "\nIdade: " + idade);
    this.endereco.apresentarse();
  }
}