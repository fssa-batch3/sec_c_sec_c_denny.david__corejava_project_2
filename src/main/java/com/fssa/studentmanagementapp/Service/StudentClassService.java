package com.fssa.studentmanagementapp.Service;

import java.sql.SQLException;

import com.fssa.studentmanagementapp.dao.StudentClassDAO;
import com.fssa.studentmanagementapp.dao.StudentDao;
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.model.StudentClass;

public class StudentClassService {
	public static boolean readStudent_class(StudentClass student) throws SQLException {
		StudentClassDAO.readClass();
		return true;
	}
} 
