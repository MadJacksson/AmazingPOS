package se.kth.iv1350.amazingpos.integration;

public class NoDatabaseException extends RuntimeException{
    /**
     * Creates a new instance representing the condition described in the specified message.
     *
     * @param message A message that describes what went wrong.
     */
    public NoDatabaseException(String message){
        super(message);
    }
}
