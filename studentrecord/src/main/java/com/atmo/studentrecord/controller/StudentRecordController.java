package com.atmo.studentrecord.controller;

import com.atmo.studentrecord.model.Student;
import com.atmo.studentrecord.service.StudentService;
import com.atmo.studentrecord.service.StudentServiceImpl;

import java.util.*;

/**
 * <p>
 * Controls all the requests from the student and updates the view whenever the data changes.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class StudentRecordController {

    private static final StudentService STUDENT_SERVICE = new StudentServiceImpl();

    /**
     * <p>
     * Checks whether the student details were inserted.
     * </p>
     *
     * @param student {@link Student}
     * @return true when details of the student were inserted
     */
    public boolean insertStudentDetails(final Student student) {
        return STUDENT_SERVICE.insertStudentDetails(student);
    }

    /**
     * <p>
     * Checks whether the particular student details can be selected
     * </p>
     *
     * @param rollNumber represent the student rollNumber
     * @return true when the particular student details can be selected
     */
    public Student selectStudentDetail(final String rollNumber) {
        return STUDENT_SERVICE.selectStudentDetail(rollNumber);
    }

    /**
     * <p>
     * Checks whether the particular student details can be deleted.
     * </p>
     *
     * @param rollNumber represents the rollNumber of the student
     * @return true when the particular student details can be deleted
     */
    public boolean deleteStudentDetails(final String rollNumber) {
        return STUDENT_SERVICE.deleteStudentDetails(rollNumber);
    }

    /**
     * <p>
     * Checks whether the particular student details can be updated.
     * </p>
     *
     * @param student {@link Student}
     * @return true when the particular student details can be updated
     */
    public boolean updateStudentDetails(final Student student) {
        return STUDENT_SERVICE.updateStudentDetails(student);
    }

    /**
     * <p>
     * Gets the information of all the students.
     * </p>
     *
     * @return the {@link List}
     */
    public List<Student> getAllStudents() {
        return STUDENT_SERVICE.getAllStudents();
    }

    /**
     * <p>
     * Checks the rollNumber of the student.
     * </p>
     *
     * @param rollNumber represents the rollNumber of the student
     * @return the rollNumber
     */
    public boolean checkRollNumber(final String rollNumber) {
        return STUDENT_SERVICE.checkRollNumber(rollNumber);
    }

    /**
     * <p>
     * Updates the rollNumber of the student.
     * </p>
     *
     * @param rollNumber represents the rollNumber of the student
     * @return the rollNumber
     */
    public boolean checkUpdate(final String rollNumber) {
        return STUDENT_SERVICE.checkUpdate(rollNumber);
    }
}