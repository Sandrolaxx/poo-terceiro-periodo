package primeirob.listas.listacinco;

public class Customer {
    String name;
        Integer age;
        String city;
        String neighborhood;
        String street;

        void introduceYourself(){
            System.out.println("(Customer) Hi, I'm ".concat(name).concat(". I have, ") + age + " years.\n");
        }
}
