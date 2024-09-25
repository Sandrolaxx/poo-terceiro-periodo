package primeirob.aulas.aulacinco;

public class NinjaTest {
    public static void main(String[] args) {
        
        Ninja ninjaUm = new Ninja();
        Ninja ninjaDois = new Ninja();

        ninjaUm.name = "Naruto";
        ninjaUm.Aldeia = "Folha";
        ninjaUm.cla = "Uzumaki";
        ninjaUm.idade = 14;
        ninjaUm.nomeJutsu = "Rasengan";
        ninjaUm.equipamento = "Shuriken";

        ninjaDois.name = "Sasuke";
        ninjaDois.Aldeia = "Folha";
        ninjaDois.cla = "Uchiha";
        ninjaDois.idade = 14;
        ninjaDois.nomeJutsu = "Chidori";
        ninjaDois.equipamento = "Shuriken";

        ninjaUm.realizarJutsu();
        ninjaDois.realizarJutsu();
    }
}
