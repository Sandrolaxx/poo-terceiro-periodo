package primeirob.aulas.aulaseis;

public class Ninja {
    String nome;

    String aldeia;

    String cla;

    String equipamento;

    String nomeJutso;

    int idade;

    void apresentarse(){
        System.out.println("Olá meu nome é" + nome + "da aldeia" + aldeia ) ;
    }

        public void realizarJutso() {
            System.out.println(nome.concat("realizando jutso"). concat (nomeJutso));
        }
    }

