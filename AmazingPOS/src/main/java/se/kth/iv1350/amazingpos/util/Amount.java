package se.kth.iv1350.amazingpos.util;

import java.util.Objects;

/**
 * The amount of items, money or discounts. Just acts as the number of something.
 */
public class Amount {
    private double amount;

    /**
     * An Instance is created to appear as the specified amount
     * @param amount
     */
    public Amount(double amount) {
        this.amount = amount;
    }

    /**
     * @return Gives the amount value
     */
    public double getAmount() {
        return amount;
    }

    /**
     *
     * @return Gives us a converted <code>Amount</code> into a <code>String</code>
     */
    public String toString() {
        return Integer.toString((int) amount);
    }

    /**
     * Confirms if the specific and this amount are equal.
     * @param object The specific amount
     * @return Gives us <code>false</code> if it's not the same object, class or amount,
     * if it is the same then it returns <code>true</code>.
     */
    public boolean equals(Object object){
        if(object == null) {
            return false;
        }
        if(getClass() != object.getClass()) {
            return false;
        }
        Amount other;
        other = (Amount) object;
        return Objects.equals(this.amount, other.amount);
    }

    /**
     * Subtracts the specific <code>Amount</code>.
     * @param other The specific <code>Amount</code>
     * @return Gives The equivalent of the subtraction.
     */
    public Amount minus(Amount other) {
        return new Amount(this.amount - other.amount);
    }

    public Amount plus(Amount other) {
        return new Amount(this.amount + other.amount);
    }

    public Amount multiply(Amount other) {
        return new Amount(this.amount * other.amount);
    }
}
