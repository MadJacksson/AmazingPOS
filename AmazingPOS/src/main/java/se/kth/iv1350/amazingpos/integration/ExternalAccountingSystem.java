package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Sale;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Acts as a real accounting system.
 */
public class ExternalAccountingSystem {
    private HashMap<LocalDateTime, Sale> accounting = new HashMap();

    ExternalAccountingSystem(){
        /**
         * Pretends to be a real system, some code here.
         */
    }

    /**
     * Updates the sale, and adds the sale time when it's finished.
     * @param sale Is the finished sale that is updated.
     */
    public void updateAccounting(Sale sale){
        LocalDateTime saleTime = LocalDateTime.now();
        accounting.put(saleTime, sale);
    }
}
