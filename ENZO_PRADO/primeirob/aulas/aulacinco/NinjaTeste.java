package ENZO_PRADO.primeirob.aulas.aulacinco;

public class NinjaTeste {

    public static void main(String[] args) {
        Ninja ninjaUm = new Ninja();
        Ninja ninjaDois = new Ninja();
        ninjaUm.nome = "Naruto";
        ninjaUm.cla = "Uzumaki";
        ninjaUm.aldeia = "Folha";
        ninjaUm.idade = 20;
        ninjaUm.nomeJutso = "Rasengan";
        ninjaUm.equipamento = "Shuriken";
        
        ninjaDois.nome = "Sasuke";
        ninjaDois.cla = "Uchiha";
        ninjaDois.aldeia = "Folha";
        ninjaDois.idade = 20;
        ninjaDois.nomeJutso = "Chidori";
        ninjaDois.equipamento = "Shuriken";
        

        ninjaUm.realizrJutso();
        ninjaDois.realizrJutso();
    }
    
}
