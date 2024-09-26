package VICTOR_WILLIAM.primeirob.aulas.aula5;

public class NinjaTest {
    public static void main(String[] args) {
        Ninja n1 = new Ninja();

        String texto = "Naruto1234567890";

        n1.name = StringUtils.removeNumeros(texto);
        n1.age = 17;
        n1.clan = "Uzumaki";
        n1.village = "Konoha";
        n1.cla = "Genin";
        n1.equipment = "Kunai";
        n1.jutsu = "Kage Bunshin no Jutsu";
        n1.apresentar();
        n1.atacar();

        Ninja n2 = new Ninja();

        n2.name = "Sasuke";
        n2.age = 17;
        n2.clan = "Uchiha";
        n2.village = "Konoha";
        n2.cla = "Genin";
        n2.equipment = "Kunai";
        n2.jutsu = "Chidori";
        n2.apresentar();
        n2.atacar();
    }
}
