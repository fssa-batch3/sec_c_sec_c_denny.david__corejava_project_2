package com.fssa.studentmanagementapp.Validator;

import com.fssa.studentmanagementapp.Enum.Stu_Status;
import com.fssa.studentmanagementapp.model.StudentValidatorErrors;

public class StudentClassValidator {
    
	public static boolean ValidateId(int id) throws IllegalArgumentException{
		if(id<0) {
			throw new IllegalArgumentException();
		}
		return true;
	}
	
	public static boolean ValidateStudentId(int Studentid) throws IllegalArgumentException{
		if(Studentid<0) {
			throw new IllegalArgumentException();
		}
		return true;
	}
    
	public static boolean Standard(int standard) throws IllegalArgumentException{
		if (standard < 0) {
			throw new IllegalArgumentException(StudentValidatorErrors.INVALID_ID);
		}
		return true;
	}
    public static boolean validateStatus(Stu_Status status) {
    	if(status != Stu_Status.ACTIVE && status != Stu_Status.INACTIVE	) {
    	throw new IllegalArgumentException();
    	}
    	return true;
    }
}
