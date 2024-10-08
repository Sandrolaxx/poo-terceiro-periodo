package data;

import entities.Client;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ClientsListContainer {
    private final static ArrayList<Client> CLIENTS = new ArrayList<>();

    public static void add(Client client){
        CLIENTS.add(client);
    }

    public static Client get(int index){
        try {
            return CLIENTS.get(index);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public static boolean isEmpty(){
        return CLIENTS.isEmpty();
    }

    public static void printAllClients(){
        if(CLIENTS.isEmpty()){
            System.out.println("Não há clientes");
            return;
        }
        System.out.println("-------- C L I E N T E S --------");
        for(int i=0; i<CLIENTS.size(); i++){
            System.out.println(
                    Integer.toString(i+1)
                            .concat(". ")
                            .concat(CLIENTS.get(i).getName())
            );
        }
        System.out.println("-------- F I M --------");
    }
}
