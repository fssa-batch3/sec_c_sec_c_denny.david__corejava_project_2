package com.fssa.studentmanagmentapp.Service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.studentmanagementapp.Enum.Gender;
import com.fssa.studentmanagementapp.Service.StudentService;
import com.fssa.studentmanagementapp.Validator.StudentValidator;
import com.fssa.studentmanagementapp.dao.StudentDao;
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.model.StudentValidatorErrors;
import com.fssa.studentmanagementapp.util.Logger;


//Testing service layer using testStudentService
public class TestStudentService {

StudentService rs = new StudentService(new StudentValidator(), new StudentDao());
	// Testing addStudent by sending datas
	@Test
	public void testAddStudent() throws SQLException {
		Student student = new Student();
		student.setName("Nithilan");
		LocalDate dob = LocalDate.parse("2002-02-13");
		LocalDate createdDate = dob;
		student.setDob(dob);
		student.setEmailId("nithilan166@example.com");
		student.setCreatedDate(createdDate);
		student.setGender(Gender.MALE);
		student.setPassword("1235567891");
		student.setMobileNo("7867979732");  
		
		Assertions.assertTrue(StudentService.addStudent(student)); 
		
	}
 
	@Test
	// esting the method by giving invalid datas
	public void testAddInvalidStudent() throws SQLException {
		Student student1 = new Student();
		student1.setName("");
		student1.setGender(Gender.MALE);
		LocalDate dob = LocalDate.of(2024, 02, 13);
		student1.setDob(dob);
		LocalDate createdDate = dob;
		student1.setEmailId("joelpremkumar.gamil.com");
		student1.setCreatedDate(createdDate);
		student1.setId(-1);
		student1.setMobileNo("9489161");
		student1.setPassword("denny");
		try {
			StudentService.addStudent(student1);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(), StudentValidatorErrors.INVALID_DOB);
		}
	}

	@Test
	public void testdeleteStudent() throws SQLException {
		Assertions.assertTrue(StudentService.deleteStudent(31));
	}

	@Test
	public void testdeleteInvalidStudent() throws SQLException {
		try {
			StudentService.deleteStudent(-1);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(), StudentValidatorErrors.INVALID_ID);
		}
	}

	@Test
	public void testfindStudentbyName() throws SQLException {

		Student student = (StudentService.findStudentByName("Pranaw"));
		Logger.info(student);

	}

	@Test
	public void testfindStudentbyInvalidName() throws SQLException {
		try {
			StudentService.findStudentByName("");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(), StudentValidatorErrors.INVALID_NAME);
		}
	}

	@Test
	public void testreadStudent() throws SQLException {
		Student student = new Student();
		Assertions.assertTrue(StudentService.readStudent(student));
	}

	@Test
	public void testreadInvalidStudent() throws SQLException {
		try {
			Student student = new Student();
			StudentService.readStudent(student);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(), StudentValidatorErrors.INVALID_NULL);
		}
	}

	@Test
	public void testupdateStudent() throws SQLException { 
		Student student = new Student();
		student.setId(1);
		student.setPassword("1234567890");
		student.setName("Nithilan");
		student.setEmailId("nithila1256@freshworks.com");
		LocalDate dob = LocalDate.parse("2006-02-13"); 
		student.setDob(LocalDate.of(2005, 1, 5));
		student.setCreatedDate(dob);
		student.setGender(Gender.MALE);
		student.setMobileNo("9732518875"); 

 
		Assertions.assertTrue(StudentService.updateStudent(student,1));
	}
    
	@Test
	public void testupdateInvalidStudent() throws SQLException {
		Student student = new Student();

		try {
			student.setCreatedDate(LocalDate.of(2020, 1, 10));
			StudentService.updateStudent(student, 1);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(), StudentValidatorErrors.INVALID_DOB);
		}
	}
   
	@Test
	public void getAllStudent() throws SQLException {
		// Retrieving all blood requests using the getAllBloodRequest method.
		ArrayList<Student> Student = rs.getAllStudent();
		Logger.info(Student);

		// Verifying if the ArrayList is not null.
		// If the ArrayList is not null, the test is considered successful, otherwise,
		// it fails.
		if (Student != null) {
			assertTrue(true);// test pass
		} else {
			Assertions.fail();// test fail
		}
	}
}
