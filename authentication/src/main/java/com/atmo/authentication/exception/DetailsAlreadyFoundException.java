package com.atmo.authentication.exception;

import com.atmo.exception.CustomException;

/**
 * <p>
 * When the details already exist in the database, this exception occurs.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class DetailsAlreadyFoundException extends CustomException {

    /**
     * <p>
     * Constructs a DetailsAlreadyFoundException with the message.
     * </p>
     *
     * @param message a detail message occurs when RecordNotFoundException is thrown
     */
    public DetailsAlreadyFoundException(String message) {
        super(message);
    }
}

