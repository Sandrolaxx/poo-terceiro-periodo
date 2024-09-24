package primeirob.listas.listasete.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order{
    private String id = UUID.randomUUID().toString();
    private Date createdAt = new Date();
    private Date datePayment;
    private Date expiredBooking;
    private Customer customer;
    private Seller seller;
    private Shop shop;
    private Manager manager;
    private List<Item> itens = new ArrayList<>();
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
    
    public Date getDatePayment(){
        return datePayment;
    }

    public void setDatePayment(Date newDatePayment){
        this.datePayment = newDatePayment;
    }

    public Date getExpiredBooking(){
        return expiredBooking;
    }

    public void setExpiredBooking(Date newExpiredBooking){
        this.expiredBooking = newExpiredBooking;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer newCustomer){
        this.customer = newCustomer;
    }

    public Seller getSeller(){
        return seller;
    }

    public void setSeller(Seller newSeller){
        this.seller = newSeller;
    }

    public Shop getShop(){
        return shop;
    }

    public void setShop(Shop newShop){
        this.shop = newShop;
    }

    public Manager getManager(){
        return manager;
    }

    public void setManager(Manager newManager){
        this.manager = newManager;
    }

    public void addItem(Item item) {
        itens.add(item);
    }

    double calcValueTotal(){
        double totalOrder = 0;

        for (Item item : itens) {
            totalOrder += item.getValue();
        }

        return totalOrder;
    }
    
    public void descriptionOrder(){
        System.out.println("=== Order ===");
        System.out.println("ID: " + id);
        System.out.println("Created: " + dateFormat.format(createdAt));
        System.out.println("Shop: " + shop.getFantasyName());
        System.out.println("Manager: " + manager.getName());
        System.out.println("Seller: " + seller.getName());
        System.out.println("Customer: " + customer.getName());
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
