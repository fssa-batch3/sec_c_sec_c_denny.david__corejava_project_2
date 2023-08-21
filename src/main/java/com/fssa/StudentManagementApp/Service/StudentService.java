package com.fssa.StudentManagementApp.Service;

import java.sql.SQLException;

import com.fssa.StudentManagementApp.dao.StudentDao;
import com.fssa.StudentManagementApp.model.Student;
import com.fsss.StudentManagementApp.Validator.StudentValidator;

public class StudentService {
    
  
  public static  boolean addStudent(Student student) throws IllegalArgumentException, SQLException{
	  if(StudentValidator.validateStudent(student)) {
		 return StudentDao.addStudent(student);
	  }
	  return false;
  }   
     public static boolean readStudent(Student student) throws IllegalArgumentException, SQLException {
    	 StudentDao.readStudent();
    	 return true; 
     }
     public static boolean updateStudent(Student student,int id) throws IllegalArgumentException, SQLException {
    	 if(StudentValidator.validateStudent(student)) {
    		 StudentDao.updateStudent(student, id);
    	 }
    	 return true;
     } 
     public static boolean deleteStudent(int id)throws IllegalArgumentException, SQLException {
    	 if(StudentValidator.validateId(id)) {
    		  StudentDao.deleteStudent(id);
    	 }
    	 return true;
     }
     public static boolean findStudentbyName(String name) throws SQLException {
    	 if(StudentValidator.validateName(name)) {
    		 StudentDao.findStudentByName(name);
    	 }
    	 return true;
     }
}
