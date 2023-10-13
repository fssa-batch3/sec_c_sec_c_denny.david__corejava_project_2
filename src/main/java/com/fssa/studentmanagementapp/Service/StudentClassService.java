package com.fssa.studentmanagementapp.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fssa.studentmanagementapp.dao.StudentClassDAO;
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.model.StudentClass;

public class StudentClassService {
	public static boolean readStudentClass(StudentClass student) throws SQLException {
		StudentClassDAO.readClass();
		return true;
	}
	
	public static int getClass(int Class) throws SQLException {
		 StudentClassDAO.Class();
		 return 1;
	}
	
	public  boolean assignStudentToClass(String studentEmail, int classId) throws SQLException {
		
		
		return StudentClassDAO.assignStudentToClass( studentEmail, classId);
		
	}
	public  boolean updateStudentToClass(String studentEmail, int classId) throws SQLException {
		
		
		return StudentClassDAO.updateStudentToClass( studentEmail, classId);
		
	}
	public ArrayList<Student> getStudentsByClass(int classNum) throws SQLException{
		
		return StudentClassDAO.getStudentsByClass( classNum);
	}
	
} 
