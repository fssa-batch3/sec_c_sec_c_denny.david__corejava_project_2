package com.fssa.StudentManagmentApp.Service;

import java.security.Provider.Service;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.StudentManagementApp.dao.StudentDao;
import com.fssa.StudentManagementApp.model.Student;
import com.fssa.StudentManagementApp.model.StudentValidatorErrors;


public class TestStudentService {
	
	@Test
    public void testAddStudent() throws SQLException{
		Student student = new Student();
		student.setId(0);
	    student.setName("Denny");
	    LocalDate dob = LocalDate.parse("2004-02-13");
	    LocalDate createdDate = dob;
	    student.setDob(dob);
	    student.setEmailId("nareshVellingiri2004@gmail.com");
	    student.setCreatedDate(createdDate);
	    student.setGender("M");
	    student.setPassword("dennyfranklin@123");
	    student.setMobileNo("7418646406");
	    Assertions.assertTrue(Service.addStudent(student)); 
   }
	
	@Test
    public void testAddInvalidStudent()throws SQLException {
		  Student student = new Student();
		  student.setName("");
		  student.setGender("Male");
		  LocalDate dob = LocalDate.parse("2024-02-13");
		  student.setDob(dob);
		  LocalDate createdDate = dob;
		  student.setEmailId("joelpremkumar.gamil.com");
		  student.setCreatedDate(createdDate);
		  student.setId(-1);
		  student.setMobileNo("9489161");
		  student.setPassword("denny");
	  try {
		  StudentDao.addStudent(student); 
	  }
	  catch (IllegalArgumentException e){
		  Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_NULL);
	  }
	}
}
