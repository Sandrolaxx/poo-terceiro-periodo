package primeirob.aulas.aulasete;

public abstract class Ninja {
    String nome;
    int idade;
    String aldeia;
    String clan;
    String equipamento;
    String nomeJutso;

    
    void apresentarse(){
        System.out.println("sou o ninja "+nome+"do cla"+clan);
    }
    void realizarJustso(){
        System.out.println(nome+" realizando o jutso "+ nomeJutso);
    }
}
