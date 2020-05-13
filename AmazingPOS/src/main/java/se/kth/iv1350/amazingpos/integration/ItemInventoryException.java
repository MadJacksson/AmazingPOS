package se.kth.iv1350.amazingpos.integration;

public class ItemInventoryException extends Exception{
    /**
     * Creates a new instance representing the condition described in the specified message.
     *
     * @param message A message that describes what went wrong.
     */
    public ItemInventoryException(String message){
        super(message);
    }
}
