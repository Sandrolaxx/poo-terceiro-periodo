package JOAO_VITOR_SOUZA.primeirob.aulas.aulacinco;

public class TesteNinja {
    public static void main(String[] args) {
        
        Ninja ninjaUm = new Ninja();

        ninjaUm.nome = "Naruto";
        ninjaUm.aldeia = "Folha";
        ninjaUm.cla = "Uzumzki";
        ninjaUm.equipamento = "Shuriken";
        ninjaUm.nomeJutso = "Rasengan";
            ninjaUm.apresentarse();


        Ninja ninjaDois = new Ninja();

        ninjaUm.nome = "Sasuke";
        ninjaUm.aldeia = "Folha";
        ninjaUm.cla = "Uchiha";
        ninjaUm.equipamento = "Shuriken";
        ninjaUm.nomeJutso = "Chidori";

        ninjaDois.apresentarse();

        
    }
}
