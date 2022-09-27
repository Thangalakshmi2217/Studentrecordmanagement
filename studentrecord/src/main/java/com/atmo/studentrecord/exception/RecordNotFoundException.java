package com.atmo.studentrecord.exception;

import com.atmo.exception.CustomException;

/**
 * <p>
 * When it is failed to found the student records, this exception occurs.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 * @see com.atmo.exception.CustomException
 */
public class RecordNotFoundException extends CustomException {

    /**
     * <p>
     * Constructs a RecordNotFoundException with the message
     * </P>
     *
     * @param message a detail message occurs when RecordNotFoundException is thrown
     */
    public RecordNotFoundException(String message) {
        super(message);
    }
}

