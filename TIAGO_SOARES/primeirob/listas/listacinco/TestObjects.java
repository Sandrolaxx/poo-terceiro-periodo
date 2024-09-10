package primeirob.listas.listacinco;

public class TestObjects {

    public static Seller sallerSampleOne(){
        System.out.println("=== Saller Sample One ===");
        Seller sallerOne = new Seller();
        
        sallerOne.name = "Gabrielinha";
        sallerOne.age = 18;
        sallerOne.shop = "Myy Plant";
        sallerOne.baseWage = 2135.0;

        sallerOne.introduceYourself();
        sallerOne.receivedWage[0] = 2000.0;
        sallerOne.receivedWage[1] = 2100.0;
        sallerOne.receivedWage[2] = 2200.0;
        
        sallerOne.calcAvarage();
        sallerOne.calcBonus();

        System.out.println("\n");

        return sallerOne;
    }

    public static Seller sallerSampleTwo(){
        System.out.println("=== Saller Sample Two ===");
        Seller sallerOne = new Seller();
        
        sallerOne.name = "John Acme";
        sallerOne.age = 22;
        sallerOne.shop = "Acme Inc.";
        sallerOne.baseWage = 3135.0;

        sallerOne.introduceYourself();
        sallerOne.receivedWage[0] = 3000.0;
        sallerOne.receivedWage[1] = 3100.0;
        sallerOne.receivedWage[2] = 3200.0;
        
        sallerOne.calcAvarage();
        sallerOne.calcBonus();

        System.out.println("\n");

        return sallerOne;
    }

    public static Customer customerSample(){
        System.out.println("=== Customer Sample ===");
        
        Customer customerOne = new Customer();
        
        customerOne.name = "Gabrielinha";
        customerOne.age = 18;
        
        customerOne.introduceYourself();

        return customerOne;
    }

    public static Shop shopSample(Seller[] sellers, Customer[] customers){
        System.out.println("=== Shop Sample ===");

        Shop shopOne = new Shop();

        shopOne.fantasyName = "Myy Plant";
        shopOne.cnpj = "26.395.642/0001-20";
        shopOne.city = "Cascavel";
        shopOne.neighborhood = "Tropical";
        shopOne.street = "Rua 01";
        shopOne.sellers = sellers;
        shopOne.customers = customers;

        shopOne.introduceYourself();
        shopOne.countSellers();
        shopOne.countCustomers();

        return shopOne;
    }

    public static void main(String[] args) {
        clearConsole();

        Seller[] sellersArray = new Seller[2];
        sellersArray[0] = TestObjects.sallerSampleOne();
        sellersArray[0] = TestObjects.sallerSampleTwo();

        Customer[] customersArray = new Customer[1];
        customersArray[0] = TestObjects.customerSample();
        
        Shop shopOne = TestObjects.shopSample(sellersArray, customersArray);
        
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}