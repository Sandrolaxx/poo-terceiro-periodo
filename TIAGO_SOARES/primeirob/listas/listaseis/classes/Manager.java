package primeirob.listas.listaseis.classes;

public class Manager extends Person {
    double baseWage;
    double[] receivedWage = new double[3];
    Shop shop;

    void calcAvarage(){
        double totalWage = 0;

        for(int i = 0; i < receivedWage.length; i++){
            totalWage += receivedWage[i];
        }
        
        System.out.println("(Average): " + totalWage / receivedWage.length);
    }

    void calcBonus(){
        System.out.println("(Bonus): " + (baseWage * 0.35));
    }

    @Override
    void introduceYourself() {
        System.out.println("Hi, my name is " + name + " and i have " + age + " years.");
        System.out.println("I manage the store: " + shop.fantasyName);
    }
    
}