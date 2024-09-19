package primeirob.listas.listasete.classes;

import java.util.UUID;

public class Item {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String type;
    private double value;

    public Item(String name, String type, double value){
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public double getValue(){
        return value;
    }

    public void setValue(double newValue){
        this.value = newValue;
    }
    
    public void generatedDescription(){
        System.out.println("=== Item ===");
        System.out.println("id: ".concat(id));
        System.out.println("name: ".concat(name));
        System.out.println("type: ".concat(type));
        System.out.println("value: R$ " + value);
        System.out.println("=== === ===\n");
        
    }
}
