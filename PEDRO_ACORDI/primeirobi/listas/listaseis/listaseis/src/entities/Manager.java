package entities;

public class Manager extends SalesPerson{

    public Manager(String name, int age, Address address, Store store, double grossSalary) {
        super(name, age, address, store, grossSalary);
    }

    @Override
    public void introduceSelf() {
        System.out.println("Gerente da loja "
                .concat(getStore().getTradingName())
                .concat(" e me chamo ")
                .concat(getName())
                .concat(" e tenho ")
                .concat(Integer.toString(getAge()))
                .concat(" anos.")
        );
    }

    @Override
    public double getBonus() {
        return this.getGrossSalary() * 0.35;
    }
}
