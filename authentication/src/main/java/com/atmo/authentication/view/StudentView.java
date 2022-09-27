package com.atmo.authentication.view;

import com.atmo.authentication.authenticatecontroller.AuthenticationController;
import com.atmo.authentication.Activator;
import com.atmo.exception.CustomException;
import com.atmo.userinput.UserInput;
import com.atmo.studentrecord.controller.StudentRecordController;
import com.atmo.validate.validation.CommonValidation;
import com.atmo.studentrecord.view.StudentInformationView;
import com.atmo.studentrecord.view.StudentValidation;

import org.apache.log4j.Logger;

/**
 * <p>
 * Gets the <code>User information</code> from the users.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class StudentView {

    private static final Logger LOGGER = Logger.getLogger(StudentView.class);
    private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();
    private static final AuthenticationController AUTHENTICATE_CONTROLLER = new AuthenticationController();
    private static final CommonValidation VALIDATION = new CommonValidation();
    private static final StudentValidation STUDENT_VALIDATION = new StudentValidation();

    /**
     * <p>
     * Users can select between logging in and signing up.
     * </p>
     */
    public static void selectChoice() {
        int choice;

        do {
            System.out.println("STUDENT RECORD MANAGEMENT SYSTEM\n1.Admin Login\n2.Admin Signup\n3.StudentLogin\n4.Exit");
            choice = Integer.parseInt(StudentView.getChoice());

            switch (choice) {
                case 1:
                    StudentView.adminLogin();
                    break;
                case 2:
                    StudentView.adminSignup();
                    break;
                case 3:
                    StudentView.studentLogin();
                    break;
                case 4:
                    UserInput.SCANNER.close();

                    try {
                        Activator.bundle.stop();
                    } catch (Exception exception) {
                        LOGGER.error(exception);
                    }
            }
        } while (choice < 4);
    }

    /**
     * <p>
     * Gets the choice of the users.
     * </p>
     *
     * @return the user's selection
     */
    public static String getChoice() {
        final String choice = UserInput.getString("Enter choice");
        StudentView.exit(choice);

        if (Validation.validateChoice(choice)) {
            return choice;
        } else {
            LOGGER.warn("Enter Valid Choice:");
            return StudentView.getChoice();
        }
    }

    /**
     * <p>
     * Gets the name of the user, sends it for verification & when it matches, returns the name otherwise user must
     * re-enter their name.
     * </p>
     *
     * @return the name of the user
     */
    static String getName() {
        final String name = UserInput.getString("Enter Name:\nPress # To Exit");

        StudentView.exit(name);

        if (VALIDATION.validateName(name)) {
            return name;
        } else {
            LOGGER.warn("Enter Valid Name:\nPress # To Exit");
            return StudentView.getName();
        }
    }

    /**
     * <p>
     * Gets the user's MailId, sends it for verification, & when it matches, returns the MailId otherwise
     * the user must re-enter their MailId.
     * </p>
     *
     * @return the Email given by the user
     */
    static String getEmail() {
        final String email = UserInput.getString("Enter Email:\nPress # To Exit");

        StudentView.exit(email);

        if (VALIDATION.validateEmail(email)) {
            return email;
        } else {
            LOGGER.warn("Enter Valid Email:\nPress # To Exit");
            return StudentView.getEmail();
        }
    }

    /**
     * <p>
     * Gets the user's password, sends it for verification, & when it matches, returns the password otherwise
     * the user must re-enter their password.
     * </p>
     *
     * @return the password of the user.
     */
    private static String getPassword() {
        final String password = UserInput.getString("Enter Admin Password:\nPress # To Exit");

        StudentView.exit(password);

        if (VALIDATION.validatePassword(password)) {
            return password;
        } else {
            LOGGER.warn("Enter Valid Password:\nPress # To Exit");
            return StudentView.getPassword();
        }
    }

    /**
     * <p>
     * Gets the StudentRollNumber, sends it for verification, & when it matches, returns the RollNumber otherwise
     * the student must re-enter their RollNumber.
     * </p>
     *
     * @return the RollNumber of the student
     */
    static String getStudentRollNumber() {
        final String rollNumber = UserInput.getString("Enter Student Rollnumber\nPress # To Exit");

        StudentView.exit(rollNumber);

        if (STUDENT_VALIDATION.validateStudentRollNumber(rollNumber)) {
            return rollNumber;
        } else {
            LOGGER.warn("Enter Valid Rollnumber:\nPress # To Exit");
            return StudentView.getStudentRollNumber();
        }
    }

    /**
     * <p>
     * Gets the admin credentials and the admin details were inserted.
     * </p>
     */
    public static void adminSignup() {
        final String adminName = StudentView.getName();
        final String adminEmail = StudentView.getEmail();
        final String password = StudentView.getPassword();

        try {

            if (AUTHENTICATE_CONTROLLER.adminSignup(adminName, adminEmail, password)) {
                System.out.println("Admin Details Inserted Successfully");
                StudentView.adminLogin();
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * <p>
     * When the given credentials is correct, admin can login and it leads to their respective roles.
     * </p>
     */
    public static void adminLogin() {
        final String adminEmail = StudentView.getEmail();
        final String password = StudentView.getPassword();

        try {

            if (AUTHENTICATE_CONTROLLER.adminLogin(adminEmail, password)) {
                System.out.println("Log in Successfully");
                StudentInformationView.showAdminWorks();
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * <p>
     * If the given Name and Roll Number are valid, the student can log in immediately.
     * </p>
     */
    public static void studentLogin() {
        final String rollNumber = StudentView.getStudentRollNumber();
        final String studentName = StudentView.getName();

        try {

            if (AUTHENTICATE_CONTROLLER.studentLogin(rollNumber, studentName)) {
                LOGGER.info("Login Successfully");
                StudentInformationView.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * <p>
     * Goes back to the choice menu.
     * </p>
     *
     * @param choice users were given the option to either sign up or log in
     */
    public static void exit(final String choice) {

        if ("#".equals(choice)) {
            StudentView.selectChoice();
        }
    }
}