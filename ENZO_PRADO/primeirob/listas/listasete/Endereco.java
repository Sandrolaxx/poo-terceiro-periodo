package ENZO_PRADO.primeirob.listas.listasete;

public class Endereco {

   private String estado;

   private String cidade;

   private String bairro;

   private int numero;

   private String complemento;

   private String rua;

    public Endereco(String estado, String cidade, String bairro, int numero, String complemento, String rua ) {
    
        
    }


    void apresentarLogradouro(){
        System.out.println("Estado: ".concat(estado)
                          .concat(", Cidade: ").concat(cidade)
                          .concat(", Bairro: ").concat(bairro)
                          .concat(", Rua: ").concat(rua)
                          .concat(", Numero: ") + numero +
                          ", Complemento: ".concat(complemento)
        );
    }
    
}
