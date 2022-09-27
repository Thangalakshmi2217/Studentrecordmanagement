package com.atmo.authentication.view;

/**
 * <p>
 * Validation of user choices.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class Validation {

    /**
     * <p>
     * Validates the choice of the users.
     * </p>
     *
     * @param choice includes Name, Email, password and RollNumber
     * @return true when the choice matches the pattern
     */
    public static boolean validateChoice(String choice) {
        return choice.matches("[1-4]") ? true : false;
    }
}
