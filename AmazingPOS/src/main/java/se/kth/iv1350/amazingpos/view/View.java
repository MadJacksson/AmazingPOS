package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.controller.SearchFailedException;
import se.kth.iv1350.amazingpos.integration.AddItemException;
import se.kth.iv1350.amazingpos.integration.Item;
import se.kth.iv1350.amazingpos.integration.NoDatabaseException;
import se.kth.iv1350.amazingpos.util.Amount;
import se.kth.iv1350.amazingpos.util.LogHandler;

import java.io.IOException;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in the controller.
 */
public class View {
    private Controller contr;
    private ErrorMessageHandler errorMessageHandler = ErrorMessageHandler.getErrorMessageHandler();
    private LogHandler logHandler = new LogHandler();

    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) throws IOException {
        this.contr = contr;
        contr.addObserver(new TotalRevenueView());
    }

    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution() throws SearchFailedException, AddItemException, NoDatabaseException{
        for(int i = 0; i < 2; i++) {
            contr.startSale();
            System.out.println("A new sale has been started.");
            System.out.println("Cashier enter items. \n");
            registerItem("Broccoli", new Amount(1));
            registerItem("Beef", new Amount(4));
            registerItem("Broccoli", new Amount(5));
            registerItem("Honey", new Amount(20));
            registerItem("Potatoes", new Amount(2));
            registerItem("NonExistingItem", new Amount(5));
            String out;
            try {
                System.out.println("Cashier displays the total with VAT. \n");
                out = "Display total with VAT:" + contr.displayTotalWithVAT().toString();
                System.out.println(out);
            } catch (IllegalStateException exception) {
                handleException("Have to start a new sale first.", exception);
            }
            try {
                System.out.println("Cashier enters the paid amount. \n");
                out = "Change: " + contr.pay(new Amount(2000)).toString();
                System.out.println(out);
            } catch (IllegalStateException exception) {
                handleException("Have to start a new sale first.", exception);
            }
        }
    }
    /**
     *
     * @param itemIdentifier
     * @param amount
     * @return
     */
    private void registerItem(String itemIdentifier, Amount amount) {
        Item saleItem;
        try {
            saleItem = contr.registerItem(itemIdentifier, amount);
            String out = (saleItem).getItemDescription().toString() + "Item Amount: " + saleItem.getItemAmount().toString() + " Total: " + contr.displayTotal().toString();
            System.out.println(out);
        }
        catch (SearchFailedException exc) {
            handleException("The system failed to register item, please try again.", exc);
        }
        catch (IllegalStateException exc){
            handleException("Have to start new sale.", exc);
        }
        catch (AddItemException exc) {
            handleException("Specified item does not exist", exc);
        }
        catch (NoDatabaseException exc) {
            handleException("No connection to Server", exc);
        }
    }

    private void handleException(String message, Exception exception){
        errorMessageHandler.showErrorMsg(message);
        logHandler.logException(exception);
    }
 }
