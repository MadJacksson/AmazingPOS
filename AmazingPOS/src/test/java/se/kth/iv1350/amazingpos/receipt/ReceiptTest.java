package se.kth.iv1350.amazingpos.receipt;

import org.junit.Test;
import se.kth.iv1350.amazingpos.integration.Item;
import se.kth.iv1350.amazingpos.integration.ItemData;
import se.kth.iv1350.amazingpos.model.Payment;
import se.kth.iv1350.amazingpos.model.Receipt;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.model.SaleTotal;
import se.kth.iv1350.amazingpos.util.Amount;

import java.time.LocalDateTime;

public class ReceiptTest {

    @Test
    public void testToString() {

        Amount cost = new Amount(20);
        Amount VAT = new Amount(5);
        String itemNameAndIdentifier = "Potatoes";
        ItemData itemDescription = new ItemData(cost, itemNameAndIdentifier, VAT);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Sale sale = new Sale();
        sale.updateSale(item);
        Payment payment = new Payment(new Amount(5), new SaleTotal());
        Receipt receipt = new Receipt(sale , payment);
        LocalDateTime saleTime = LocalDateTime.now();
        String expectedResult = "\n----------RECEIPT----------" +
                "\nSale time: " + saleTime.toLocalDate().toString() +
                "\nItems: " +
                "\nitem name: " + itemNameAndIdentifier + "\t" +
                "cost: " + cost + "\t" +
                "VAT amount: " + VAT + "\t" +
                " item amount: " + quantity + "\nTotal: " + cost + "\nVAT: " + VAT + "\n" +
                "\n------------END------------\n";
        String actualResult = receipt.toString();
        System.out.println(actualResult);
        System.out.println(expectedResult);
    }
}
