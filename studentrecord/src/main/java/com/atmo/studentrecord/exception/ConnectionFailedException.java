package com.atmo.studentrecord.exception;

import com.atmo.exception.CustomException;

/**
 * <p>
 * When it is failed to connect the student record in the database, this exception occurs.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 * @see com.atmo.exception.CustomException
 */
public class ConnectionFailedException extends CustomException {

    /**
     * <p>
     * Constructs a ConnectionFailedException with the message
     * </p>
     *
     * @param message a detail message occurs when the ConnectionFailedException is thrown
     */
    public ConnectionFailedException(String message) {
        super(message);
    }
}
