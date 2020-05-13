package se.kth.iv1350.amazingpos.model;

public interface RegisterObserver {
    /**
     * Updates the payment whenever it's made
     * @param total   The total amount
     */
    void newPayment(SaleTotal total);
}
