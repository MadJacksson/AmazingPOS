package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.SaleTotal;
import se.kth.iv1350.amazingpos.util.Amount;

/**
 * Acts as an Item
 */
public class Item extends SaleTotal {
    private ItemData itemDescription;
    private String itemIdentifier;
    private Amount itemAmount;

    /**
     * This instance acts as an item.
     * @param itemDescription Description of item.
     * @param itemIdentifier Identifier of item.
     * @param itemAmount Amount of item.
     */
    public Item(ItemData itemDescription, String itemIdentifier, Amount itemAmount) {
        this.itemDescription = itemDescription;
        this.itemIdentifier = itemIdentifier;
        this.itemAmount = itemAmount;
    }

    /**
     * Will increase the amount of items with the specified {@link Amount}.
     * @param otherItemAmount The {@link Amount} will be added to itemAmount.
     */
    public void increaseItemAmount(Amount otherItemAmount) {
        this.itemAmount = this.itemAmount.plus(otherItemAmount);
    }

    /**
     * @return Gives the value of itemAmount.
     */
    public Amount getItemAmount() {
        return itemAmount;
    }

    /**
     * @return Gives the value of itemDescription.
     */
    public ItemData getItemDescription() {
        return itemDescription;
    }

    /**
     * @return Gives the value of itemIdentifier.
     */
    public String getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * @return Gives the instance as a <code>String</code>
     */
    public String toString() {
        String result = ("item identifier: " + itemIdentifier) +
                "amount of items: " + itemAmount +
                "item description: " + itemDescription.toString();
        return result;
    }

    /**
     * Two <code>Item</code> instances are equal if all fields are equal except itemAmount.
     * @param object The <code>Item</code> to compare with this <code>Item</code>.
     * @return <code>true</code> if all fields in the specified <code>Item</code> are equal to
     * corresponding fields in this <code>Item</code> except quantity, <code>false</code> if they are not.
     */
    public boolean equals(Object object) {
        if (object == null){
            return false;
        }
        if (getClass() != object.getClass()){
            return false;
        }
        Item other = (Item) object;
        if (!this.itemDescription.equals(other.itemDescription)){
            return false;
        }
        return this.itemIdentifier.equals(other.itemIdentifier);
    }

    /**
     * Will decrease the itemAmount of items with the specified {@link Amount}
     * @param otherItemAmount The {@link Amount} that will be subtracted to the itemAmount.
     */
    void decreaseItemAmount(Amount otherItemAmount){
        this.itemAmount = this.itemAmount.minus(otherItemAmount);
    }
}
