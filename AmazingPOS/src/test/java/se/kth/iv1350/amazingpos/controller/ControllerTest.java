package se.kth.iv1350.amazingpos.controller;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.integration.BuildInventory;
import se.kth.iv1350.amazingpos.integration.BuildSystem;
import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.Assert.assertEquals;

class ControllerTest {
    private Controller controller;

    ControllerTest(Controller controller) {
        this.controller = controller;
    }

    @Before
    public void setUp() {
        controller = new Controller(new BuildSystem(), new BuildInventory(), new Printer());
    }

    @After
    public void tearDown() {
        controller = null;
    }

    @Test
    void registerItem() {
        controller.startSale();
        String itemName = "Potatoes";
        Amount cost = new Amount(30);
        Amount VATAmount = new Amount(5);
        String actualResult = controller.registerItem(itemName, new Amount(1));
        String expectedResult = "item name: " + itemName + "\t" +
                "cost: " + cost + "\t" +
                "VAT amount: " + VATAmount + "\t" +
                ", Amount: " + new Amount(1) + ", total cost: " + new Amount(55);
        assertEquals("String from registerItem is not the same as String with the same state.", expectedResult, actualResult);
    }
}