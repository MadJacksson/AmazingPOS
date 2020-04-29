package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.util.Amount;

/**
 * Acts as the payment from the customer in the sale.
 */
public class Payment {
    private Amount paidAmount;
    private SaleTotal total;

    /**
     * Payment is represented by creating a instance
     * @param paidAmount The amount the customer has payed
     * @param total The cost that the customer will pay
     */
    public Payment(Amount paidAmount, SaleTotal total) {
        this.paidAmount = paidAmount;
        this.total = total;
    }

    /**
     * @return Gives the total cost of the payment
     */
    SaleTotal getSaleTotal() {
        return total;
    }

    /**
     * Counts the amount of change the customer will get after the payment
     * @return The total change as {@link Amount}
     */
    public Amount getChange() {
        return (paidAmount.minus(total.getTotalWithVAT()));
    }
}
