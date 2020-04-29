package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.model.Payment;
import se.kth.iv1350.amazingpos.model.Receipt;
import se.kth.iv1350.amazingpos.model.Register;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.util.Amount;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 * The application start by order as which a sale would in reality, or else it will not
 * function correctly. A new sale starts in startSale(), and then we move on to registerItem()
 * and displayTotalWithVAT(). We conclude the program with the class pay() that ends the sale.
 */
public class Controller {
    private Sale sale;
    private Register cashRegister;
    private Printer printer;
    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;
    private ItemInventory itemInventory;
    /**
     * Controller is represented by creating a new instance
     * @param buildSystem Handles the external system calls
     * @param buildInventory Handles all the database calls
     * @param printer A printer interface
     */
    public Controller(BuildSystem buildSystem, BuildInventory buildInventory, Printer printer) {
        this.accountingSystem = buildSystem.getAccountingSystem();
        this.inventorySystem = buildSystem.getInventorySystem();
        this.itemInventory = buildInventory.getItemInventory();
        this.printer = printer;
        this.cashRegister = new Register();
    }

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale() {
        sale = new Sale();
    }
    /**
     * If the item exists it is added to the sale while the application returns information
     * about the item, and it's total.
     * @param itemIdentifier Has the item we are looking for
     * @param amount The item amount
     * @return Returns the information about the item and it's cost, else it returns
     * just the "running total: ".
     */
    public String registerItem(String itemIdentifier, Amount amount) {
        if (itemInventory.itemExists(itemIdentifier)) {
            Item item = itemInventory.getItem(itemIdentifier, amount);
            return sale.updateSale(item) + ", amount of items: " + amount.toString() +
                    ", running total: " + displayTotal();
        }
        return "running total: " + displayTotal();
    }
    /**
     * Display total with the VAT
     * @return Prints "Total with VAT" and the total with VAT
     */
    public String displayTotalWithVAT() {
        return "Total with VAT: " + sale.getSaleTotal().getTotalWithVAT().toString();
    }

    private String displayTotal() {
        return sale.getSaleTotal().getSaleTotal().toString();
    }
    /**
     * Ends the program by with payment and will be added to the balance in the cashregister.
     * External system get's updated and we will recieve a receipt.
     * @param paidAmount Amount paid by the customer
     * @return Change that is left after the payment
     */
    public String pay(Amount paidAmount) {
        Payment payment = new Payment(paidAmount, sale.getSaleTotal());
        //cashRegister.addPayment(payment);
        accountingSystem.updateAccounting(sale);
        inventorySystem.updateInventory(sale);
        Receipt receipt = new Receipt(sale, payment);
        printer.printReceipt(receipt);
        sale = null;
        return "Change: " + payment.getChange().toString();
    }
}
