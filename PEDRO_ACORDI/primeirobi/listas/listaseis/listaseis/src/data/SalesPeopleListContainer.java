package data;

import entities.SalesPerson;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SalesPeopleListContainer {
    private final static ArrayList<SalesPerson> SALES_PEOPLE = new ArrayList<>();

    public static void add(SalesPerson salesPerson){
        SALES_PEOPLE.add(salesPerson);
    }

    public static SalesPerson get(int index){
        try {
            return SALES_PEOPLE.get(index);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public static boolean isEmpty(){
        return SALES_PEOPLE.isEmpty();
    }

    public static void printAllSalesPeople(){
        if(SALES_PEOPLE.isEmpty()){
            System.out.println("Não há vendedores");
            return;
        }
        System.out.println("-------- V E N D E D O R E S --------");
        for(int i=0; i<SALES_PEOPLE.size(); i++){
            System.out.println(
                    Integer.toString(i+1)
                            .concat(". ")
                            .concat(SALES_PEOPLE.get(i).getName())
            );
        }
        System.out.println("-------- F I M --------");
    }
}
