package entities;

public class Address {
    private String street;
    private String neighborhood;
    private String city;
    private String complement;

    public Address(String street, String neighborhood, String city, String complement) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getComplement() {
        return complement;
    }

    public void printAddress() {
        System.out.println(
                street
                .concat(", ")
                .concat(neighborhood)
                .concat(", ")
                .concat(complement)
                .concat(", ")
                .concat(city)
        );
    }
}
