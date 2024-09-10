package domain.entities;

public class Address {
    private String street;
    private String neighborhood;
    private String city;

    public Address(String street, String neighborhood, String city) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
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

    @Override
    public String toString() {
        return street
                .concat(", ")
                .concat(neighborhood)
                .concat(", ")
                .concat(city);
    }
}
