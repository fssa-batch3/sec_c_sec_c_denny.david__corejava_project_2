package com.fssa.StudentManagementApp.model;

//Errors 
public class StudentValidatorErrors {
   
	//Checking for nullity
   public  static final String INVALID_NULL = "Student should not be null";
   
   //Using this error to for nullity of the name 
   public static final String INVALID_NAME = "User Name should not be empty";
   
   public static final String INVALID_ID = "The id no should not be less than zero";
   
   public static final String INVALID_MOBILENO = "The mobile no should not be empty and it should be within 10 numbers";
   
   //Errors message for password
   public static final String INVALID_PASS = "The password should constain letters and special characters and numbers";
   //Errors msge for Dob
   public static final String INVALID_DOB = "The Date of birth should not be in the future";
   //Error message for creating Date 
   public static final String INVALID_CREATEDDATE = "The created date should not be after the current date";
   // Error msge for invalid email
   public static final String INVALID_EMAILID = "Don't give invalid emaildid";  
   //Error msge for gender
   public static final String INVALID_GENDER = "The gender should be in Male OR Female";
}
