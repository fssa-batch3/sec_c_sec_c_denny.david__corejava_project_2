package com.fsss.StudentManagementApp.Validator;


import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.StudentManagementApp.model.Student;
import com.fssa.StudentManagementApp.model.StudentValidatorErrors;


public class StudentValidator {
	public static boolean validateStudent(Student student) throws IllegalArgumentException{
		 if(student == null ) {
	    	  throw new IllegalArgumentException(StudentValidatorErrors.INVALID_NULL); 
	     }
		 return true;
		
	} 
	public static boolean validateName(String name)throws IllegalArgumentException {
		
		 
		if("".equals(name)|| name==null) {
			
			throw new IllegalArgumentException(StudentValidatorErrors.INVALID_NAME);
		}
		 String regex = "^[A-Za-z]+(?: [A-Za-z]+)*$";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher match =pattern.matcher(name);
		 boolean isMatch = match.matches();
		 if (isMatch) {
			 return true;
		 }
		 else { 
			 throw new IllegalArgumentException(StudentValidatorErrors.INVALID_NAME); 
		 }
		} 
	public static boolean validateId(int id) {
		if(id < 0) {
			throw new IllegalArgumentException(StudentValidatorErrors.INVALID_ID); 
		}
		return true;
	}
	public static boolean validateMobileNo(String mobileNo) {
		if(mobileNo == null || "".equals(mobileNo)) {
			throw new IllegalArgumentException(StudentValidatorErrors.INVALID_MOBILENO);
		}
		String mobRegex = "^[0-9]{10}$";
		Pattern mobPattern = Pattern.compile(mobRegex);
		Matcher mobmatches = mobPattern.matcher(mobileNo);
		boolean isMatch = mobmatches.matches();
		if(isMatch) {
			return true;
		}
		else {
			 throw new IllegalArgumentException(StudentValidatorErrors.INVALID_MOBILENO); 
		}
	}
	  
	public static boolean validatePassword(String password) {
		if(password == null || "".equals(password)) {
			throw new IllegalArgumentException(StudentValidatorErrors.INVALID_PASS);
		}
		String passRegex = "^[0-9]{10}$";
		Pattern passPattern = Pattern.compile(passRegex);
		Matcher passMatches = passPattern.matcher(password);
		boolean isMatch = passMatches.matches();
		if(isMatch) {
			return true;
		}
		else {
			throw new IllegalArgumentException(StudentValidatorErrors.INVALID_PASS);
		}
		
	}
	public static boolean validateDob(LocalDate dob) throws IllegalArgumentException {
		if(dob == null) {
			throw new IllegalArgumentException(StudentValidatorErrors.INVALID_DOB);
		}
		LocalDate currentDate = LocalDate.now();
		if(dob.isAfter(currentDate)) {
			throw new IllegalArgumentException(StudentValidatorErrors.INVALID_DOB);
		}
		else {
			return true;
		}
	}
	public static boolean  validateCreatedDate(LocalDate createdDate)throws IllegalArgumentException {
	   LocalDate currentDate = LocalDate.now();
	   if(createdDate.isAfter(currentDate) && createdDate!=(null)) {
		   throw new IllegalArgumentException(StudentValidatorErrors.INVALID_CREATEDDATE);
	   }
	   else {
		   return true;
	   }
	}
	
}
     
