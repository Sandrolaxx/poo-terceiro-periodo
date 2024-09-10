package domain.entities;

public class Client extends Person{

    public Client(String name, int age, Address address) {
        super(name, age, address);
    }

    public void introduceSelf(){
        System.out.println("Olá! Eu sou "
                .concat(getName())
                .concat(" e tenho ")
                .concat(Integer.toString(getAge()))
        );
    }
}
