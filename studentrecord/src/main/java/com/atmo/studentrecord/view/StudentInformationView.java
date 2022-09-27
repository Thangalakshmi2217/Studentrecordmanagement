package com.atmo.studentrecord.view;

import com.atmo.exception.CustomException;
import com.atmo.userinput.UserInput;
import com.atmo.studentrecord.controller.StudentRecordController;
import com.atmo.studentrecord.exception.RecordNotFoundException;
import com.atmo.studentrecord.model.Student;

import org.apache.log4j.Logger;

import java.sql.Date;

/**
 * <p>
 * DML and DQL operations are carried out by the admin.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class StudentInformationView {

    private static final Logger LOGGER = Logger.getLogger(StudentInformationView.class);
    private static final StudentRecordController STUDENTRECORD_CONTROLLER = new StudentRecordController();

    /**
     * <p>
     * Admin has overall access to student record details.
     * </p>
     */
    public static void showAdminWorks() {

        do {
            System.out.println("1.Insert 2.View 3.Delete 4.Update 5.ShowAll Details");
            int choice = Integer.parseInt(StudentRecordView.getChoice().trim());

            if (choice == 1) {
                StudentInformationView.addStudentDetails();
            } else if (choice == 2) {
                StudentInformationView.viewStudentDetails();
            } else if (choice == 3) {
                StudentInformationView.deleteStudentDetails();
            } else if (choice == 4) {
                StudentInformationView.updateStudentDetails();
            } else if (choice == 5) {
                StudentInformationView.showAllStudentDetails();
            } else {
                UserInput.SCANNER.close();
                System.exit(0);
            }
        } while (true);
    }

    /**
     * <p>
     * Gets the information from the student and inserted the student details.
     * </p>
     */
    private static void addStudentDetails() {
        final String rollNumber = StudentRecordView.getStudentRollNumber();

        try {
            STUDENTRECORD_CONTROLLER.checkRollNumber(rollNumber);
        } catch (CustomException exception) {
            LOGGER.error(exception);
            StudentInformationView.addStudentDetails();
            StudentInformationView.showAdminWorks();
        }
        final String studentName = StudentRecordView.getName();
        final String departmentName = StudentRecordView.getDepartmentName();
        final String email = StudentRecordView.getEmail();
        final String gender = StudentRecordView.getGender();
        final Date dateOfBirth = StudentRecordView.getDateOfBirth();
        final String address = StudentRecordView.getAddress();
        final String grade = StudentRecordView.getGrade();

        final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address, grade);

        try {

            if (STUDENTRECORD_CONTROLLER.insertStudentDetails(student)) {
                LOGGER.info("Record Inserted Successfully");
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * <p>
     * Admin is able to view the records of any specific student.
     * </p>
     */
    private static void viewStudentDetails() {
        final String rollNumber = StudentRecordView.getStudentRollNumber();

        try {
            StudentInformationView.showDetails(STUDENTRECORD_CONTROLLER.selectStudentDetail(rollNumber));
        } catch (RecordNotFoundException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * <p>
     * Admin can print and show any records of the student.
     * </p>
     *
     * @param student {@link Student}
     */
    public static void showDetails(final Student student) {
        System.out.println(student);
    }

    /**
     * <p>
     * Any student records could be deleted by the admin.
     * </p>
     */
    private static void deleteStudentDetails() {
        final String rollNumber = StudentRecordView.getStudentRollNumber();

        try {

            if (STUDENTRECORD_CONTROLLER.deleteStudentDetails(rollNumber)) {
                LOGGER.info("Record Deleted Successfully");
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * <p>
     * Student records can be updated by the admin.
     * </p>
     */
    private static void updateStudentDetails() {
        final String rollNumber = StudentRecordView.getStudentRollNumber();

        try {
            STUDENTRECORD_CONTROLLER.checkUpdate(rollNumber);
        } catch (CustomException exception) {
            LOGGER.error(exception);
            StudentInformationView.updateStudentDetails();
            StudentInformationView.showAdminWorks();
        }
        final String studentName = StudentRecordView.getName();
        final String departmentName = StudentRecordView.getDepartmentName();
        final String email = StudentRecordView.getEmail();
        final String gender = StudentRecordView.getGender();
        final Date dateOfBirth = StudentRecordView.getDateOfBirth();
        final String address = StudentRecordView.getAddress();
        final String grade = StudentRecordView.getGrade();

        final Student student = new Student(rollNumber, studentName, departmentName, email, gender, dateOfBirth, address, grade);

        try {

            if (STUDENTRECORD_CONTROLLER.updateStudentDetails(student)) {
                LOGGER.warn("Record Updated Successfully");
            }
        } catch (CustomException exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * <p>
     * Admin can show all student related records.
     * </p>
     */
    private static void showAllStudentDetails() {
        System.out.println(STUDENTRECORD_CONTROLLER.getAllStudents());
    }
}