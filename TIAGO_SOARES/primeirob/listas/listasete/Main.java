package primeirob.listas.listasete;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import primeirob.listas.listasete.classes.GenerateOrder;
import primeirob.listas.listasete.classes.Item;
import primeirob.listas.listasete.classes.Items;
import primeirob.listas.listasete.classes.Order;
import primeirob.listas.listasete.data.Data;
import primeirob.listas.listasete.utils.Console;

public class Main {
    
    private static int choice;
    private static int subChoice;
    
    static Data data = new Data();
    static Console console = new Console();
    static Items listItems = new Items(data.itemsDefault());

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        do {
            console.clear();
            data.shopSample().introduceYourself();
            System.out.println(
                    "\n====== Menu ======\n" +
                            "[1] Place order\n" +
                            "[2] Check Sellers\n" +
                            "[3] Check all Items\n" +
                            "[4] Check Managers\n" +
                            "[5] View more shop information\n" +
                            "[6] Register items\n" +
                            "[7] Check Items by Name\n" +
                            "[8] Exit\n" +
                            "====== ==== ======");
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
                case 6:
                    registerItem(reader);
                    break;
                case 7:
                    searhItem(reader);
                    break;
                default:
                    break;
            }

        } while (choice != 8);
        reader.close();
    }

    @SuppressWarnings("unused")
    private static void placeOrder(Scanner reader) {
        Order newOrder = new Order();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        int internalChoice;
        String nameOfItem;
        int amount;

        Date dateBooking;
        Date datePayment;
        reader.nextLine();

        do{
            console.clear();
            System.out.println("(System): To proceed with closing your order, please inform us which item you would like to add");
            System.out.println("(System): Below are the items we have registered: \n");

            listItems.descriptionItems();
            
            System.out.println("\n(System): Which item do you want to add to your order?");
            System.out.println("\n(System): Please provide the name of the item you would like!");
            System.out.print("(User): ");
            nameOfItem = reader.nextLine();

            Item itemFound = listItems.findItemByName(nameOfItem);
            if(itemFound != null){
                System.out.print("\n(System): How many units do you want to add? \n(User): ");
                amount = reader.nextInt();

                for (int i = 0; i < amount; i++) {
                    newOrder.addItem(itemFound);
                }

                System.out.println("\n(System): " + amount + " unit(s) of " + itemFound.getName() + " added to your order.");

                System.out.println("\n(System): Do you want to add more items?");
                System.out.println("(System): [1] Yes [2] No, next step.");
                System.out.print("(User): ");
                internalChoice = reader.nextInt();
                reader.nextLine();
            }else{
                System.out.println("\n(System): Sorry, we couldn't find this item in the list, please try again.");
                System.out.println("\n(System): redirecting in 3 seconds... ");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                internalChoice = 1;
            }
        }while(internalChoice != 2);
        
        console.clear();
        newOrder.setShop(data.shopSample());
        newOrder.setSeller(data.sellerSample());
        newOrder.setCustomer(data.customerSample());
        newOrder.setManager(data.managerSample());

        System.out.println("\n(System): Please advise booking date (dd/MM/yyyy): ");
        System.out.print("(User): ");
        String dateBookingByUser = reader.nextLine();

        System.out.println("\n(System): Please advise payment date (dd/MM/yyyy): ");
        System.out.print("(User): ");
        String datePaymentByUser = reader.nextLine();

        try {
            dateBooking = dateFormat.parse(dateBookingByUser);
            newOrder.setExpiredBooking(dateBooking);

            datePayment = dateFormat.parse(datePaymentByUser);
            newOrder.setDatePayment(datePayment);

            GenerateOrder generateOrder = new GenerateOrder();

            if (generateOrder.process(newOrder)) {
                console.clear();
                System.out.println("\n(System): Order generated successfully!");

                newOrder.descriptionOrder();
            } else {
                console.clear();
                System.out.println("\n(System): Your order could not be generated, please try again!");
            }
            ;

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

    private static void registerItem(Scanner reader){
        int internalChoice;
        reader.nextLine();
        do{
            String name;
            String type;
            double value;
            console.clear();
            System.out.println("(System): To be required to register an item name, I need some information. \n");

            System.out.println("(System): What will be the name of the new item?");
            System.out.print("\n(User): ");
            name = reader.nextLine();
            
            System.out.println("\n(System): What will be the type of this new item/category?");
            System.out.print("\n(User): ");
            type = reader.nextLine();
            
            System.out.println("\n(System): What will be the value of this new item?");
            System.out.print("\n(User): ");
            value = reader.nextDouble();

            try {
                Item newItem = new Item(name.toUpperCase(), type, value);
                listItems.addItem(newItem);
                console.clear();
                System.out.println("(System): Product added successfully! \n");
                System.out.println("(System): You can see it in the previous menu by viewing all items! \n");
            } catch (Exception e) {
                System.out.println("(System): We were unable to register your new item, please try again in a few minutes");
            }

            System.out.println("(System): Do you like register another item?! \n");

            System.out.println(
                            "[1] Yes, I do\n" +
                            "[2] Return");
            System.out.print("(User): ");
            internalChoice = reader.nextInt();
            reader.nextLine();
        }while(internalChoice != 2);
    }

    private static void searhItem(Scanner reader){
        
        int internalChoice;
        do{
            console.clear();
            reader.nextLine();
            System.out.println("(System): Please provide the name of the item you would like search");
            System.out.print("(User): ");
            String nameOfItem = reader.nextLine();

            Item itemFound = listItems.findItemByName(nameOfItem);

            if(itemFound != null){
                itemFound.generatedDescription();

                System.out.println("(System): Would you like to do another search? ");
                System.out.println("(System): [1] Yes [2] No, return.");
                System.out.print("(User): ");
                internalChoice = reader.nextInt();
            }else{
                System.out.println("(System): Sorry, we couldn't find this item in the list, please try again.");
                System.out.println("\n(System): redirecting in 3 seconds... ");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                internalChoice = 1;
            }
        }while(internalChoice != 2);
    }

    private static void getSubChoice(Scanner reader, int internalSwitch) {
        do {
            console.clear();
            switch (internalSwitch) {
                case 1:
                    data.sellerSample().introduceYourself();
                    data.sellerSample().introduceAddress();
                    data.sellerSample().calcBonus();
                    data.sellerSample().calcAvarage();
                    break;
                case 2:
                    listItems.descriptionItems();
                    break;
                case 3:
                    data.managerSample().introduceYourself();
                    data.managerSample().introduceAddress();
                    data.managerSample().calcBonus();
                    data.managerSample().calcAvarage();

                    break;
                case 4:
                data.shopSample().introduceAddress();
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