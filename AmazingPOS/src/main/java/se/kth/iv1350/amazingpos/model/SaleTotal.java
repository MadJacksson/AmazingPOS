package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.Item;
import se.kth.iv1350.amazingpos.util.Amount;

/**
 * Acts as the sale total amount with the VAT.
 */
public class SaleTotal {
    private Amount total;
    private Amount totalVAT;

    /**
     * An instance is created representing the sale total.
     */
    public SaleTotal() {
        this.total = new Amount(0);
        this.totalVAT = new Amount(0);
    }

    /**
     * @return Gives the value of total.
     */
    public Amount getSaleTotal() {
        return total;
    }

    /**
     * @return Gives the totalVAT.
     */
    Amount getTotalVAT() {
        return totalVAT;
    }

    /**
     * Adds the VAT to the total and returns it as a new {@link Amount}.
     * Plus is a mathematical class called from {@link Amount}.
     * @return Gives total with VAT.
     */
    public Amount getTotalWithVAT() {
        return total.plus(totalVAT);
    }

    /**
     * Item cost is added both in total and totalVAT, so the SaleTotal is updated.
     * @param item The info about the item and cost that is added to total.
     */
    void updateSaleTotal(Item item) {
        if(item == null) {
            return;
        }
        Amount itemAmount = item.getItemAmount();
        Amount itemCost = item.getItemDescription().getCost();
        Amount itemVAT = item.getItemDescription().getVATAmount();

        this.totalVAT = this.totalVAT.plus(itemAmount.multiply(itemVAT));
        this.total = this.total.plus(itemAmount.multiply(itemCost));
    }

    /**
     * Updates the total revenue with total and totalVAT
     * @param total  The total to be added
     */
    public void updateSaleTotal(SaleTotal total){
        this.total = this.total.plus(total.getSaleTotal());
        this.totalVAT = this.totalVAT.plus(total.getTotalVAT());
    }

}
