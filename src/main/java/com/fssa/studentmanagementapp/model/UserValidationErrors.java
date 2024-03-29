package com.fssa.studentmanagementapp.model;

public class UserValidationErrors {
	public static final String INVALID_USER = "User object can not null";
	/**
	 * Error message when the user first name is empty or null.
	 */
	public static final String INVALID_USER_FIRSTNAME_NULL = "User firstname cannot be empty or null";
	/**
	 * Error message when the user first name does not meet the length requirements.
	 */
	public static final String INVALID_USER_FIRSTNAME_NAME = "The firstname should be  minimum 2 letters and maximum 35 letters";
	/**
	 * Error message when the user last name is empty or null.
	 */
	

	public static final String INVALID_USER_EMAIL_NULL = "email cannot be empty or null";
	
	public static final String INVALID_USER_EMAIL_PATTERN = "Invalid email format";

	public static final String INVALID_USER_PASSWORD_NULL = "password cannot be empty or null";
	
	public static final String INVALID_USER_PASSWORD_PATTERN = "A valid password should meet the following criteria Have"
			+ " at least 8 characters Contain at least one lowercase letter Contain at least one uppercase letter "
			+ "Contain at least one digit Contain at least one special character";
	
	

	public static final String INVALID_MOBILE_NUMBER = "User Mobile Number  Contains only 10 numbers not more than that and it doesnt include any letters or speacial characters";


	
	


}