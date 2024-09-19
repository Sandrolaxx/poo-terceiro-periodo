package primeirob.listas.listasete.classes;

public class Customer extends Person {
    
    public Customer(String name, Integer age, String state, String city, String street, String neighborhood, Integer number, String complement) {
        super(name, age, state, city, street, neighborhood, number, complement);
    }

    @Override
    void introduceYourself() {
        super.introduceYourself();
    }

    @Override
    public void introduceAddress() {
        super.introduceAddress();
    }
}
