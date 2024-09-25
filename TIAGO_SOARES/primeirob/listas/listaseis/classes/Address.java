package primeirob.listas.listaseis.classes;

public class Address {
    String state;
    String city;
    String street;
    String neighborhood;
    Integer number;
    String complement;

    void introduceAddress(){
        System.out.println(
            "(Address): "
            .concat(street)
            .concat(", ")
            .concat(neighborhood)
            .concat(", ")
            .concat(city)
            .concat(" - ")
            .concat(state)
        );
    }
}
