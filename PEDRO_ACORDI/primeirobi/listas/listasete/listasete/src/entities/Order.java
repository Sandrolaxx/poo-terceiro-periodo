package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int id;
    private Date creationDate;
    private Date paymentDate;
    private Date expirationDate;
    private Client client;
    private SalesPerson salesPerson;
    private Store store;
    private ArrayList<OrderItem> items;

    public Order(int id, Date creationDate, Date paymentDate, Date expirationDate, Client client, SalesPerson salesPerson, Store store, ArrayList<OrderItem> items) {
        this.id = id;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.expirationDate = expirationDate;
        this.client = client;
        this.salesPerson = salesPerson;
        this.store = store;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Client getClient() {
        return client;
    }

    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public Store getStore() {
        return store;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getTotalValue(){
        return this.items
                .stream()
                .mapToDouble(item -> (item.getItem().getPrice() * item.getQuantity()))
                .sum();
    }

    public void printOrderDescription(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(
                "Pedido: "
                        .concat(Integer.toString(getId()))
                        .concat("\nData: ")
                        .concat(formatter.format(getCreationDate()))
                        .concat("\nValor total: ")
                        .concat(Double.toString(getTotalValue()))
                        .concat("\nCliente: ")
                        .concat(getClient().getName())
                        .concat("\nVendedor: ")
                        .concat(getSalesPerson().getName())
                        .concat("\nLoja: ")
                        .concat(getStore().getTradingName())
        );
    }

    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "Pedido N°"
                .concat(Integer.toString(getId()))
                .concat("\tData: ")
                .concat(formatter.format(getCreationDate()))
                .concat("\tValor total: ")
                .concat(Double.toString(getTotalValue()))
                .concat("\tCliente: ")
                .concat(getClient().getName())
                .concat("\tVendedor: ")
                .concat(getSalesPerson().getName())
                .concat("\tLoja: ")
                .concat(getStore().getTradingName())
                .concat("\tPago: ")
                .concat( isPaid() ? "Sim" : "Não" );
    }

    public boolean isPaymentExpired(){
        return this.getExpirationDate().before(new Date());
    }

    public boolean isPaid(){
        return this.getPaymentDate() != null;
    }

}
