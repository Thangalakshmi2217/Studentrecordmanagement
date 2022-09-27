package com.atmo.studentrecord.view;

import com.atmo.exception.CustomException;
import com.atmo.userinput.UserInput;
import com.atmo.validate.validation.CommonValidation;

import java.sql.Date;

import org.apache.log4j.Logger;

/**
 * <p>
 * Manages the student records.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class StudentRecordView {

    private static final Logger LOGGER = Logger.getLogger(StudentRecordView.class);
    private static final CommonValidation STUDENT_VALIDATION = new CommonValidation();
    private static final StudentValidation VALIDATION = new StudentValidation();

    /**
     * <p>
     * Gets the student choices.
     * </p>
     *
     * @return the student choices
     */
    public static String getChoice() {
        final String choice = UserInput.getString("Enter Choice:");

        StudentRecordView.exit(choice);

        if (StudentValidation.validateChoice(choice)) {
            return choice;
        } else {
            LOGGER.warn("Enter Valid Choice:");
            return StudentRecordView.getChoice();
        }
    }

    /**
     * <p>
     * Gets the Name of the students.
     * </p>
     *
     * @return the Name
     */
    static String getName() {
        final String name = UserInput.getString("Enter Name:\nPress # To Exit");

        StudentRecordView.exit(name);

        if (STUDENT_VALIDATION.validateName(name)) {
            return name;
        } else {
            LOGGER.warn("Enter Valid Name:\nPress # To Exit");
            return StudentRecordView.getName();
        }
    }

    /**
     * <p>
     * Gets the Email from the students.
     * </p>
     *
     * @return the Email
     */
    static String getEmail() {
        final String email = UserInput.getString("Enter Email:\nPress # To Exit");

        StudentRecordView.exit(email);

        if (STUDENT_VALIDATION.validateEmail(email)) {
            return email;
        } else {
            LOGGER.warn("Enter Valid Email:\nPress # To Exit");
            return StudentRecordView.getEmail();
        }
    }

    /**
     * <p>
     * Gets the RollNumber from the students.
     * </p>
     *
     * @return the RollNumber
     */
    static String getStudentRollNumber() {
        final String rollNumber = UserInput.getString("Enter Student Rollnumber\nPress # To Exit");

        StudentRecordView.exit(rollNumber);

        if (VALIDATION.validateStudentRollNumber(rollNumber)) {
            return rollNumber;
        } else {
            LOGGER.warn("Enter Valid Rollnumber:\nPress # To Exit");
            return StudentRecordView.getStudentRollNumber();
        }
    }

    /**
     * <p>
     * Gets the DepartmentName from the students.
     * </p>
     *
     * @return the DepartmentName
     */
    static String getDepartmentName() {
        final String departmentName = UserInput.getString("Enter Department Name (ECE, EEE, CIVIL, MECH, CSE)\nPress # To Exit");

        StudentRecordView.exit(departmentName);

        if (VALIDATION.validateDepartmentName(departmentName)) {
            return departmentName;
        } else {
            LOGGER.warn("Enter Valid Department:\nPress # To Exit");
            return StudentRecordView.getDepartmentName();
        }
    }

    /**
     * <p>
     * Gets the Gender details from the students.
     * </p>
     *
     * @return the Gender
     */
    static String getGender() {
        final String gender = UserInput.getString("Enter Student Gender (Male or Female or Others)\nPress # To Exit");

        StudentRecordView.exit(gender);

        if (VALIDATION.validateGender(gender)) {
            return gender;
        } else {
            LOGGER.warn("Enter Valid Gender:\nPress # To Exit");
            return StudentRecordView.getGender();
        }
    }

    /**
     * <p>
     * Gets the DateOfBirth information from the students.
     * </p>
     *
     * @return the DateOfBirth
     */
    static Date getDateOfBirth() {
        final String date = UserInput.getString("Enter Student Date-of-Birth (yyyy-MM-dd)\nPress # To Exit");

        StudentRecordView.exit(date);
        boolean isValidDate = false;

        try {
            isValidDate = STUDENT_VALIDATION.validateDate(date);
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }

        if (isValidDate) {
            return Date.valueOf(date);
        } else {
            LOGGER.warn("Enter Valid Date:\nPress # To Exit");
            return StudentRecordView.getDateOfBirth();
        }
    }

    /**
     * <p>
     * Gets the Address from the students
     * </p>
     *
     * @return the Address
     */
    static String getAddress() {
        final String address = UserInput.getString("Enter Student Address:\nPress # To Exit");

        StudentRecordView.exit(address);

        if (VALIDATION.validateAddress(address)) {
            return address;
        } else {
            LOGGER.warn("Enter Valid Address:\nPress # To Exit");
            return StudentRecordView.getAddress();
        }
    }

    /**
     * <p>
     * Gets the Grade details from the students.
     * </p>
     *
     * @return the Grade
     */
    static String getGrade() {
        final String grade = UserInput.getString("Enter Student Grade:(O, A, A+, B, U)\nPress # To Exit");

        StudentRecordView.exit(grade);

        if (VALIDATION.validateGrade(grade)) {
            return grade;
        } else {
            LOGGER.warn("Enter Valid Grade:\nPress # To Exit");
            return StudentRecordView.getGrade();
        }
    }

    /**
     * <p>
     * Terminates from the current method.
     * </p>
     *
     * @param choice options given to the admin to handle CRUD operations.
     */
    public static void exit(final String choice) {

        if ("#".equals(choice)) {
            StudentInformationView.showAdminWorks();
        }
    }
}
