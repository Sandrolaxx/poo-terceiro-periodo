package primeirob.listas.listasete.classes;

import java.util.List;

public class Items {
    private List<Item> itemList;

    public Items(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public void descriptionItems() {
        System.out.println("=== List of Items ===");
        for (Item item : itemList) {
            item.generatedDescription();
        }
    }

    public Item findItemByName(String nameOfItem) {
        return itemList.stream().filter(item -> item.getName().equalsIgnoreCase(nameOfItem)).findFirst().orElse(null);
    }

}
