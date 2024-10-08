package VICTOR_WILLIAM.primeirob.aulas.aula5;

public class Ninja {
    String name;
    int age;
    String clan;
    String village;
    String cla;
    String equipment;
    String jutsu;

    public void apresentar(){
        System.out.println("Olá, meu nome é " + name + " e sou um ninja de " + village + " do clã " + clan + " e tenho " + age + " anos.");
    }

    public void atacar(){
        System.out.println("Atacando com " + equipment + " e usando " + jutsu);
    }
}
