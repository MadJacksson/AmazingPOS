package se.kth.iv1350.amazingpos.integration;

/**
 * Acts as a builder for all the inventory's where creating.
 */
public class BuildInventory {
    private static final BuildInventory BUILD_INVENTORY = new BuildInventory();
    private DiscountInventory discountInventory;
    private ItemInventory itemInventory;

    /**
     * A new instance is created
     */
    public BuildInventory(){
        discountInventory = new DiscountInventory();
        itemInventory = new ItemInventory();
    }

    public static BuildInventory getBuildInventory() {
        return BUILD_INVENTORY;
    }

    /**
     * @return Gives the value of discountInventory.
     */
    public DiscountInventory getDiscountInventory() {
        return discountInventory;
    }

    /**
     * @return Gives the value of itemInventory
     */
    public ItemInventory getItemInventory() {
        return itemInventory;
    }

}
