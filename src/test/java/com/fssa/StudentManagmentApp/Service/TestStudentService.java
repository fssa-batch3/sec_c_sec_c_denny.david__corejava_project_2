package com.fssa.StudentManagmentApp.Service;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.StudentManagementApp.Service.StudentService;
import com.fssa.StudentManagementApp.dao.StudentDao;
import com.fssa.StudentManagementApp.model.Student;
import com.fssa.StudentManagementApp.model.StudentValidatorErrors;

//Testing service layer using testStudentService
public class TestStudentService {

	
	//Testing addStudent by sending datas
//    public void testAddStudent() throws SQLException{
//		Student student = new Student();
//		student.setId(0);
//	    student.setName("Pranaw");
//	    LocalDate dob = LocalDate.parse("2005-02-13");
//	    LocalDate createdDate = dob;
//	    student.setDob(dob);
//	    student.setEmailId("pranawmurugasen2004@gmail.com");
//	    student.setCreatedDate(createdDate);
//	    student.setGender("M");
//	    student.setPassword("pranaw@123");
//	    student.setMobileNo("7418646406");
//	    Assertions.assertTrue(StudentService.addStudent(student));
//   }
//    
//	@Test
//	//esting the method by giving invalid datas
//	public void testAddInvalidStudent() throws SQLException {
//		Student student1 = new Student();
//		student1.setName("");
//		student1.setGender("Male");
//		LocalDate dob = LocalDate.parse("2024-02-13");
//		student1.setDob(dob);
//		LocalDate createdDate = dob;
//		student1.setEmailId("joelpremkumar.gamil.com");
//		student1.setCreatedDate(createdDate);
//		student1.setId(-1);
//		student1.setMobileNo("9489161");
//		student1.setPassword("denny");
//		try {
//			StudentService.addStudent(student1);
//		} catch (IllegalArgumentException e) {
//			Assertions.assertEquals(e.getMessage(), StudentValidatorErrors.INVALID_NULL);
//		}
//	}
}
