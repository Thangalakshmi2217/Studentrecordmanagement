package com.atmo.studentrecord.service;

import com.atmo.studentrecord.dao.StudentDAO;
import com.atmo.studentrecord.exception.RecordNotFoundException;
import com.atmo.studentrecord.exception.RollNumberAlreadyExistException;
import com.atmo.studentrecord.model.Student;
import com.atmo.studentrecord.dao.StudentDAOImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Implemented the services provided.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class StudentServiceImpl implements StudentService {

    private static final StudentDAO STUDENTRECORD_DAO = new StudentDAOImpl();

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @param student {@link Student}
     * @return true when the details of the student is inserted
     */
    public boolean insertStudentDetails(final Student student) {

        if (!STUDENTRECORD_DAO.getAllStudents().containsKey(student.getRollNumber())) {

            if (STUDENTRECORD_DAO.insertStudentDetails(student)) {
                return true;
            }
        }
        throw new RollNumberAlreadyExistException("RollNumber Already Exist");
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @param rollNumber represents the student rollNumber
     * @return true when the specific student information deleted using their rollNumber
     */
    public boolean deleteStudentDetails(final String rollNumber) {

        if (STUDENTRECORD_DAO.deleteStudentDetails(rollNumber)) {
            return true;
        }
        throw new RecordNotFoundException("Record Not Found");
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @param student {@link Student}
     * @return true when the student details were updated
     */
    public boolean updateStudentDetails(final Student student) {

        if (STUDENTRECORD_DAO.updateStudentDetails(student)) {
            return true;
        }
        throw new RecordNotFoundException("Record Not Found");
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @param rollNumber represents the student rollNumber
     * @return return true when we can select the specific student details
     */
    public Student selectStudentDetail(final String rollNumber) {

        if (STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber)) {
            return STUDENTRECORD_DAO.selectStudentDetail(rollNumber);
        } else {
            throw new RecordNotFoundException("Record Not Found");
        }
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @param rollNumber represents the students rollNumber
     * @return true when the rollNumber is existed in the database
     */
    public boolean checkRollNumber(final String rollNumber) {

        if (!STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber)) {
            return true;
        }
        throw new RollNumberAlreadyExistException("The Given Roll Number Already Exist\n Re-Enter RollNo ");
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @return the {@link List}
     */
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(STUDENTRECORD_DAO.getAllStudents().values());
    }

    /**
     * <p>
     * {@inheritDoc}
     * </p>
     *
     * @param rollNumber represents the student rollNumber
     * @return true when the rollNumber is updated
     */
    public boolean checkUpdate(String rollNumber) {
        if (STUDENTRECORD_DAO.getAllStudents().containsKey(rollNumber)) {
            return true;
        }
        throw new RecordNotFoundException("Record Not Found");
    }
}