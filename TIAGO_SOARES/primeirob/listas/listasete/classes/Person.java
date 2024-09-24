package primeirob.listas.listasete.classes;

public class Person extends Address {
    private String name;
    private Integer age;

    public Person(String name, Integer age, String state, String city, String street, String neighborhood, Integer number, String complement) {
        super(state, city, street, neighborhood, number, complement);
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    void introduceYourself(){
        System.out.println("Hi, my name is " + name + " and i have " + age + " years.");
    }

    @Override
    public void introduceAddress() {
        super.introduceAddress();
    }
}
