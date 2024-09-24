package primeirob.listas.listaseis.classes;

import java.util.UUID;

public class Item {
    String id = UUID.randomUUID().toString();
    String name;
    String type;
    double value;
    
    void generatedDescription(){
        System.out.println("=== Item ===");
        System.out.println("id: ".concat(id));
        System.out.println("name: ".concat(name));
        System.out.println("type: ".concat(type));
        System.out.println("value: R$ " + value);
        System.out.println("=== === ===\n");
        
    }
}
