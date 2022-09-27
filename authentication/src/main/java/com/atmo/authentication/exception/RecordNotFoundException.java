package com.atmo.authentication.exception;

import com.atmo.exception.CustomException;

/**
 * <p>
 * When it is failed to found the student records, this exception occurs.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class RecordNotFoundException extends CustomException {

    /**
     * <p>
     * Constructs a RecordNotFoundException with the message.
     * </p>
     *
     * @param message a detail message occurs when RecordNotFoundException is thrown
     */
    public RecordNotFoundException(String message) {
        super(message);
    }
}

