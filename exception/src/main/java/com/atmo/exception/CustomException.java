package com.atmo.exception;

/**
 * <p>
 * Custom exception is a user-defined exception occurs when we create our own exception.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class CustomException extends RuntimeException {

    /**
     * <p>
     * Constructs an exception with a message.
     * </p>
     *
     * @param message a detail message occurs when an exception is thrown.
     */
    public CustomException(String message) {
        super(message);
    }
}