package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.model.RegisterObserver;
import se.kth.iv1350.amazingpos.model.SaleTotal;

public class TotalRevenueView implements RegisterObserver{
    private SaleTotal totalRevenue;

    TotalRevenueView(){
        totalRevenue = new SaleTotal();
    }

    /**
     * Updates the total revenue
     * @param total    The total amount
     */
    @Override
    public void newPayment(SaleTotal total) {
        totalRevenue.updateSaleTotal(total);
        printCurrentRevenue();
    }

    private void printCurrentRevenue(){
        System.out.println("-------TOTAL-REVENUE------\n");
        System.out.println("   Amount: " + totalRevenue.getTotalWithVAT().toString());
        System.out.println("--------------------------\n");
    }

}
