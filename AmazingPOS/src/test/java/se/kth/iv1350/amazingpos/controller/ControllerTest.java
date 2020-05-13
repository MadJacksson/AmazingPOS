package se.kth.iv1350.amazingpos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.integration.AddItemException;
import se.kth.iv1350.amazingpos.integration.BuildInventory;
import se.kth.iv1350.amazingpos.integration.BuildSystem;
import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
    private Controller ctrl;

    @BeforeEach
    public void setUp() {
        ctrl = new Controller(new BuildSystem(), new BuildInventory(), new Printer());
    }

    @AfterEach
    public void tearDown() {
        ctrl = null;
    }

    @Test
    public void registerItem() {
        ctrl.startSale();
        String itemName = "Potatoes";
        String itemID = "1";
        Amount cost = new Amount(30);
        Amount VATAmount = new Amount(5);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + cost + "\t" +
                    "| VAT amount: " + VATAmount +
                    " |  Item Amount: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(30) + "\n" +
                    "VAT: " + new Amount(5) + "\n";
            System.out.println(expectedResult);
            assertEquals(expectedResult, actualResult);
        } catch (SearchFailedException exc) {

        } catch (AddItemException exc) {

        }
    }

    @Test
    public void registerNullItem() {

        String itemName = "Honey";
        String itemID = "1";
        Amount cost = new Amount(40);
        Amount VATAmount = new Amount(15);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + cost + "\t" +
                    "| VAT amount: " + VATAmount +
                    " |  Item Amount: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(40) + "\n" +
                    "VAT: " + new Amount(15) + "\n";
            System.out.println(expectedResult);
            assertEquals(expectedResult, actualResult);
        } catch (SearchFailedException exc) {

        } catch (AddItemException exc) {

        } catch (IllegalStateException exc) {
            assertTrue(exc.getMessage().equals("Call to registerItem was made before initiating a new sale."));
        }
    }

    @Test
    public void registerEmptyIdItem() {
        ctrl.startSale();
        String itemName = "Honey";
        String itemID = "";
        Amount cost = new Amount(40);
        Amount VATAmount = new Amount(15);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + cost + "\t" +
                    "| VAT amount: " + VATAmount +
                    " |  Item Amount: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(40) + "\n" +
                    "VAT: " + new Amount(15) + "\n";
            System.out.println(expectedResult);

        } catch (SearchFailedException exc) {

        } catch (AddItemException exc) {
            assertTrue(exc.getMessage().equals("Given item identifier: , was not found."));

        }
    }

    /**
     *
     * @throws SearchFailedException
     */
    @Test
    public void registerUnknownItem() throws SearchFailedException {
        ctrl.startSale();
        String itemName = "Honey";
        String itemID = "6";
        Amount cost = new Amount(40);
        Amount VATAmount = new Amount(15);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + cost + "\t" +
                    "| VAT amount: " + VATAmount +
                    " |  Item Amount: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(40) + "\n" +
                    "VAT: " + new Amount(15) + "\n";
            System.out.println(expectedResult);

        } catch (AddItemException exc) {
            assertTrue(exc.getMessage().equals("Given item identifier: 6, was not found."));
        }
    }
    @Test
    public void registerItemWithoutConnection() throws AddItemException {
        ctrl.startSale();
        String itemName = "Honey";
        String itemID = "5";
        Amount cost = new Amount(40);
        Amount VATAmount = new Amount(15);
        try {
            String actualResult = ctrl.registerItem(itemID, new Amount(1)).toString();
            System.out.println(actualResult);
            String expectedResult = "Item name: " + itemName + "\t" +
                    "| Price: " + cost + "\t" +
                    "| VAT amount: " + VATAmount +
                    " |  Item Amount: " + new Amount(1) + "\n" +
                    "Total: " + new Amount(40) + "\n" +
                    "VAT: " + new Amount(15) + "\n";
            System.out.println(expectedResult);

        } catch (SearchFailedException exc) {
            assertTrue(exc.getMessage().equals("Could not retrieve the item."));
        }
    }

}