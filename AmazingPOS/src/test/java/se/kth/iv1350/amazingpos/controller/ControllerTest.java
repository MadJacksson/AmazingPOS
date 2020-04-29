package se.kth.iv1350.amazingpos.controller;


import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.Assert.assertEquals;

class ControllerTest {
    private Controller controller;

    ControllerTest(Controller controller) {
        this.controller = controller;
    }
/*
    @Before
    void setUp() {
        controller = new Controller(new BuildSystem(), new BuildInventory(), new Printer());
    }

    @After
    void tearDown() {
        controller = null;
    } */

    @Test
    void registerItem() {
        controller.startSale();
        String itemName = "Tomat";
        Amount cost = new Amount(20);
        Amount VATAmount = new Amount(10);
        String actualResult = controller.registerItem(itemName, new Amount(1));
        String expectedResult = "item name: " + itemName + "\t" +
                "cost: " + cost + "\t" +
                "VAT amount: " + VATAmount + "\t" +
                ", Amount: " + new Amount(1) + ", running total: " + cost;
        assertEquals("String from registerItem is not the same as String with the same state.", expectedResult, actualResult);
    }

    @Test
    void displayTotalWithTax() {
        controller.startSale();
        String itemName = "Tomat";
        Amount cost = new Amount(20);
        Amount VATAmount = new Amount(10);
        controller.registerItem(itemName, new Amount(1));
        String actualResult = controller.displayTotalWithVAT();
        String expectedResult = "total with VAT: " + cost.plus(VATAmount);
        assertEquals("The total with VAT from sale is not equal to the expected result.", expectedResult, actualResult);
    }

    @Test
    void pay() {
        controller.startSale();
        String itemName = "Tomat";
        Amount cost = new Amount(20);
        Amount VATAmount = new Amount(10);
        controller.registerItem(itemName, new Amount(1));
        Amount paidAmount = new Amount(40);
        String expectedResult = "Change: " + paidAmount.minus(cost.plus(VATAmount));
        String actualResult = controller.pay(paidAmount);
        assertEquals("Change is not equal to amount with the same amount.", expectedResult, actualResult);
    }
}