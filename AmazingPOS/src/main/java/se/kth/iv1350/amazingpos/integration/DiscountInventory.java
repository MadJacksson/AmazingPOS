package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.util.AddDiscount;
import se.kth.iv1350.amazingpos.util.CustomerIdentification;

import java.util.HashMap;

/**
 * Acts as the discount database.
 */
public class DiscountInventory {
    private HashMap<CustomerIdentification, AddDiscount> discounts = new HashMap<>();
    private final double NO_DISCOUNT = 1.0;

    /**
     * Discount database is created by and instance.
     */
    DiscountInventory(){
        addCustomerAndTheirDiscounts();
    }

    /**
     * By checking the customers ID we can conclude if they have a discount or not.
     * @param ID The customers identification
     * @return Gives the discount if the customer exists in the database, else if they don't
     * it returns <code>NO_DISCOUNT_RATE</code>.
     */
    public AddDiscount lookForDiscount(CustomerIdentification ID){
        if (discounts.containsKey(ID)){
            return discounts.get(ID);
        }
        return new AddDiscount(NO_DISCOUNT);
    }

    private void addCustomerAndTheirDiscounts(){
        discounts.put(new CustomerIdentification("00001"), new AddDiscount(0.4));
        discounts.put(new CustomerIdentification("00002"), new AddDiscount(0.6));
    }

}
