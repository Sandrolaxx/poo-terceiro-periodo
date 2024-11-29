package primeirob.listas.listasete;

public class Gerente {
   public String nome;
   public int idade;
   public String Loja;
   public Endereco endereco;
   public double salarioBase;
   public double[] salarioRecebido;
   

   public Gerente(){

   }
   public Gerente(String nome, int idade, String loja, Endereco endereco, int salarioBase ,double[] salarioRecebido ) {
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

      for(double salarioo : salarioRecebido){
         System.out.println("salario recebido "+ salarioo);
      }
   }
   


   public void setNome(String nome) {
      this.nome = nome;
   }
   public void setIdade(int idade) {
      this.idade = idade;
   }
   public void setLoja(String loja) {
      Loja = loja;
   }
   public void setEndereco(Endereco endereco) {
      this.endereco = endereco;
   }
   public void setSalarioBase(double salarioBase) {
      this.salarioBase = salarioBase;
   }
   public void setSalarioRecebido(double[] salarioRecebido) {
      this.salarioRecebido = salarioRecebido;
   }
   public int getIdade() {
      return idade;
   }
   public String getLoja() {
      return Loja;
   }
   public double getSalarioBase() {
      return salarioBase;
   }
   public double[] getSalarioRecebido() {
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
