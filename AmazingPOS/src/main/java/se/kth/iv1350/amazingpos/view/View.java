package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.util.Amount;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in the controller.
 */
public class View {
    private Controller contr;
    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution() {
        contr.startSale();
        System.out.println("A new sale has been started.");
        System.out.println("Cashier enter items. \n");
        String out = contr.registerItem("Broccoli", new Amount(1));
        System.out.println(out);
        out = contr.registerItem("Beef", new Amount(4));
        System.out.println(out);
        out = contr.registerItem("Broccoli", new Amount(5));
        System.out.println(out);
        out = contr.registerItem("Honey", new Amount(20));
        System.out.println(out);
        out = contr.registerItem("Potatoes", new Amount(2));
        System.out.println(out);
        System.out.println("Cashier displays the total with VAT. \n");
        out = contr.displayTotalWithVAT();
        System.out.println(out);
        System.out.println("Cashier enters the paid amount. \n");
        out = contr.pay(new Amount(2000));
        System.out.println(out);
    }
}
