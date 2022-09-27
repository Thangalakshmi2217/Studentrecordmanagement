package com.atmo.studentrecord.service;

import com.atmo.studentrecord.model.Student;

import java.util.List;

/**
 * <p>
 * Interface to validate the student details.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public interface StudentService {

    /**
     * <p>
     * Checks whether the student details were inserted.
     * </p>
     *
     * @param student {@link Student}
     * @return true when the details of the student is inserted
     */
    boolean insertStudentDetails(final Student student);

    /**
     * <p>
     * Checks whether the student details were deleted.
     * </p>
     *
     * @param rollNumber represents the student rollNumber
     * @return true when the specific student information deleted
     */
    boolean deleteStudentDetails(final String rollNumber);

    /**
     * <p>
     * Checks whether the student details were updated.
     * </p>
     *
     * @param student {@link Student}
     * @return true when the student details were updated
     */
    boolean updateStudentDetails(final Student student);

    /**
     * <p>
     * Checks whether the rollNumber is enrolled in the database.
     * </p>
     *
     * @param rollNumber represents the student rollNumber
     * @return return true when we can select the specific student details
     */
    boolean checkRollNumber(final String rollNumber);

    /**
     * <p>
     * Checks whether all the student details can be obtained.
     * </p>
     *
     * @return the {@link List}
     */
    List<Student> getAllStudents();

    /**
     * <p>
     * Checks whether the specific student detail can be selected.
     * </p>
     *
     * @param rollNumber represents the student rollNumber
     * @return return true when we can select the specific student details.
     */
    Student selectStudentDetail(final String rollNumber);

    /**
     * <p>
     * Checks whether the rollNumber has been updated.
     * </p>
     *
     * @param rollNumber represents the student rollNumber
     * @return true when the rollNumber is updated or false otherwise
     */
    boolean checkUpdate(String rollNumber);
}
