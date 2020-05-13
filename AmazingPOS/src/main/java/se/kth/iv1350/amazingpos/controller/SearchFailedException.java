package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.integration.NoDatabaseException;

/**
 * Searches failed exception and returns message and cause
 */
public class SearchFailedException extends Exception{
    public SearchFailedException(String message, NoDatabaseException cause) {
        super(message, cause);
    }
}
