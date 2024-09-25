package primeirob.aulas.aulacinco;

public class SampleNinja {
    public static void main(String[] args) {
        Ninja ninjaOne = new Ninja();

        ninjaOne.name = "John Acme";
        ninjaOne.cla = "Leaf Village";
        ninjaOne.ability = "Jutsu Power";

        ninjaOne.getNinja();
        ninjaOne.sendPower();
    }
}
