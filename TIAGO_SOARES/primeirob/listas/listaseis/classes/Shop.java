package primeirob.listas.listaseis.classes;

public class Shop extends Address {
    String fantasyName;
    String corporateReason;
    String cnpj;

    void introduceYourself(){
        System.out.println("(Shop) Welcome to "
        .concat(fantasyName)
        .concat("\n\n")
        .concat("(Shop) What would you like to do today? ")
        );
    }

    @Override
    void introduceAddress() {
        System.out.println(
            "(Address): "
            .concat(street)
            .concat(", ")
            .concat(neighborhood)
            .concat(", ")
            .concat(city)
            .concat(" - ")
            .concat(state)
            .concat("!\n(CNPJ): ")
            .concat(cnpj)
        );
    }
}
