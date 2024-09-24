package primeirob.aulas.aulacinco;

public class Ninja {
    String name;
    Integer age;
    String cla;
    String ability;
    Integer power;

    public void getNinja(){
        System.out.println("I'am the ninja ".concat(name).concat(" by cla ").concat(cla));
    } 
    
    public void sendPower(){
        System.out.println(name.concat(" Send power! ").concat(ability));
    }
}
