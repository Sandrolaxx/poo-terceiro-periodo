package EDILSON_ALVES.primeirob.listas.listaseis;

public class Gerente {
   public String nome;
   public int idade;
   public String Loja;
   public Endereco endereco;
   public int salarioBase;
   public int[] salarioRecebido;
   
   public Gerente(String nome, int idade, String loja, Endereco endereco, int salarioBase ,int[] salarioRecebido ) {
    this.nome = nome;
    this.idade = idade;
    this.Loja = loja;
    this.endereco = endereco;
    this.salarioBase = salarioBase;
    this.salarioRecebido = salarioRecebido;
}
   public void imprime(){
      endereco.apresentaEndereco();
      System.out.println("nome "+ this.getNome());
      System.out.println("idade "+ this.getIdade());
      System.out.println("loja "+ this.getLoja());
      System.out.println("salario base "+ this.getSalarioBase());

      for(int salarioo : salarioRecebido){
         System.out.println("salario recebido "+ salarioo);
      }
   }


   public int getIdade() {
      return idade;
   }
   public String getLoja() {
      return Loja;
   }
   public int getSalarioBase() {
      return salarioBase;
   }
   public int[] getSalarioRecebido() {
      return salarioRecebido;
   }
   public String getNome() {
      return nome;
   }

   public Endereco getEndereco(){
 
      return endereco;
   }

   public void apresentar(){

   }
   public int calcularMedia(int num1,int num2, int num3){
    int soma = (num1 + num2 + num3)/3;
        return soma;
   }
   
   public int calcularBonus(int salariosBase){
    return salariosBase*(35/100);
   }
}
