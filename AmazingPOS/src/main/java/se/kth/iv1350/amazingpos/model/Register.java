package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.util.Amount;

/**
 * Acts as a fake cash register.
 */
public class Register {
    private Amount balance;

    /**
     * An instance of register is created with a start of balance zero.
     */
    public Register() {
        this.balance = new Amount(0);
    }

    /**
     * @return Gives the value of balance.
     */
    public Amount getBalance() {
        return balance;
    }

    /**
     *  Updates balance with the customers payment.
     * @param payment The amount customer pays that will be added in the cash register.
     */
    public void addPayment(Payment payment) {
        balance = balance.plus(payment.getSaleTotal().getTotalWithVAT());
    }
}
