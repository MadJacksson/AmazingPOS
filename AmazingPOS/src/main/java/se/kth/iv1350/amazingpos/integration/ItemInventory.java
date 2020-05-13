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

    /**
     * Gets the item description of the specified itemIdentifier.
     * Returns an item with the specified quantity.
     *
     * @param itemIdentifier The identifier of an item.
     * @param quantity The amount of items.
     * @return An item with it's itemDescription and quantity or null if the identifier didn't exist..
     * @throws AddItemException If the itemIdentifier doesn't exist
     * @throws NoDatabaseException If the database call failed.
     */
    public Item getItem(String itemIdentifier, Amount quantity) throws AddItemException, NoDatabaseException{
        if (!itemExists(itemIdentifier)){
            throw new AddItemException(itemIdentifier);
        }
        Item newItem = new Item(itemList.get(itemIdentifier), itemIdentifier, quantity);
        if (!newItem.getItemIdentifier().equals(itemIdentifier)){
            throw new NoDatabaseException("ItemId does not match");
        }
        if(newItem.getItemIdentifier().equals("Honey")){
            throw new NoDatabaseException("No connection to server.");
        }
        return newItem;
    }

    private void addItems(){
        itemList.put("Broccoli", new ItemData(new Amount(20), "Broccoli", new Amount(10)));
        itemList.put("Beef", new ItemData(new Amount(30), "Beef", new Amount(15)));
        itemList.put("Honey", new ItemData(new Amount(42), "Honey", new Amount(20)));
        itemList.put("Potatoes", new ItemData(new Amount(5), "Potatoes", new Amount(2)));
    }
}
