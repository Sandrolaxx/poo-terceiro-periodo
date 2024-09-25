package primeirob.listas.listaseis.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order{
    String id = UUID.randomUUID().toString();
    Date createdAt = new Date();
    Date datePayment;
    Date expiredBooking;
    Customer customer;
    Seller seller;
    Shop shop;
    Manager manager;
    List<Item> itens = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

    public void addItem(Item item) {
        itens.add(item);
    }

    double calcValueTotal(){
        double totalOrder = 0;

        for (Item item : itens) {
            totalOrder += item.value;
        }

        return totalOrder;
    }
    
    void descriptionOrder(){
        System.out.println("=== Order ===");
        System.out.println("ID: " + id);
        System.out.println("Created: " + dateFormat.format(createdAt));
        System.out.println("Shop: " + shop.fantasyName);
        System.out.println("Manager: " + manager.name);
        System.out.println("Seller: " + seller.name);
        System.out.println("Customer: " + customer.name);
        if(!itens.isEmpty()){
            System.out.println("Itens: " + itens.size());
        }
        if(datePayment != null && expiredBooking != null){
            System.out.println("Date Payment: " + dateFormat.format(datePayment));
            System.out.println("Date Booking: " + dateFormat.format(expiredBooking));
        }
        System.out.println("Total Order: R$" + calcValueTotal());
    }
}
