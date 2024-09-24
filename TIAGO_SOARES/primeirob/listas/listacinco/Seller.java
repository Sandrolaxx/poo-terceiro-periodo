package primeirob.listas.listacinco;

public class Seller {
    String name;
    Integer age;
    String shop;
    String city;
    String neighborhood;
    String street;
    double baseWage;
    double[] receivedWage = new double[3];
    

    void introduceYourself(){
        System.out.println("(Seller) Hi, I'm ".concat(name).concat(". I have, ") + age + " years.\n".concat("(Seller) Welcome to ".concat(shop)));
    }

    void calcAvarage(){
        double totalWage = 0;

        for(int i = 0; i < receivedWage.length; i++){
            totalWage += receivedWage[i];
        }
        
        System.out.println("(Seller) My Average Salary is: " + totalWage / receivedWage.length);
    }

    void calcBonus(){
        System.out.println("(Seller) My Bonus is: " + (baseWage * 0.2));
    }
}
