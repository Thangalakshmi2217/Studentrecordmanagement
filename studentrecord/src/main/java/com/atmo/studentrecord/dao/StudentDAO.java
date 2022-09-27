package com.atmo.studentrecord.dao;

import com.atmo.studentrecord.model.Student;

import java.sql.Connection;
import java.util.Map;

/**
 * <p>
 * Establishes the {@link Connection} to the database and executes the DML and DQL operations on the database.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public interface StudentDAO {

    /**
     * <p>
     * Student details were inserted into the database.
     * </p>
     *
     * @param student {@link Student}
     * @return true when the student details were inserted
     */
    boolean insertStudentDetails(final Student student);

    /**
     * <p>
     * Specific student details were deleted in the database.
     * </p>
     *
     * @param rollNumber represents the student rollNumber
     * @return true when the details of the student were deleted
     */
    boolean deleteStudentDetails(final String rollNumber);

    /**
     * <p>
     * Specific student information was updated in the database.
     * </p>
     *
     * @param student {@link Student}
     * @return true when the student details were updated
     */
    boolean updateStudentDetails(final Student student);

    /**
     * <p>
     * selects the specific student using the student records from the database.
     * </p>
     *
     * @param rollNumber represents the student rollNumber
     * @return the student details
     */
    Student selectStudentDetail(final String rollNumber);

    /**
     * <p>
     * Obtains all the student information from the database.
     * </p>
     *
     * @return the list of student related details
     */
    Map<String, Student> getAllStudents();
}
