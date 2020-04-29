package se.kth.iv1350.amazingpos.model;

import java.time.LocalDateTime;

/**
 * Represents one receipt, which proves the payment of one sale.
 */
public class Receipt {
    private Sale sale;

    /**
     * A receipt represented by creating a instance.
     * @param sale Is the information that will be printed on the receipt.
     */

    public Receipt(Sale sale) {
        this.sale = sale;
    }

    /**
     * Makes it to a String.
     * @return The instance as a <code>String</code>.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("/n*******RECEIPT*******/n");
        addLocalDate(result);
        result.append("/nITEMS: /n");
        result.append(sale.toString());
        return result.toString();
    }

    private void addLocalDate(StringBuilder result) {
        LocalDateTime saleTime = LocalDateTime.now();
        result.append("/nSALE TIME: ").append(saleTime.toLocalDate().toString());
    }

}
