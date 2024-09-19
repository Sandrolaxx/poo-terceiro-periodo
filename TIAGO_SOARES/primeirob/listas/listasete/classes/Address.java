package primeirob.listas.listasete.classes;

public class Address {
    private String state;
    private String city;
    private String street;
    private String neighborhood;
    private Integer number;
    private String complement;

    public Address(String state, String city, String street, String neighborhood, Integer number, String complement){
        this.state = state;
        this.city = city;
        this.street = street;
        this.neighborhood = neighborhood;
        this.number = number;
        this.complement = complement;
    }

    public String getState(){
        return state;
    }

    public void setState(String newState){
        this.state = newState;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String newCity){
        this.city = newCity;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String newStreet){
        this.street = newStreet;
    }

    public String getNeighborhood(){
        return neighborhood;
    }

    public void setNeighborhood(String newNeighborhood){
        this.neighborhood = newNeighborhood;
    }

    public Integer getNumber(){
        return number;
    }

    public void setNumber(Integer newNumber){
        this.number = newNumber;
    }

    public String getComplement(){
        return complement;
    }

    public void setComplement(String newComplement){
        this.complement = newComplement;
    }

    public void introduceAddress(){
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
