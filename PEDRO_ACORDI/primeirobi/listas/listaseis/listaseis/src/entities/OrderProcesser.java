package entities;

import data.OrdersListContainer;
import exceptions.OrderException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderProcesser {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static Order process(Client client, SalesPerson salesPerson, Store store, ArrayList<Item> items){
        Date creation = new Date();
        Date expiration = new Date( creation.getTime() + (1000*60*60*24*3) );
        Order order = new Order( OrdersListContainer.getLastId()+1,
                creation,
                null,
                expiration,
                client,
                salesPerson,
                store,
                items
        );
        OrdersListContainer.add(order);
        return order;
    }

    public static void confirmPayment(Order order){
        if(order.isPaymentExpired()){
            System.out.println("Reserva vencida. Pagamento não confirmado");
        }else{
            System.out.println("Pagamento confirmado.");
            order.setPaymentDate(new Date());
        }
    }


}
