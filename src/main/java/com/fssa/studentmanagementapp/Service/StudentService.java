package com.fssa.studentmanagementapp.Service;

import java.sql.SQLException;

import com.fssa.studentmanagementapp.dao.StudentDao;
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.Validator.StudentValidator;

/**
 * Service class for managing student-related operations.
 */
public class StudentService {

	/**
	 * Adds a student to the system.
	 *
	 * @param student The student to be added.
	 * @return {@code true} if the student was successfully added, {@code false}
	 *         otherwise.
	 * @throws SQLException If there's an issue with the database operation.
	 */
	public static boolean addStudent(Student student) throws SQLException {
		if (StudentValidator.validateStudent(student)) {
			StudentDao.addStudent(student);
			return true;
		}
		return false;
	}

	/**
	 * Retrieves information about a student.
	 *
	 * @param student The student whose information is to be retrieved.
	 * @return {@code true} if the student's information was successfully retrieved,
	 *         {@code false} otherwise.
	 * @throws SQLException If there's an issue with the database operation.
	 */
	public static boolean readStudent(Student student) throws SQLException {
		StudentDao.readStudent();
		return true;
	}

	/**
	 * Updates student information in the system.
	 *
	 * @param student The updated student information.
	 * @param id      The ID of the student to be updated.
	 * @return {@code true} if the student's information was successfully updated,
	 *         {@code false} otherwise.
	 * @throws SQLException If there's an issue with the database operation.
	 */
	public static boolean updateStudent(Student student, int id) throws SQLException {
		if (StudentValidator.validateStudent(student)) {
			StudentDao.updateStudent(student, id);
			return true;
		}
		return false;
	}

	/**
	 * Deletes a student from the system.
	 *
	 * @param id The ID of the student to be deleted. 
	 * @return {@code true} if the student was successfully deleted, {@code false}
	 *         otherwise.
	 * @throws SQLException If there's an issue with the database operation.
	 */
	public static boolean deleteStudent(int id) throws SQLException {
		if (StudentValidator.validateId(id)) {
			StudentDao.deleteStudent(id);
			return true;
		}
		return false;
	}

	/**
	 * Finds a student by their name.
	 *
	 * @param name The name of the student to be searched.
	 * @return {@code true} if the student was found, {@code false} otherwise.
	 * @throws SQLException If there's an issue with the database operation.
	 */
	public static Student findStudentByName(String name) throws SQLException {
		if (StudentValidator.validateName(name)) {
			return StudentDao.findStudentByName(name);

		}
		return null;
	}
}
