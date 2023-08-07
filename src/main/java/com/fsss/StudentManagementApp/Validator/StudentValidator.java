package com.fsss.StudentManagementApp.Validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.StudentManagementApp.model.Student;
import com.fssa.StudentManagementApp.model.StudentValidatorErrors;

/**
 * The StudentValidator class provides methods to validate different attributes of a student.
 */
public class StudentValidator {

    /**
     * Validates the student object for null.
     *
     * @param student The student object to be validated.
     * @return true if the student object is not null.
     * @throws IllegalArgumentException if the student object is null.
     */
    public static boolean validateStudent(Student student) throws IllegalArgumentException {
        if (student == null) {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_NULL);
        }
        return true;
    }

    /**
     * Validates the name of a student.
     *
     * @param name The name to be validated.
     * @return true if the name is valid and follows the specified pattern.
     * @throws IllegalArgumentException if the name is empty, null, or doesn't match the required pattern.
     */
    public static boolean validateName(String name) throws IllegalArgumentException {
        if ("".equals(name) || name == null) {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_NAME);
        }
        String regex = "^[A-Za-z]+(?: [A-Za-z]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(name);
        boolean isMatch = match.matches();
        if (isMatch) {
            return true;
        } else {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_NAME);
        }
    }

    /**
     * Validates the ID of a student.
     *
     * @param id The ID to be validated.
     * @return true if the ID is a non-negative integer.
     * @throws IllegalArgumentException if the ID is negative.
     */
    public static boolean validateId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_ID);
        }
        return true;
    }

    /**
     * Validates the mobile number of a student.
     *
     * @param mobileNo The mobile number to be validated.
     * @return true if the mobile number is valid and follows the required pattern.
     * @throws IllegalArgumentException if the mobile number is empty, null, or doesn't match the required pattern.
     */
    public static boolean validateMobileNo(String mobileNo) {
        if (mobileNo == null || "".equals(mobileNo)) {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_MOBILENO);
        }
        String mobRegex = "^[0-9]{10}$";
        Pattern mobPattern = Pattern.compile(mobRegex);
        Matcher mobmatches = mobPattern.matcher(mobileNo);
        boolean isMatch = mobmatches.matches();
        if (isMatch) {
            return true;
        } else {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_MOBILENO);
        }
    }

    /**
     * Validates the password of a student.
     *
     * @param password The password to be validated.
     * @return true if the password is valid and follows the required pattern.
     * @throws IllegalArgumentException if the password is empty, null, or doesn't match the required pattern.
     */
    public static boolean validatePassword(String password) {
        if (password == null || "".equals(password)) {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_PASS);
        }
        String passRegex = "^[0-9]{10}$";
        Pattern passPattern = Pattern.compile(passRegex);
        Matcher passMatches = passPattern.matcher(password);
        boolean isMatch = passMatches.matches();
        if (isMatch) {
            return true;
        } else {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_PASS);
        }
    }

    /**
     * Validates the date of birth (DOB) of a student.
     *
     * @param dob The date of birth to be validated.
     * @return true if the DOB is not null and not in the future.
     * @throws IllegalArgumentException if the DOB is null or in the future.
     */
    public static boolean validateDob(LocalDate dob) throws IllegalArgumentException {
        if (dob == null) {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_DOB);
        }
        LocalDate currentDate = LocalDate.now();
        if (dob.isAfter(currentDate)) {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_DOB);
        } else {
            return true;
        }
    }

    /**
     * Validates the created date of a student.
     *
     * @param createdDate The created date to be validated.
     * @return true if the created date is not null and not in the future.
     * @throws IllegalArgumentException if the created date is null or in the future.
     */
    public static boolean validateCreatedDate(LocalDate createdDate) throws IllegalArgumentException {
        LocalDate currentDate = LocalDate.now();
        if (createdDate.isAfter(currentDate) && createdDate != null) {
            throw new IllegalArgumentException(StudentValidatorErrors.INVALID_CREATEDDATE);
        } else {
            return true;
        }
    }
}
