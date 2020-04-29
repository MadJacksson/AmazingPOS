package se.kth.iv1350.amazingpos.startup;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.BuildInventory;
import se.kth.iv1350.amazingpos.integration.BuildSystem;
import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.view.View;

/**
 * Starts the entire application, contains the main method used to start the application.
 */
public class Main {
    /**
     * The main method used to start the entire application.
     *
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        BuildSystem buildSystem = BuildSystem.getBuildSystem();
        BuildInventory buildInventory = BuildInventory.getBuildInventory();
        Printer printer = Printer.getPrinter();
        Controller contr = new Controller(buildSystem, buildInventory, printer);
        View view = new View(contr);
        view.runFakeExecution();
    }
}
