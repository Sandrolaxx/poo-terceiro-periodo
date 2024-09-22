package ROBSON_DE_LIMA.primeirob.aulas.aulaCinco;

public class NinjaTeste {
    
    public static void main(String[] args) {
        Ninja ninjaum = new Ninja();
        Ninja ninjadois = new Ninja();


        ninjaum.name = "Naruto";
        ninjaum.aldeia = "Folha";
        ninjaum.cla = "Üzumaki";
        ninjaum.idade = 20;
        ninjaum.nomeJutso = "rasengan";
        ninjaum.equipe = "royal";


        ninjadois.name = "Narutche";
        ninjadois.aldeia = "cuias";
        ninjadois.cla = "mate";
        ninjadois.idade = 20;
        ninjadois.nomeJutso = "guri";
        ninjadois.equipe = "ximbinhas";

        ninjaum.apresentarse();
        ninjaum.realizarJutso();

        ninjadois.apresentarse();
        ninjadois.realizarJutso();


        
        
    
    
    
    }

}
