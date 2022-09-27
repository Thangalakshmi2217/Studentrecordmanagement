package com.atmo.authentication.authenticatedao;

import com.atmo.database.connection.DatabaseConnection;
import com.atmo.database.exception.ConnectionFailedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Establishes the {@link Connection} to the database and executes the DML and DQL operations on the database.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class AuthenticationDao {

    /**
     * <p>
     * Admin credentials were inserted to the DB.
     * </p>
     *
     * @param adminName  represents the name of the admin
     * @param adminEmail represents the admin Email
     * @param password   represents the password of the admin
     * @return true when the credentials inserted into the database
     */
    public boolean insertAdminDetails(final String adminName, final String adminEmail, final String password) {
        final String insertQuery = "insert into admin_records values(?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery);) {
            statement.setString(1, adminName);
            statement.setString(2, adminEmail);
            statement.setString(3, password);

            return statement.executeUpdate() > 0;
        } catch (Exception exception) {
            throw new ConnectionFailedException("Database Access Denied-Check SQL Syntax");
        }
    }

    /**
     * <p>
     * Admin can directly login with the given credentials.
     * </p>
     *
     * @param adminEmail represents the Email of the admin
     * @param password   represents the password of the admin
     * @return true when the given information is present
     */
    public boolean loginAdmin(final String adminEmail, final String password) {
        final String adminLogin = "select adminemail, password from admin_records where BINARY adminemail = ? and BINARY password = ? ";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparestatement = connection.prepareStatement(adminLogin);) {
            preparestatement.setString(1, adminEmail);
            preparestatement.setString(2, password);

            try (ResultSet resultset = preparestatement.executeQuery();) {

                while (resultset.next()) {
                    return true;
                }
            }
        } catch (Exception exception) {
            throw new ConnectionFailedException("Database Access Denied-Check SQL Syntax");
        }
        return false;
    }

    /**
     * <p>
     * Student can directly login with the given credentials.
     * </p>
     *
     * @param rollNumber  represents the RollNumber of the student
     * @param studentName represents the name of the student
     * @return true when the given information is present
     */
    public boolean studentLogin(final String rollNumber, final String studentName) {
        final String studentLogin = "select rollnumber, name from student_records where rollnumber = ? and name = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparestatement = connection.prepareStatement(studentLogin);) {
            preparestatement.setString(1, rollNumber);
            preparestatement.setString(2, studentName);

            try (ResultSet resultset = preparestatement.executeQuery();) {

                while (resultset.next()) {
                    return true;
                }
            }
        } catch (Exception exception) {
            throw new ConnectionFailedException("Database Access Denied-Check SQL Syntax");
        }
        return false;
    }

    /**
     * <p>
     * Gets the admin Email from the admin records.
     * </p>
     *
     * @return the {@link List}
     */
    public List<String> getAdminEmail() {
        final List<String> emailList = new ArrayList<String>();
        final String getEmail = "select adminemail from admin_records";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery(getEmail);) {

            while (resultset.next()) {
                String email = resultset.getString(1);
                emailList.add(email);
            }
        } catch (Exception exception) {
            throw new ConnectionFailedException("Database Access Denied");
        }
        return emailList;
    }
}
