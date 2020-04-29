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
        itemList.put("Tomat", new ItemData(new Amount(20), "Tomat", new Amount(10)));
        itemList.put("Gurka", new ItemData(new Amount(30), "Gurka", new Amount(15)));
        itemList.put("Apelsin", new ItemData(new Amount(42), "Apelsin", new Amount(20)));
        itemList.put("Paprika", new ItemData(new Amount(5), "Paprika", new Amount(2)));
    }
}
