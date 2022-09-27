package com.atmo.validate.exception;

import com.atmo.exception.CustomException;

/**
 * <p>
 * When the given date is invalid, this exception occurs.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 * @see com.atmo.exception.CustomException
 */
public class DateNotValidException extends CustomException {

    /**
     * <p>
     * Constructs a DateNotValidException with the message.
     * </p>
     *
     * @param message a detailed message occurs when the DateNotValidException is thrown
     */
    public DateNotValidException(String message) {
        super(message);
    }
}

