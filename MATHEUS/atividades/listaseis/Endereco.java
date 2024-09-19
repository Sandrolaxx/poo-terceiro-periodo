public class Endereco{
    public String cidade;
    public String bairro;
    public String rua;
    public String numero;
    public String complemento;
    public String pais;

    public Endereco(){

    }

    public Endereco(String cidade, String bairro, String rua){
      this.cidade = cidade;
      this.bairro = bairro;
      this.rua = rua;
    }
    public void apresentarLogradouro(){
      String Formated = String.format("Rua: %S, %S - %S\nBairro: %S\n%S - %S", rua, numero, complemento, bairro, cidade, pais);
      System.out.println(Formated);
    }    
}