package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.util.Amount;

import java.util.Objects;

/**
 * Acts as the data of an item.
 */
public class ItemData {
    private Amount cost;
    private String itemName;
    private Amount VATAmount;

    /**
     * An instance is created to acts as a specific item.
     * @param cost The item cost.
     * @param itemName The name of the item.
     * @param VATAmount The VAT amount of the item.
     */
    ItemData(Amount cost, String itemName, Amount VATAmount){
        this.cost = cost;
        this.itemName = itemName;
        this.VATAmount = VATAmount;
    }

    /**
     * @return Gives the cost value.
     */
    public Amount getCost() {
        return cost;
    }

    /**
     * @return Gives the itemName value.
     */
    String getItemName() {
        return itemName;
    }

    /**
     * @return Gives the VATAmount value.
     */
    public Amount getVATAmount() {
        return VATAmount;
    }

    /**
     * @return Gives the instance that has been converted into a <code>String</code>
     */
    public String toString() {
        return "item name: " + itemName + "\t" +
                "Cost: " + cost + "\t" +
                "VAT: " + VATAmount + "\t";
    }

    /**
     * Two <code>ItemData</code> instances are equal if all fields are equal
     * @param object The <code>ItemData</code> to compare with this <code>ItemData</code>.
     * @return <code>true</code> if all fields in the specified <code>ItemData</code> are equal to
     * corresponding fields in this <code>ItemData</code>, <code>false</code> if they are not.
     */
    public boolean equals(Object object) {
        if (object == null){
            return false;
        }
        if (object.getClass() != getClass()){
            return false;
        }
        final ItemData other = (ItemData) object;
        if (!Objects.equals(this.cost, other.cost)){
            return false;
        }
        if (!this.itemName.equals(other.itemName)){
            return false;
        }
        return Objects.equals(this.VATAmount, other.VATAmount);
    }
}
