package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.util.Amount;

import java.util.HashMap;

/**
 * Acts as a item database.
 */
public class ItemInventory {
    private HashMap<String, ItemData> itemList = new HashMap<>();

    /**
     * item database that is created by an instance.
     */
    ItemInventory(){
        addItems();
    }

    /**
     * Looks for existing itemIdentifier.
     * @param itemIdentifier The item we're looking for.
     * @return Gives <code>True</code> if the item exists else it returns <code>false</code>
     */
    public boolean itemExists(String itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }

    public Item getItem(String itemIdentifier, Amount quantity){
        if (itemExists(itemIdentifier)){
            return new Item(itemList.get(itemIdentifier), itemIdentifier, quantity);
        }
        return null;
    }

    private void addItems(){
        itemList.put("Broccoli", new ItemData(new Amount(20), "Broccoli", new Amount(10)));
        itemList.put("Beef", new ItemData(new Amount(30), "Beef", new Amount(15)));
        itemList.put("Honey", new ItemData(new Amount(42), "Honey", new Amount(20)));
        itemList.put("Potatoes", new ItemData(new Amount(5), "Potatoes", new Amount(2)));
    }
}
