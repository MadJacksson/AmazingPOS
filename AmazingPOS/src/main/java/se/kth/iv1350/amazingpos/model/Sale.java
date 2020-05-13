package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.Item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    private SaleTotal total;
    private HashMap<String, Item> items = new HashMap<>();
    /**
     * Creates a new instance and represents the sale.
     */
    public Sale() {
        this.total = new SaleTotal();
    }

    /**
     * @return Gives us value of total.
     */
    public SaleTotal getSaleTotal() {
        return total;
    }

    /**
     * @return Gives us the HashMap items.
     */
    public HashMap<String, Item> getItems() {
        return items;
    }

    /**
     * Updates the sale on how many items it has and the total of the sale, does not accept null.
     * @param item Will be added on the sale.
     * @return The <code>itemDescription</code> is given as a string.
     */
    public void updateSale(Item item) {
        if(itemListContains(item)) {
            updateItemAmountAndTotal(item);
        }
        else {
            addItemAndUpdateTotal(item);
        }
    }

    /**
     * @return containsKey in the HashMap.
     */
    private boolean itemListContains(Item item) {
        return items.containsKey(item.getItemIdentifier());
    }

    private void updateItemAmountAndTotal(Item item){
        Item oldItem = items.get(item.getItemIdentifier());
        oldItem.increaseItemAmount(item.getItemAmount());
        items.put(oldItem.getItemIdentifier(), oldItem);
        total.updateSaleTotal(item);
    }

    private void addItemAndUpdateTotal(Item item) {
        items.put(item.getItemIdentifier(), item);
        total.updateSaleTotal(item);
    }

    /**
     * @return <code>String</code> is given as a instance.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator entriesIterator = getEntries();

        while(entriesIterator.hasNext()) {
            Item item = getCurrentItem(entriesIterator);
            builder.append(item.getItemDescription().toString());
            addNewLine(builder, " quantity: " + item.getItemAmount().toString());
        }
        addNewLine(builder, "Total: " + total.getSaleTotal().toString());
        addNewLine(builder, "Tax: " + total.getTotalVAT());
        return builder.toString();
    }

    private Iterator getEntries(){
        Set entries = items.entrySet();
        return entries.iterator();
    }

    private Item getCurrentItem(Iterator entriesIterator){
        Map.Entry mapping = (Map.Entry) entriesIterator.next();
        return (Item) mapping.getValue();
    }

    private void addNewLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }

}
