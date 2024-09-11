package ISAQUI_CAMARGO_BARAI.primeirob.aulas.aulacinco;

public class Professor {

    String nome;

    String materia;

    boolean genteBoa;

    String qualificacao;

    public void apresentarse() {
        
        String msg = "Olá meu nome é "
            .concat(nome)
            .concat(" e leciono")
            .concat(materia)
            .concat(" e ")
            .concat(genteBoa ? "sou" : "não sou")
            .concat("genteBoa");
        System.out.println(msg);
    }
}
