package data;

import entities.Store;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StoresListContainer {

    private final static ArrayList<Store> STORES = new ArrayList<>();

    public static void add(Store store){
        STORES.add(store);
    }

    public static Store get(int index){
        try {
            return STORES.get(index);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    
    public static boolean isEmpty(){
        return STORES.isEmpty();
    }

    public static void printAllStores(){
        if(STORES.isEmpty()){
            System.out.println("Não há lojas");
            return;
        }
        System.out.println("-------- L O J A S --------");
        for (int i = 0; i < STORES.size(); i++) {
            System.out.println( Integer.toString(i+1)
                            .concat(". ")
                            .concat(STORES.get(i).getTradingName())
            );
        }
        System.out.println("-------- F I M --------");
    }
}
