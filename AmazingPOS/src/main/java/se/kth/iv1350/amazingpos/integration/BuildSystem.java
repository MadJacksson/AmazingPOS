package se.kth.iv1350.amazingpos.integration;

/**
 * A object that initiates the systems needed for the application,
 * external accounting system and external inventory system.
 */
public class BuildSystem {
    private static final BuildSystem BUILD_SYSTEM = new BuildSystem();
    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;

    /**
     * Creates the system builder and all it's new instances.
     */
    public BuildSystem(){
        accountingSystem = new ExternalAccountingSystem();
        inventorySystem = new ExternalInventorySystem();
    }

    public static BuildSystem getBuildSystem() {
        return BUILD_SYSTEM;
    }

    /**
     * @return Gives the value of the accountingSystem.
     */
    public ExternalAccountingSystem getAccountingSystem() {
        return accountingSystem;
    }
    /**
     * @return Gives the value of the inventorySystem.
     */
    public ExternalInventorySystem getInventorySystem() {
        return inventorySystem;
    }
}
