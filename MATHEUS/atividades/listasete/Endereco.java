public class Endereco{
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private String pais;

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