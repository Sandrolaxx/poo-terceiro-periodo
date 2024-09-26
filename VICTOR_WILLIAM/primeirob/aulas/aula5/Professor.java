package VICTOR_WILLIAM.primeirob.aulas.aula5;

public class Professor {
    String name;
    String metter;
    Arma arma;
    boolean vivo = true;
    String qualification;

    public void apresentar(){
        String textoApresentacao = "Olá meu nome é "
                .concat(name)
                .concat(" e eu sou professor de ")
                .concat(metter)
                .concat(" e estou ")
                .concat(vivo ? "vivo" : "morto")
                .concat(" e minha qualificação é ")
                .concat("Correria");

        System.out.println(textoApresentacao);
    }
}
