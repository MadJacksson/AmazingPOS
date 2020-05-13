package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.model.Payment;
import se.kth.iv1350.amazingpos.model.Receipt;
import se.kth.iv1350.amazingpos.model.RegisterObserver;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.util.Amount;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 * The application start by order as which a sale would in reality, or else it will not
 * function correctly. A new sale starts in startSale(), and then we move on to registerItem()
 * and displayTotalWithVAT(). We conclude the program with the class pay() that ends the sale.
 */
public class Controller {
    private Sale sale;
    private Printer printer;
    private ExternalInventorySystem inventorySystem;
    private ItemInventory itemInventory;
    private ExternalAccountingSystem accountingSystem;
    private List<RegisterObserver> registerObservers = new ArrayList<>();

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
    public void startSale() {
        sale = new Sale();
    }

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
    }


    /**
     * If the item exists it is added to the sale while the application returns information
     * about the item, and it's total.
     * @param itemIdentifier Has the item we are looking for
     * @param amount The item amount
     * @return Returns the information about the item and it's cost, else it returns
     * just the "running total: ".
     *  @throws AddItemException          Thrown if item can't be found
     * 	@throws SearchFailedException Thrown if item couldn't be retrieved in any other way
     */
    public Item registerItem(String itemIdentifier, Amount amount) throws AddItemException, SearchFailedException, NoDatabaseException{
        checkIfNewSaleStarted("registerItem");
        checkIfNewSaleStarted("registerItem");
        Item item = itemInventory.getItem(itemIdentifier, amount);
        sale.updateSale(item);
        return item;
    }
    /**
     * Display total with the VAT
     * @return Prints "Total with VAT" and the total with VAT
     */
    public Amount displayTotalWithVAT() {
        return sale.getSaleTotal().getTotalWithVAT();
    }

    public Amount displayTotal(){
        return sale.getSaleTotal().getSaleTotal();
    }
    /**
     * Ends the program by with payment and will be added to the balance in the cashregister.
     * External system get's updated and we will recieve a receipt.
     * @param paidAmount Amount paid by the customer
     * @return Change that is left after the payment
     */
    public Amount pay(Amount paidAmount){
        Payment payment = new Payment(paidAmount, sale.getSaleTotal());
        payment.addObservers(registerObservers);
        accountingSystem.updateAccounting(sale);
        inventorySystem.updateInventory(sale);
        Receipt receipt = new Receipt(sale, payment);
        printer.printReceipt(receipt);
        sale = null;
        return payment.getChange();
    }

    /**
     * Adds observer that notifies when payment occurs
     * @param obs The observer
     */
    public void addObserver(RegisterObserver obs){
        registerObservers.add(obs);
    }

    /**
     * Ends the sale
     * @return     The total price as a string
     */
    private void checkIfNewSaleStarted(String method) {
        if (sale == null) {
            throw new IllegalStateException("Call to " + method + " was made before initiating a new sale.");
        }
    }

}
