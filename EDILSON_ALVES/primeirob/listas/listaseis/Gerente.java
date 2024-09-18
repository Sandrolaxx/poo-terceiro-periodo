package EDILSON_ALVES.primeirob.listas.listaseis;

public class Gerente {
   public int nome;
   public int idade;
   public String Loja;
   public String cidade;
   public String bairro;
   public String rua;
   public int salarioBase;
   public int[] salarioRecebido;

   public Gerente(int nome, int idade, String loja, String cidade, String bairro, String rua, int salarioBase,int[] salarioRecebido) {
    this.nome = nome;
    this.idade = idade;
    this.Loja = loja;
    this.cidade = cidade;
    this.bairro = bairro;
    this.rua = rua;
    this.salarioBase = salarioBase;
    this.salarioRecebido = salarioRecebido;
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
