package com.fssa.studentmanagmentapp.Validator;



import java.time.LocalDate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.studentmanagementapp.model.StudentValidatorErrors;
import com.fssa.studentmanagementapp.Validator.StudentValidator;

public class TestStudentManagmentAppValidator {
	@Test
  public void testStudentNull() { 
		try {
			StudentValidator.validateStudent(null);
		}
		catch(IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_NULL);
		}
		 
	}
	@Test
  public void testStudentValidator() {  
	  try {  
		 StudentValidator.validateName(" ");
	  }
	  catch(IllegalArgumentException e) {
		  Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_NAME);
	  }
	  
  }
	@Test
	  public void testStudentValidatorNull() {
		  try {
			 StudentValidator.validateName(null);
		  }
		  catch(IllegalArgumentException e) {
			  Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_NAME);
		  }
		  
	  }
	@Test
	  public void testStudentValidatorInvalid() {
		  try {
			 StudentValidator.validateName("12345");
		  }
		  catch(IllegalArgumentException e) {
			  Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_NAME);
		  }
		  
	  }
	@Test
	  public void testStudentValidatorvalid() {
		  Assertions.assertTrue(StudentValidator.validateName("Denny Franklin")) ;
	}
	@Test 
	public void testStudentInValidId() {
		try {
			StudentValidator.validateId(-1);
		}
		catch(IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_ID);
		}
	} 
	@Test 
	public void testStudentValidId() {
	
			 Assertions.assertTrue(StudentValidator.validateId(234));
	}
	@Test 
	public void testStudentInValidMoileNo() {
		try {
			StudentValidator.validateMobileNo("12345");
		}
		catch(IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_MOBILENO);
		}
	}
	@Test 
	public void testStudentPasswordEmpty() {
		try {
			StudentValidator.validatePassword("");
		}
		catch(IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_PASS);
		}
	}
	@Test 
	public void testStudentPasswordNumber() {
		try {
			StudentValidator.validatePassword("123");
		}
		catch(IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_PASS);
		}
	}
	

	@Test
	public void testStudentInValidateDob() {
		try {
			LocalDate check = LocalDate.parse("2024-12-12");
			StudentValidator.validateDob(check);
		}
		catch(IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_DOB);
		}
	}
	
	
	@Test
	public void testStudentInValidDob() {
		try {
//			LocalDate nullDate = null;
			StudentValidator.validateDob(null);
		}
		catch(IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_DOB);
		}
	}
	
	public void testStudentValidateDob() {
		LocalDate validDate = LocalDate.parse("2004-02-13");
		Assertions.assertTrue(StudentValidator.validateDob(validDate));
	}
    
	public void testStudentValidatorInvalidCreatedDAte() {
		try {
			LocalDate createdDate = LocalDate.parse("2024-12-12");
			StudentValidator.validateCreatedDate(createdDate);
		}
		catch (IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(),StudentValidatorErrors.INVALID_CREATEDDATE);
		}
	}
	public void testStudentValidateValidCreatedDate() {
		LocalDate validCreatedDate = LocalDate.parse("2004-02-13");
		Assertions.assertTrue(StudentValidator.validateCreatedDate(validCreatedDate));
	}

	
}
