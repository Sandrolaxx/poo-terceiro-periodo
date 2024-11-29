package primeirob.aulas.aulaCinco;

public class Ninja {
    String name;
    int idade;
    String aldeia;
    String cla;
    String equipe;
    String nomeJutso;

    void apresentarse(){
        System.out.println("olá meu nome é  "  +  name   +   "  da aldeia  "   +   aldeia   );
    }
    public void realizarJutso () {
        System.out.println("Realizando jutso  "  +   nomeJutso+  "!");
    }
}
