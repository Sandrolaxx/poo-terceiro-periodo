package primeirob.listas.listaseis.classes;

public class Seller extends Person{
    double baseWage;
    double[] receivedWage = new double[3];

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
        super.introduceYourself();
    }

    @Override
    void introduceAddress() {
        super.introduceAddress();
    }
}
