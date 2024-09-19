package primeirob.listas.listasete.classes;

public class Seller extends Person{
    private double baseWage;
    private double[] receivedWage = new double[3];

    public Seller(double baseWage, double[] receivedWage, String name, Integer age, String state, String city, String street, String neighborhood, Integer number, String complement) {
        super(name, age, state, city, street, neighborhood, number, complement);
        this.baseWage = baseWage;
        this.receivedWage = receivedWage;
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
        super.introduceYourself();
    }

    @Override
    public void introduceAddress() {
        super.introduceAddress();
    }
}
