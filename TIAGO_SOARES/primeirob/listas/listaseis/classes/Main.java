package primeirob.listas.listaseis.classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static int choice;
    private static int subChoice;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        do {
            clearConsole();
            shopSample().introduceYourself();
            System.out.println(
            "\n====== Menu ======\n" +
            "[1] Place order\n" +
            "[2] Check Sellers\n" +
            "[3] Check Itens\n" +
            "[4] Check Managers\n" +
            "[5] View more shop information\n" +
            "[6] Exit\n" +
            "====== ==== ======"
            );
            System.out.print("(User): ");
            choice = reader.nextInt();

            switch (choice) {
                case 1:
                    placeOrder(reader);
                    break;
                case 2:
                    getSubChoice(reader, 1);
                    break;
                case 3:
                    getSubChoice(reader, 2);
                    break;
                case 4:
                    getSubChoice(reader, 3);
                    break;
                case 5:
                    getSubChoice(reader, 4);
                    
                    break;
                default:
                    break;
            }

        } while (choice != 6);
        reader.close();
    }

    private static Shop shopSample() {
        Shop shopSample = new Shop();

        // From class Shop
        shopSample.fantasyName = "Myy Plant";
        shopSample.corporateReason = "Myy Plant Ltda";
        shopSample.cnpj = "26.395.642/0001-20";

        // From class Address
        shopSample.state = "Paraná";
        shopSample.city = "Cascavel";
        shopSample.street = "Rua Fortaleza";
        shopSample.neighborhood = "Centro";
        shopSample.number = 90;

        return shopSample;
    }

    private static Manager managerSample() {
        Manager manager = new Manager();

        // From class Manager
        manager.baseWage = 3100.0;
        manager.receivedWage[0] = 3400.0;
        manager.receivedWage[1] = 3750.0;
        manager.receivedWage[2] = 3550.0;
        manager.shop = shopSample();

        // From class Person
        manager.name = "Jane Doe";
        manager.age = 36;

        // From class Address
        manager.state = "Paraná";
        manager.city = "Cascavel";
        manager.street = "Rua Fortaleza";
        manager.neighborhood = "Centro";
        manager.number = 90;

        return manager;
    }

    private static Seller sellerSample() {
        Seller seller = new Seller();

        // From class Seller
        seller.baseWage = 2200.0;
        seller.receivedWage[0] = 2000.0;
        seller.receivedWage[1] = 2130.0;
        seller.receivedWage[2] = 2350.0;

        // From class Person
        seller.name = "John Doe";
        seller.age = 22;

        // From class Address
        seller.state = "Paraná";
        seller.city = "Cascavel";
        seller.street = "Rua Paraná";
        seller.neighborhood = "Centro";
        seller.number = 190;

        return seller;
    }

    private static Customer customerSample(){
        Customer customer = new Customer();

        // From class Person
        customer.name = "Gabrielinha";
        customer.age = 18;
        
        // From class Address
        customer.state = "Paraná";
        customer.city = "Cascavel";
        customer.street = "Av. Brasil";
        customer.neighborhood = "Centro";
        customer.number = 182;

        return customer;
    }

    private static Item itemSampleOne() {
        Item item = new Item();

        // ID is auto-generated
        item.name = "GreenBliss";
        item.type = "Plant";
        item.value = 100.0;

        return item;
    }

    private static Item itemSampleTwo() {
        Item item = new Item();

        // ID is auto-generated
        item.name = "LeafyJoy";
        item.type = "Plant";
        item.value = 90.0;

        return item;
    }

    @SuppressWarnings("unused")
    private static void placeOrder(Scanner reader){
        Order newOrder = new Order();
        Item item = null;
        Item itemOne = itemSampleOne();
        Item itemTwo = itemSampleTwo();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        int internalChoice;
        int subChoice;
        int amount;
        Date dateBooking;
        Date datePayment;
        
        do {
            clearConsole();
            System.out.println("(System): To proceed with closing your order, please inform us which item you would like to add");
            System.out.println("(System): Below are the items we have registered: \n");
    
            itemOne.generatedDescription();
            itemTwo.generatedDescription();
    
            do {
                System.out.println("\n(System): Which item do you want to add to your order?");
                System.out.println("(System): [1] " + itemOne.name + " [2] " + itemTwo.name);
                System.out.print("(User): ");
                subChoice = reader.nextInt();
            } while (subChoice != 1 && subChoice != 2);
    
            System.out.print("\n(System): How many units do you want to add? \n(User): ");
            amount = reader.nextInt();
        
            if (subChoice == 1) {
                item = itemOne;
            } else if (subChoice == 2) {
                item = itemTwo;
            }
        
            if (item != null) {
                for (int i = 0; i < amount; i++) {
                    newOrder.addItem(item);
                }
                System.out.println("\n(System): " + amount + " unit(s) of " + item.name + " added to your order.");
            }

            System.out.println("\n(System): Do you want to add more items?");
            System.out.println("(System): [1] Yes [2] No, next step.");
            System.out.print("(User): ");
            internalChoice = reader.nextInt();
            reader.nextLine();
    
        } while (internalChoice == 1);
    
        clearConsole();
        newOrder.shop = shopSample();
        newOrder.seller = sellerSample();
        newOrder.customer = customerSample();
        newOrder.manager = managerSample();
    
        System.out.println("\n(System): Please advise booking date (dd/MM/yyyy): ");
        System.out.print("(User): ");
        String dateBookingByUser = reader.nextLine();
        
        System.out.println("\n(System): Please advise payment date (dd/MM/yyyy): ");
        System.out.print("(User): ");
        String datePaymentByUser = reader.nextLine();

        try {
            dateBooking = dateFormat.parse(dateBookingByUser);
            newOrder.expiredBooking = dateBooking;

            datePayment = dateFormat.parse(datePaymentByUser);
            newOrder.datePayment = datePayment;

            GenerateOrder generateOrder = new GenerateOrder();

            if(generateOrder.process(newOrder)){
                clearConsole();
                System.out.println("\n(System): Order generated successfully!");

                newOrder.descriptionOrder();
            }else{
                clearConsole();
                System.out.println("\n(System): Your order could not be generated, please try again!");
            };

            System.out.println(
                "\n====== Menu ======\n" +
                "[1] Enter anything to return\n" +
                "====== ==== ======");
            System.out.print("(User): ");
            String tapExit = reader.nextLine();
        
        } catch (Exception e) {
            System.out.println("(System): Invalid date format. Please use dd/MM/yyyy.");
            
            System.out.println(
                "\n====== Menu ======\n" +
                "[1] Enter anything to return\n" +
                "====== ==== ======");
            System.out.print("(User): ");
            String tapExit = reader.nextLine();
        }

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

    private static void getSubChoice(Scanner reader, int internalSwitch){
        do {
            clearConsole();
            switch (internalSwitch) {
                case 1:
                    sellerSample().introduceYourself();
                    sellerSample().introduceAddress();
                    sellerSample().calcBonus();
                    sellerSample().calcAvarage();
                    break;
                case 2:
                    itemSampleOne().generatedDescription();
                    itemSampleTwo().generatedDescription();
                    break;
                case 3:
                    managerSample().introduceYourself();
                    managerSample().introduceAddress();
                    managerSample().calcBonus();
                    managerSample().calcAvarage();
                    
                    break;
                case 4:
                    shopSample().introduceAddress();
                    break;
                    
                default:
                    break;
            }
            

            System.out.println(
                "\n====== Menu ======\n" +
                "[1] Return\n" +
                "====== ==== ======");
            System.out.print("(User): ");
            subChoice = reader.nextInt();

        } while (subChoice != 1);
    }
}