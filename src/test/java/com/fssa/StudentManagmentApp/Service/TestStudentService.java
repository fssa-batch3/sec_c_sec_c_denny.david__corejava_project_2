package com.fssa.StudentManagmentApp.Service;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.StudentManagementApp.Service.StudentService;
import com.fssa.StudentManagementApp.model.Student;
import com.fssa.StudentManagementApp.model.StudentValidatorErrors;
import com.fsss.StudentManagementApp.Validator.StudentValidator;

//Testing service layer using testStudentService
public class TestStudentService {
	//Testing addStudent by sending datas
	@Test
    public void testAddStudent() throws SQLException{
		Student student = new Student();
		student.setId(0);
	    student.setName("Pranaw");
	    LocalDate dob = LocalDate.parse("2005-02-13");
	    LocalDate createdDate = dob;
	    student.setDob(dob);
	    student.setEmailId("murugasaaaan@example.com");
	    student.setCreatedDate(createdDate);
	   // student.setGender("M");
	    student.setPassword("1234567890");
	    student.setMobileNo("7418646406");
	    Assertions.assertTrue(StudentService.addStudent(student));
  }   
	@Test
	//esting the method by giving invalid datas
	public void testAddInvalidStudent() throws SQLException {
		Student student1 = new Student();
		student1.setName("");
		//student1.setGender("Male");
		LocalDate dob = LocalDate.of(2024,02,13);
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
	public void testdeleteStudent() throws SQLException{
		Assertions.assertTrue(StudentService.deleteStudent(0));
	}
	
	@Test 
	public void testdeleteInvalidStudent() throws SQLException {
		try {
			StudentService.deleteStudent(-1);
		}
		catch (IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_ID);
		}
	}
		@Test 
		public void testfindStudentbyName() throws SQLException {
			
			Assertions.assertTrue(StudentService.findStudentbyName("Denny"));
		}
	@Test 
		public void testfindStudentbyInvalidName()throws SQLException {
		try {
			StudentService.findStudentbyName("");
		}
		catch(IllegalArgumentException e) {
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
		}
		catch(IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(), StudentValidatorErrors.INVALID_NULL);
		}
		}
		   
		@Test 
		public void testupdateStudent() throws SQLException {
			Student student = new Student();
			student.setPassword("1234567890");
			student.setName("Aravind");
			student.setDob(LocalDate.of(2005, 1, 5));
			student.setCreatedDate(LocalDate.of(2019, 1, 10));
			student.setMobileNo("9944187132");
		    Assertions.assertTrue(StudentService.updateStudent(student,2));
		}   
		@Test 
		public void testupdateInvalidStudent() throws SQLException {
			Student student = new Student(); 
			
			try {
				student.setCreatedDate(LocalDate.of(2020, 1, 10));
				StudentService.updateStudent(student,1);
			}
			catch (IllegalArgumentException e){
				Assertions.assertEquals(e.getMessage(), StudentValidatorErrors.INVALID_DOB);
			}
		} 
}
