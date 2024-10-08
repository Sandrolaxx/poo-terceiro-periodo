package ENZO_PRADO.primeirob.listas.listaseis;

public class Endereco {

    String estado;

    String cidade;

    String bairro;

    int numero;

    String complemento;

    String rua;


    void apresentarLogradouro(){
        System.out.println("Estado: ".concat(estado)
                          .concat(", Cidade: ").concat(cidade)
                          .concat(", Bairro: ").concat(bairro)
                          .concat(", Rua: ").concat(rua)
                          .concat(", Numero: ") + numero +
                          ", Complemento: ".concat(complemento));
    }
    
}
