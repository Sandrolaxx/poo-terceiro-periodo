package DIONATAN_DARIZ.primeirob.aulas.aulacinco.Ninja;

public class NinjaTeste {
    
    public static void main(String[] args) {
        Ninja ninjaUm = new Ninja();
        Ninja ninjaDois = new Ninja();

        ninjaUm.nome = "Minato";
        ninjaUm.aldeia = "Aldeia da Folha";
        ninjaUm.cla = "Namikaze";
        ninjaUm.nomeJutso = "Rasengan";
        ninjaUm.equipamento = "Kunai";

        ninjaDois.nome = "Himawari";
        ninjaDois.aldeia = "Aldeia da Folha";
        ninjaDois.cla = "Uzumaki";
        ninjaDois.nomeJutso = "Sunflore Blaze";
        ninjaDois.equipamento = "Kunai";

        ninjaUm.apresentarse();
        ninjaUm.realizarJutso();

        ninjaDois.apresentarse();
        ninjaDois.realizarJutso();
    }
}
