package primeirob.listas.listasete.data;

import java.util.ArrayList;
import java.util.List;

import primeirob.listas.listasete.classes.Customer;
import primeirob.listas.listasete.classes.Item;
import primeirob.listas.listasete.classes.Manager;
import primeirob.listas.listasete.classes.Seller;
import primeirob.listas.listasete.classes.Shop;

public class Data {

    public Shop shopSample(){
        Shop shopSample = new Shop("Myy Plant", "Myy Plant Ltda", "26.395.642/0001-20", "Paraná", "Cascavel",
                "Rua Fortaleza", "Centro", 90, "");

        return shopSample;
    }

    public Manager managerSample() {
        double[] receivedWageSample = new double[] {3400.0, 3750.0, 3550.0};
        Manager manager = new Manager(3100.0, receivedWageSample, shopSample(), "Jane Doe", 36, "Paraná", "Cascavel", "Rua Fortaleza", "Centro", 90, "");

        return manager;
    }

    public Seller sellerSample() {
        double[] receivedWageSample = new double[] {2000.0, 2130.0, 2350.0};
        Seller seller = new Seller(2200.0, receivedWageSample, "John Doe", 22, "Paraná", "Cascavel", "Rua Paraná", "Centro", 190, "");

        return seller;
    }

    public Customer customerSample() {
        Customer customer = new Customer("Gabrielinha", 18, "Paraná", "Cascavel", "Av. Brasil", "Centro", 182, "");

        return customer;
    }

    public Item itemSampleOne() {
        Item item = new Item("GrennBliss", "Plant", 100.0);

        return item;
    }

    public Item itemSampleTwo() {
        Item item = new Item("LeafyJoy", "Plant", 90.0);

        return item;
    }

    public List<Item> itemsDefault() {
        List<Item> defaultItems = new ArrayList<>();
        defaultItems.add(itemSampleOne());
        defaultItems.add(itemSampleTwo());
        return defaultItems;
    }
}
