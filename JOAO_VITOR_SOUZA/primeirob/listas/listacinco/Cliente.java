package JOAO_VITOR_SOUZA.primeirob.listas.listacinco;

public class Cliente {
    
    String nome;
    String idade;
    String cidade;
    String bairro;
    String rua;

    public void apresentarse() {
        String msg = nome 
                .concat(", ")
                .concat(idade)
                .concat(" anos, ")
                .concat("mora em ")
                .concat(cidade)
                .concat(", bairro ")
                .concat(bairro)
                .concat(", rua ")
                .concat(rua);

        System.out.println(msg);
    }
}
