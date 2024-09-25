package DIONATAN_DARIZ.primeirob.aulas.aulaseis.Ninja;

public class Ninja {

    String nome;
    int idade;
    String aldeia;
    String cla;
    String equipamento;
    String nomeJutso;

    void apresentarse(){
        System.out.println("Sou ".concat(nome).concat(" do clã ").concat(cla));
    }
    
    void realizarJutso(){
        System.out.println(nome.concat(" realiza Jutso ").concat(nomeJutso));
    }
    
}
