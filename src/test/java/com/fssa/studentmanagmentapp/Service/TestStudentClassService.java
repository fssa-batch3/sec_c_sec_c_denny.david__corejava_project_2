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
	Assertions.assertTrue(StudentClassService.readStudent_class(stucl));
}
}
