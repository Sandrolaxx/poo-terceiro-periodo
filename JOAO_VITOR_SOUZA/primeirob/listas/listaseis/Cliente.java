package JOAO_VITOR_SOUZA.primeirob.listas.listaseis;

public class Cliente {
    
    String nome;
    Integer idade;
    String cidade;
    String bairro;
    String rua;

    public Cliente(String nome, int idade, String cidade, String bairro, String rua) {
        this.nome= nome;
        this.idade= idade;
        this.cidade= cidade;
        this.bairro= bairro;
        this.rua = rua;
        
    }

    public void apresentarse() {
        String msg = nome 
                .concat(", ")
                .concat(idade.toString())
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
