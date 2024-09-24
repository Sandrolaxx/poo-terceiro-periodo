package data;

import entities.Manager;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ManagersListContainer {
    private final static ArrayList<Manager> MANAGERS = new ArrayList<>();

    public static void add(Manager manager){
        MANAGERS.add(manager);
    }

    public static Manager get(int index){
        try {
            return MANAGERS.get(index);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public static boolean isEmpty(){
        return MANAGERS.isEmpty();
    }

    public static void printAllManagers(){
        if(MANAGERS.isEmpty()){
            System.out.println("Não há gerentes");
            return;
        }
        System.out.println("-------- G E R E N T E S --------");
        for(int i=0; i<MANAGERS.size(); i++){
            System.out.println(
                    Integer.toString(i+1)
                            .concat(". ")
                            .concat(MANAGERS.get(i).getName())
            );
        }
        System.out.println("-------- F I M --------");
    }
}
