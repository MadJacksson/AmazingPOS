package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.model.Receipt;

/**
 * Acts as a printer
 */
public class Printer {
    private static final Printer PRINTER = new Printer();

    public Printer() {
        /**
         * Pretends to be a printer, and does printer stuff
         */
    }

    /**
     * @return Gives the value of printer
     */
    public static Printer getPrinter() {
        return PRINTER;
    }

    /**
     * Prints the receipt after the sale (It's fake)
     * It prints to <code>System.out</code>, instead of a printer.
     * @param receipt The receipt that will be printed
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt.toString());
    }
}
