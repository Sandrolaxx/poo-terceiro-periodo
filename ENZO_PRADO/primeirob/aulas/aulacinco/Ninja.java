package ENZO_PRADO.primeirob.aulas.aulacinco;

public class Ninja {

    String nome;
    int idade;
    String aldeia;
    String cla;
    String equipamento;
    String nomeJutso;

    void aprsentarse(){
        System.out.println("Sou o ninja ".concat(nome).concat("Do clã: ".concat(cla)));
    }
    
    void realizrJutso(){
        System.out.println(nome.concat(" realizando jutso ").concat(nomeJutso));
    }
}
