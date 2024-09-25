package primeirob.listas.listasete.classes;

public class Manager extends Person {
    private double baseWage;
    private double[] receivedWage = new double[3];
    private Shop shop;

    public Manager(double baseWage, double[] receivedWage, Shop shop, String name, Integer age, String state, String city, String street, String neighborhood, Integer number, String complement) {
        super(name, age, state, city, street, neighborhood, number, complement);
        this.baseWage = baseWage;
        this.receivedWage = receivedWage;
        this.shop = shop;
    }

    public double getBaseWage(){
        return baseWage;
    }

    public void setBaseWage(double newBaseWage){
        this.baseWage = newBaseWage;
    }

    public double[] getReceivedWage(){
        return receivedWage;
    }

    public void setReceivedWage(double[] newReceivedWage){
        this.receivedWage = newReceivedWage;
    }

    public void calcAvarage(){
        double totalWage = 0;

        for(int i = 0; i < receivedWage.length; i++){
            totalWage += receivedWage[i];
        }
        
        System.out.println("(Average): " + totalWage / receivedWage.length);
    }

    public void calcBonus(){
        System.out.println("(Bonus): " + (baseWage * 0.35));
    }

    @Override
    public void introduceYourself() {
        System.out.println("Hi, my name is " + getName() + " and i have " + getAge() + " years.");
        System.out.println("I manage the store: " + shop.getFantasyName());
    }
    
}
