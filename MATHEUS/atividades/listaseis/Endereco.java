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
      String Formated = String.format("Rua: %s, %s - [%s]\n  Bairro [%S]\n %s - [%s] [%s \n%s", rua, numero, complemento, bairro, cidade, pais);
      System.out.println(Formated);
    }    
}