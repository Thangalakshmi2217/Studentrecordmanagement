package com.atmo.authentication.authenticateservice;

import com.atmo.authentication.authenticatedao.AuthenticationDao;
import com.atmo.authentication.exception.DetailsAlreadyFoundException;
import com.atmo.authentication.exception.RecordNotFoundException;

/**
 * <p>
 * Implemented the authentication services provided.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final AuthenticationDao STUDENTRECORD_DAO = new AuthenticationDao();

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @param adminName  represents the name of the admin
     * @param adminEmail represents the admin Email
     * @param password   represents the password of the admin
     * @return true when the credential information is present
     */
    public boolean insertAdminDetail(final String adminName, final String adminEmail, final String password) {

        if (!STUDENTRECORD_DAO.getAdminEmail().contains(adminEmail)) {

            if (STUDENTRECORD_DAO.insertAdminDetails(adminName, adminEmail, password)) {
                return true;
            }
        }
        throw new DetailsAlreadyFoundException("Admin Details Already Exist");
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @param adminEmail represents the admin Email
     * @param password   represents the password of the admin
     * @return true when the credential information is present
     */
    public boolean validateAdminDetail(final String adminEmail, final String password) {

        if (STUDENTRECORD_DAO.loginAdmin(adminEmail, password)) {
            return true;
        } else {
            throw new RecordNotFoundException("Record Not Found");
        }
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @param rollNumber  represents the password of the admin
     * @param studentName represents the name of the student
     * @return true when the credential information is present
     */
    public boolean studentLogin(final String rollNumber, final String studentName) {

        if (STUDENTRECORD_DAO.studentLogin(rollNumber, studentName)) {
            return true;
        } else {
            throw new RecordNotFoundException("Record Not Found");
        }
    }
}
