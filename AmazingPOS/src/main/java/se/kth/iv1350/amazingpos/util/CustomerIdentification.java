package se.kth.iv1350.amazingpos.util;

import java.util.Objects;

/**
 * Act as the identification of a customer.
 */
public class CustomerIdentification {
    private String customerIDNr;

    /**
     * An instance is created that acts as the customer ID that we need.
     * @param customerIDNr The identification number represented by the newly created instance.
     */
    public CustomerIdentification(String customerIDNr){
        this.customerIDNr = customerIDNr;
    }

    /**
     * @return Gives the costumerIDNR value.
     */
    public String getCustomerIDNR() {
        return customerIDNr;
    }

    /**
     * Control if the instances are equal
     * @param object Other instance
     * @return <code>true</code> if all attributes are the same, the same class and if it is not null, if not return <code>false</code>
     */
    public boolean equals(Object object) {
        if (object == null){
            return false;
        }
        if (getClass() != object.getClass()){
            return false;
        }
        final CustomerIdentification other = (CustomerIdentification) object;
        if (!Objects.equals(this.customerIDNr, other.customerIDNr)) {
            return false;
        }
        return true;
    }

}
