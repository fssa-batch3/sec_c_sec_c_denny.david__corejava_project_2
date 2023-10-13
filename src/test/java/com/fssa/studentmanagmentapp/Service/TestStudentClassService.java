package com.fssa.studentmanagmentapp.Service;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.studentmanagementapp.Service.StudentClassService;
import com.fssa.studentmanagementapp.model.StudentClass;
 
public class TestStudentClassService {
@Test
public void testreadStudentClass() throws SQLException {
	StudentClass stucl=new StudentClass();
	Assertions.assertTrue(StudentClassService.readStudentClass(stucl));
}

@Test
public void testGetClass() {
    // Assuming your getClass method returns true
    int result; 
	try {
		result = StudentClassService.getClass(10);
	} catch (SQLException e) {
		
		e.printStackTrace();
	} // Pass a sample class ID
    
    // Assert that the result is true
//    Assertions.assertTrue(result);
}
}
