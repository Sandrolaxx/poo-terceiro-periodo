package primeirob.listas.listacinco;

public class Shop {
    String fantasyName;
    String corporateReason;
    String cnpj;
    String city;
    String neighborhood;
    String street;
    Seller[] sellers = new Seller[2];
    Customer[] customers = new Customer[1];

    void countSellers(){
        System.out.println("(Shop) Sellers in this store is: " + sellers.length);
    }

    void countCustomers(){
        System.out.println("(Shop) Customers in this store is: " + customers.length);
    }

    void introduceYourself(){
        System.out.println("(Shop) Welcome to "
        .concat(fantasyName)
        .concat("!\n(Shop) Our cnpj is: ")
        .concat(cnpj)
        .concat(".\n(Shop) And our address is: ")
        .concat(city)
        .concat(", ")
        .concat(neighborhood)
        .concat(", ")
        .concat(street)
        );
    }
}
