package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.util.Amount;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Acts as a inventory system that is called
 */
public class ExternalInventorySystem {
    private HashMap<String, Item> inventory = new HashMap<>();

    ExternalInventorySystem(){
        addItems();
    }

    /**
     * Updates the item amount inside the inventory system, using the forEach loop.
     * @param sale Has the info about the sale and it's items.
     */
    public void updateInventory(Sale sale){
        HashMap<String, Item> items = sale.getItems();
        Set<Map.Entry<String, Item>> entries = items.entrySet();

        for (Object entry : entries) {
            Item item = getCurrentItem(entry);

            if (itemExistsInInventory(item)) {
                decreaseAmountOfItem(item);
            }
        }
    }

    private boolean itemExistsInInventory(Item item){
        return inventory.containsKey(item.getItemIdentifier());
    }

    private void decreaseAmountOfItem(Item item){
        Item oldItem = inventory.get(item.getItemIdentifier());
        oldItem.decreaseItemAmount(item.getItemAmount());
        inventory.put(oldItem.getItemIdentifier(), oldItem);
    }

    private Item getCurrentItem(Object entry){
        Map.Entry mapping = (Map.Entry) entry;
        return (Item) mapping.getValue();
    }

    private void addItems(){
        inventory.put("Broccoli", new Item(new ItemData(new Amount(20), "Broccoli", new Amount(10)), "Broccoli", new Amount(Integer.MAX_VALUE)));
        inventory.put("Beef", new Item(new ItemData(new Amount(30), "Broccoli", new Amount(15)), "Broccoli", new Amount(Integer.MAX_VALUE)));
        inventory.put("Honey", new Item(new ItemData(new Amount(42), "Honey", new Amount(20)), "Honey", new Amount(Integer.MAX_VALUE)));
        inventory.put("Potatoes", new Item(new ItemData(new Amount(5), "Potatoes", new Amount(2)), "Potatoes", new Amount(Integer.MAX_VALUE)));
    }
}
