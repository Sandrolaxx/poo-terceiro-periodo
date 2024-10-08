package primeirob.listas.listasete.classes;

public class Shop extends Address {
    private String fantasyName;
    private String corporateReason;
    private String cnpj;

    public Shop(String fantasyName, String corporateReason, String cnpj, String state, String city, String street, String neighborhood, Integer number, String complement) {
        super(state, city, street, neighborhood, number, complement);
        this.fantasyName = fantasyName;
        this.corporateReason = corporateReason;
        this.cnpj = cnpj;
    }

    public String getFantasyName(){
        return fantasyName;
    }

    public String getCorporateReason(){
        return corporateReason;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void introduceYourself(){
        System.out.println("(Shop) Welcome to "
        .concat(fantasyName)
        .concat("\n\n")
        .concat("(Shop) What would you like to do today? ")
        );
    }

    @Override
    public void introduceAddress() {
        System.out.println(
            "(Address): "
            .concat(getStreet())
            .concat(", ")
            .concat(getNeighborhood())
            .concat(", ")
            .concat(getCity())
            .concat(" - ")
            .concat(getState())
            .concat("!\n(CNPJ): ")
            .concat(cnpj)
        );
    }
}
