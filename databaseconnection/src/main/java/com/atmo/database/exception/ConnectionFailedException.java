package com.atmo.database.exception;

import com.atmo.exception.CustomException;

/**
 * <p>
 *     Exception occurs when it is failed to connect the database.
 * </p>
 *
 * @author Thangalakshmi S
 * @version 1.0
 * @see com.atmo.exception.CustomException
 */
public class ConnectionFailedException extends CustomException {

    /**
     * <p>
     *     Constructs a ConnectionFailedException with the message.
     * </p>
     *
     * @param message a detail message occurs when the ConnectionFailedException is thrown
     */
    public ConnectionFailedException(String message) {
        super(message);
    }
}
