package data;

import entities.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrdersListContainer {

    private final static Map<Integer, Order> ORDERS = new HashMap<>();

    public static void add(Order order) {
        if( getOrderById(order.getId()) != null ) return;
        ORDERS.put(order.getId(), order);
    }

    public static void remove(Order order) {
        ORDERS.remove(order.getId());
    }

    public static int getLastId(){
        Optional<Integer> lastId = ORDERS.keySet().stream().max(Integer::compareTo);
        return lastId.orElse(0);
    }

    public static Order getOrderById(int id) {
        return ORDERS.get(id);
    }

    public static boolean isEmpty(){
        return ORDERS.isEmpty();
    }

    public static void printAllOrders(){
        if(ORDERS.isEmpty()){
            System.out.println("Não há pedidos");
            return;
        }
        System.out.println("-------- P E D I D O S --------");
        ORDERS.values().forEach( item -> {
            System.out.println(item.toString());
        } );
        System.out.println("-------- F I M --------");
    }

    public static void printOpenOrders(){
        if(ORDERS.isEmpty()){
            System.out.println("Não há pedidos");
            return;
        }
        Map<Integer, Order> openOrders = ORDERS.entrySet()
                        .stream()
                        .filter(entry -> !entry.getValue().isPaid())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("-------- P E D I D O S   A   P A G A R --------");
        openOrders.values().forEach( item -> {
            System.out.println(item.toString());
        } );
        System.out.println("-------- F I M --------");
    }

}
