package domain.entities;

import java.util.ArrayList;

public class SalesPerson extends Person {

    private Store store;
    private double grossSalary;
    private ArrayList<Double> receivedSalaries;

    public SalesPerson(String name, int age, Address address, Store store, double grossSalary) {
        super(name, age, address);
        this.store = store;
        this.grossSalary = grossSalary;
        this.receivedSalaries = new ArrayList<>();
    }

    public Store getStore() {
        return store;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public ArrayList<Double> getReceivedSalaries() {
        return receivedSalaries;
    }

    public double getAverageSalary(){
        return this.receivedSalaries
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    public double getBonus(){
        return this.grossSalary * 0.2;
    }

    public void introduceSelf(){
        System.out.println("Olá! Eu sou o vendedor "
                .concat(getName())
                .concat(" e tenho ")
                .concat(Integer.toString(getAge()))
                .concat(" anos e trabalho na loja ")
                .concat(getStore().getTradingName())
        );
    }

    public void addSalary(double salary){
        if(salary <= 0) throw new IllegalArgumentException("Salário deve ser maior ou igual a 0.");
        this.receivedSalaries.add(salary);
    }
}
