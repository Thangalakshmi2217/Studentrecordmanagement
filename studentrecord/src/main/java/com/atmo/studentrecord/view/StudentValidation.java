package com.atmo.studentrecord.view;

/**
 * <p>
 * Validates the student details.
 * </p>
 *
 * @author Thalaimalaipandiyan T
 * @version 1.0
 */
public class StudentValidation {

    /**
     * <p>
     * Validates the StudentRollNumber.
     * </p>
     * <li>RollNumber must be three to fifteen digits</li>
     *
     * @param rollNumber unique identification numbers that can be assigned to students at the time of admission or after
     *                   admission
     * @return true when the rollNumber matches the pattern
     */
    public boolean validateStudentRollNumber(final String rollNumber) {
        return rollNumber.matches("[0-9]{3,15}") ? true : false;
    }

    /**
     * <p>
     * Validation of student's academic DepartmentName.
     * </p>
     *
     * @param departmentName name of the specific department
     * @return true when the DepartmentName matches the pattern
     */
    public boolean validateDepartmentName(final String departmentName) {
        return departmentName.matches("((?i)ECE|EEE|MECH|CSE|CIVIL)") ? true : false;
    }

    /**
     * <p>
     * Validates the Gender of the students.
     * </p>
     *
     * @param gender represents the student's gender
     * @return true when the gender matches the pattern
     */
    public boolean validateGender(final String gender) {
        return gender.matches("((?i)MALE|FEMALE|OTHERS)") ? true : false;
    }

    /**
     * <p>
     * Validates the Address of the students.
     * </p>
     *
     * @param address represents the student's street number, street name, suburb city, state and country
     * @return true when the address matches the pattern
     */
    public boolean validateAddress(final String address) {
        return address.matches(".*([a-zA-Z].*[0-9]|[0-9].*[a-zA-Z]).*") ? true : false;
    }

    /**
     * <p>
     * Validates the Grade of the students.
     * </p>
     *
     * @param grade reflect the student's performance throughout the entire course
     * @return true when the grade matches the pattern
     */
    public boolean validateGrade(final String grade) {
        return grade.matches("((?i)O|A+|A|B|U)") ? true : false;
    }

    /**
     * <p>
     * Validates the student choices.
     * </p>
     *
     * @param choice includes Name, Email, RollNumber, DepartmentName, Gender, DateOfBirth, Address and Grade.
     * @return true when the choice matches the pattern
     */
    public static boolean validateChoice(String choice) {
        return choice.matches("[1-8]") ? true : false;
    }
}
