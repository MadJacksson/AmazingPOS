package se.kth.iv1350.amazingpos.util;

/**
 * Acts as a requirements applied to a standard discount.
 */
public class AddDiscount {
    private double discount;

    /**
     * Acts as the requirements in the discount.
     * @param discountRate The discount rate represented by the newly created instance.
     */
    public AddDiscount(double discountRate){
        this.discount = discount;
    }

    /**
     * An instance is created to represent the rate at 1.0.
     */
    public AddDiscount(){
        double NO_DISCOUNT = 1.0;
        this.discount = NO_DISCOUNT;
    }

    /**
     * @return gives the discount value.
     */
    public double getDiscount() {
        return discount;
    }
}
