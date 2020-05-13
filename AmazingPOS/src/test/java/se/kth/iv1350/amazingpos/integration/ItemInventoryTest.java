package se.kth.iv1350.amazingpos.integration;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.jupiter.api.Assertions.*;

public class ItemInventoryTest {

    @Test
    void testItemInventory() {
        String item = "Honey";
        ItemInventory itemInventory = new ItemInventory();
        boolean result = itemInventory.itemExists(item);
        assertTrue(result);
    }
    @Test
    public void testItemNotExists() {
        String a = "NonExistingItem";
        ItemInventory itemInventory = new ItemInventory();
        try {
            itemInventory.getItem(a, new Amount(1));
        } catch (AddItemException exc) {
            System.out.println("Given item identifier: NonExistingItem, was not found.");
        } catch (NoDatabaseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testItemExistsWithNullString() {
        String a = null;
        ItemInventory itemInventory = new ItemInventory();
        try {
            itemInventory.getItem(a, new Amount(1));
        } catch (AddItemException | NoDatabaseException exc) {
            System.out.println("Given item identifier: null, was not found.");
        }
    }
    @Test
    public void testItemExistsWhileConnectionIsDown() {
        String a = "Honey";
        ItemInventory itemInventory = new ItemInventory();
        try {
            itemInventory.getItem(a, new Amount(1));
        } catch (NoDatabaseException exc) {
            System.out.println("No connection to server.");
        } catch (AddItemException exc) {

        }
    }
}
