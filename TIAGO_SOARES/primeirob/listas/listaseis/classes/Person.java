package primeirob.listas.listaseis.classes;

public class Person extends Address {
    String name;
    Integer age;

    void introduceYourself(){
        System.out.println("Hi, my name is " + name + " and i have " + age + " years.");
    }

    @Override
    void introduceAddress() {
        super.introduceAddress();
    }
}
