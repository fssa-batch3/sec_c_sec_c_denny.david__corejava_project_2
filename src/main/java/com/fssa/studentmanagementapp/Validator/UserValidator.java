package com.fssa.studentmanagementapp.Validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.studentmanagementapp.exceptions.InvalidUserDetailException;
import com.fssa.studentmanagementapp.Enum.Gender;
import com.fssa.studentmanagementapp.model.StudentValidatorErrors;
import com.fssa.studentmanagementapp.model.User;
import com.fssa.studentmanagementapp.model.UserValidationErrors;

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserDetailException {

		if (user == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER);
		}
		validateUserName(user.getName());
		validateUserEmailId(user.getEmail());
		validateUserDob(user.getDob());
		validateuserPassword(user.getPassword());
		validateUserMobileNo(user.getMobileNo());
		validateuserGender(user.getGender());

		return true;
	}

	private static void validateuserGender(Gender gender) {
		// TODO Auto-generated method stub
		
	}

	private static boolean validateUserName(String firstname) throws InvalidUserDetailException {
		firstname = firstname.trim();

		if (firstname == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NULL);
		}

		if (firstname.isEmpty()) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		if (firstname.length() < 3) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		if (firstname.matches(".*\\d.*")) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		if (firstname.matches(".*[^a-zA-Z0-9].*")) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_FIRSTNAME_NAME);
		}

		return true;
	}



	public static boolean validateUserEmailId(String email) throws InvalidUserDetailException {
		String emailregex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailregex);
		Matcher matcher = pattern.matcher(email);
		Boolean isMatch = matcher.matches();
		if (!isMatch) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_EMAIL_PATTERN);
		}
		return true;


	}

	public static boolean validateuserPassword(String password) throws InvalidUserDetailException {
		if (password == null) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_NULL);
		}
		// At least one uppercase letter
		Pattern uppercasePattern = Pattern.compile(".*[A-Z].*");

		// At least one lowercase letter
		Pattern lowercasePattern = Pattern.compile(".*[a-z].*");

		// At least one digit
		Pattern digitPattern = Pattern.compile(".*[0-9].*");

		// At least one special character
		Pattern specialCharPattern = Pattern.compile(".*[!@#$%^&*()_+{}\\[\\]:;\"'<>,.?/~].*");

		// No whitespaces
		Pattern noWhitespacePattern = Pattern.compile("\\S*");

		// Match each pattern against the password
		boolean isUppercaseValid = uppercasePattern.matcher(password).matches();
		boolean isLowercaseValid = lowercasePattern.matcher(password).matches();
		boolean isDigitValid = digitPattern.matcher(password).matches();
		boolean isSpecialCharValid = specialCharPattern.matcher(password).matches();
		boolean isNoWhitespaceValid = noWhitespacePattern.matcher(password).matches();

		if (password.isEmpty()) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (password.length() < 8) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isDigitValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isSpecialCharValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isUppercaseValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isLowercaseValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		if (!isNoWhitespaceValid) {
			throw new InvalidUserDetailException(UserValidationErrors.INVALID_USER_PASSWORD_PATTERN);
		}

		return true;

	}
	public static boolean validateUserDob(LocalDate dob) throws IllegalArgumentException {
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
    
	 public static boolean validateUserMobileNo(String mobileNo) {
	        // Define a regular expression pattern for a 12-digit mobile number
	        String pattern = "\\d{12}";

	        // Use the matches method to check if the input matches the pattern
	        boolean isValid = mobileNo.matches(pattern);

	        return isValid;
	    }
	 
	 
	 public static boolean validateGender(Gender gender) throws IllegalArgumentException {
			if (gender != Gender.MALE && gender != Gender.FEMALE) {
	            throw new IllegalArgumentException("Invalid gender");
	        }
	       return true; 
	    }
	public static void main(String[] args) throws InvalidUserDetailException {
		System.out.println(UserValidator.validateUserEmailId("dennydavid@gmail.com"));
	}
}

