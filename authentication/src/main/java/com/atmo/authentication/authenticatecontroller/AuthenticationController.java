package com.atmo.authentication.authenticatecontroller;

import com.atmo.authentication.authenticateservice.AuthenticationService;
import com.atmo.authentication.authenticateservice.AuthenticationServiceImpl;

/**
 * <p>
 * Controls all the requests from the users and updates the view whenever the data changes
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class AuthenticationController {

    private static final AuthenticationService AUTHENTICATE_SERVICE = new AuthenticationServiceImpl();

    /**
     * <p>
     * Checks the admin credentials.
     * </p>
     *
     * @param adminName  represents the Name of the admin
     * @param adminEmail represents Admin MailId
     * @param password   represents the password of the admin
     * @return true if the given information is present
     */
    public boolean adminSignup(final String adminName, final String adminEmail, final String password) {
        return AUTHENTICATE_SERVICE.insertAdminDetail(adminName, adminEmail, password);
    }

    /**
     * <p>
     * Checks the login credentials.
     * </p>
     *
     * @param adminEmail represents the Email of the admin
     * @param password   represents the password of the admin
     * @return true if the given information is present
     */
    public boolean adminLogin(final String adminEmail, final String password) {
        return AUTHENTICATE_SERVICE.validateAdminDetail(adminEmail, password);
    }

    /**
     * <p>
     * Checks the student Name and RollNumber for login.
     * </p>
     *
     * @param rollNumber  represents the RollNumber of the student
     * @param studentName represents the Name of the student
     * @return true if the given information is present
     */
    public boolean studentLogin(final String rollNumber, final String studentName) {
        return AUTHENTICATE_SERVICE.studentLogin(rollNumber, studentName);
    }
}
