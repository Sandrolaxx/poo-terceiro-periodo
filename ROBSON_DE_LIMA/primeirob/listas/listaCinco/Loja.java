package ROBSON_DE_LIMA.primeirob.listas.listaCinco;

import java.util.List;

public class Loja {

    String nomeFantasia = "Myy Plant";
    String razaoSocial;
    String cnpj;
    String cidade;
    String bairro;
    String rua;
    List <Vendedor> vendedores;
    List <Cliente> clientes;


    void apresentarse(){
        System.out.println("olá nós Somos a "  +  nomeFantasia  +   " Nosso Cnpj é  "   +  cnpj  +  " Estamos Localizados no " + cidade  + "  no Bairro  " + bairro  +  "  e na Rua " + rua );
    
}
}


