public class Endereco{
    public String cidade;
    public String bairro;
    public String rua;

    public Endereco(String cidade, String bairro, String rua){
      this.cidade = cidade;
      this.bairro = bairro;
      this.rua = rua;
    }
    public void apresentarse(){
      System.out.println("Cidade: " + cidade + "\nBairro: " + bairro + "\nRua: " + rua);
    }
}