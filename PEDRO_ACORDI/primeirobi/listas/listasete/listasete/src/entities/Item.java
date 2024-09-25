package entities;

public class Item {
    private int id;
    private String name;
    private String type;
    private double price;

    public Item(int id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void printDescription(){
        System.out.println(
                "Name: "
                .concat(name)
                .concat("\nType: ")
                .concat(type)
                .concat("\nPrice: ")
                .concat(Double.toString(price))
        );
    }

    @Override
    public String toString() {
        return "Item N° "
                .concat(Integer.toString(id))
                .concat("\tNome: ")
                .concat(name)
                .concat("\tTipo: ")
                .concat(type)
                .concat("\tPreco: ")
                .concat(Double.toString(price));
    }
}
