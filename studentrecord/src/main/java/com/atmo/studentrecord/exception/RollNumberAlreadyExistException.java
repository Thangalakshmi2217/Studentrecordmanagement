package com.atmo.studentrecord.exception;

import com.atmo.exception.CustomException;

/**
 * <p>
 * When the RollNumber already exists in the database, this exception occurs.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class RollNumberAlreadyExistException extends CustomException {

    /**
     * <p>
     * Constructs a RollNumberAlreadyExistException with the message
     * </p>
     *
     * @param message a detail message occurs when RollNumberAlreadyExistException is thrown
     */
    public RollNumberAlreadyExistException(String message) {
        super(message);
    }
}

