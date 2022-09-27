package com.atmo.authentication.authenticateservice;

/**
 * <p>
 * Interface to validate the authentication details.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public interface AuthenticationService {

    /**
     * <p>
     * Checks the existing admin email and adds the new admin credentials if the email is not present.
     * </p>
     *
     * @param adminName  represents the name of the admin
     * @param adminEmail represents the admin Email
     * @param password   represents the password of the admin
     * @return true when the credential information is present
     */
    boolean insertAdminDetail(final String adminName, final String adminEmail, final String password);

    /**
     * <p>
     * Checks the admin details for Sign in.
     * </p>
     *
     * @param adminEmail represents the admin Email
     * @param password   represents the password of the admin
     * @return true when the credential information is present
     */
    boolean validateAdminDetail(final String adminEmail, final String password);

    /**
     * <p>
     * Checks the student details for the student login.
     * </p>
     *
     * @param rollNumber  represents the password of the admin
     * @param studentName represents the name of the student
     * @return true when the credential information is present
     */
    boolean studentLogin(final String rollNumber, final String studentName);
}
