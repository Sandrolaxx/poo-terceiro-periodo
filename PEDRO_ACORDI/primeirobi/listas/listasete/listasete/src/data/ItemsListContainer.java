package data;

import entities.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemsListContainer {

    private final static Map<Integer, Item> ITEMS = new HashMap<>();

    public static void add(Item item) {
        if( getItemById(item.getId()) != null ) return;
        ITEMS.put(item.getId(), item);
    }

    public static int getLastId(){
        Optional<Integer> lastId = ITEMS.keySet().stream().max(Integer::compareTo);
        return lastId.orElse(0);
    }

    public static Item getItemById(int id) {
        return ITEMS.get(id);
    }

    public static boolean isEmpty(){
        return ITEMS.isEmpty();
    }

    public static void printAllItems(){
        if(ITEMS.isEmpty()){
            System.out.println("Não há itens");
            return;
        }
        System.out.println("-------- I T E N S --------");
        ITEMS.values().forEach( item -> {
            System.out.println(item.toString());
        } );
        System.out.println("-------- F I M --------");
    }

    private static Map<Integer, Item> getItemsFilteredByName(String name){
        return ITEMS.entrySet()
                .stream()
                .filter( entry -> entry.getValue().getName().toLowerCase().contains(name.toLowerCase()) )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void printByName(String name){
        Map<Integer, Item> filteredItems = getItemsFilteredByName(name);
        if(filteredItems.isEmpty()){
            System.out.println("Não há itens com esse filtro.");
            return;
        }
        System.out.println("-------- I T E N S --------");
        filteredItems.values().forEach( item -> {
            System.out.println(item.toString());
        } );
        System.out.println("-------- F I M --------");
    }

}
