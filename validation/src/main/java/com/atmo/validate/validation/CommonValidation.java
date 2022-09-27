package com.atmo.validate.validation;

import com.atmo.validate.exception.DateNotValidException;

import java.time.LocalDate;

/**
 * <p>
 * Validates the user details.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class CommonValidation {

    /**
     * <p>
     * Validating the <b>Name</b> of the user.
     * </p>
     * <p>A Name is considered valid if the following constraints are satisfied.</p>
     * <li>1.Initial of the name should be in the Uppercase (A-Z) english letters.</li>
     * <li>2.Uppercase (A-Z) and lowercase (a-z) english letters</li>
     * <li>3.Name can contain white space characters</li>
     * <p>Example: S Thangalakshmi</p>
     *
     * @param name represents the name of the user
     * @return true when the name matches the pattern
     */
    public boolean validateName(final String name) {
        return name.matches("^[A-Z][A-Za-z+\\s]*$") ? true : false;
    }

    /**
     * <p>
     * Validating the <b>Email given by the user.</b>
     * </p>
     * <p>An emailId is considered valid if the following constraints are satisfied.</p>
     * <p>
     * 1)Personal info contains
     * <li>Uppercase (A-Z) and lowercase (a-z) English letters.</li>
     * <li>Digits (0-9).</li>
     * <li>Characters (-._@)</li>
     * 2)Domain name like: com, org, net, in, us and contain dots.
     * <p>Example: Twozotechnologiespvtltd@gmail.com</P>
     *
     * @param email represents the user's mail
     * @return true when the Email matches the pattern
     */
    public boolean validateEmail(final String email) {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]+$") ? true : false;
    }

    /**
     * <p>
     * Validating the <b>Password</b> given by the user.
     * </p>
     * <p>A Password is considered valid if the following constraints are satisfied.</p>
     * <Li>It must include at least one Uppercase (A-Z) English letter.</Li>
     * <li>It must include at least one lowercase letter.(a-z)</li>
     * <li>It must include at least one numeric digit.</li>
     * <li>It must contain at least 8 characters and not more than 12 characters.</li>
     * <p>Example: Sanmedia22</p>
     *
     * @param password represents the user's password.
     * @return true when the password matches the pattern
     */
    public boolean validatePassword(final String password) {
        return password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,12}") ? true : false;
    }

    /**
     * <p>
     * Validating the <b>Date</b>, whether this date is specified after the particular date
     * </p>
     *
     * @param dateOfBirth represents the exact date when the user was born
     * @return true if this date is after the specified date
     */
    public boolean validateDate(final String dateOfBirth) {

        try {
            final LocalDate dateParse = LocalDate.parse(dateOfBirth);
            final LocalDate todayDate = LocalDate.now();
            final LocalDate particularDate = LocalDate.of(2007, 12, 31);

            return (todayDate.isAfter(dateParse) && dateParse.isAfter(particularDate)) ? true : false;
        } catch (Exception exception) {
            throw new DateNotValidException("Invalid Date");
        }
    }
}