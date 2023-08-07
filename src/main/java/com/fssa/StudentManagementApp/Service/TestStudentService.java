package com.fssa.StudentManagementApp.Service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import com.fssa.StudentManagementApp.model.Student;

public class TestStudentService {
    
    @Test
    public void testAddValidStudent() throws IllegalArgumentException, SQLException {
        Student student = new Student("John Doe", "johndoe@example.com");
        assertTrue(StudentService.addStudent(student));
    }

    @Test
    public void testAddInvalidStudent() throws IllegalArgumentException, SQLException {
        Student invalidStudent = new Student("", "invalid_email");
        assertFalse(StudentService.addStudent(invalidStudent));
    }
}

//public class StudentService {
//  public static  boolean addStudent(Student student) throws IllegalArgumentException, SQLException{
//	  if(StudentValidator.validateStudent(student)) {
//		  StudentDao.addStudent(student);
//	  }
//	  return false;
//  }   
//     public static boolean readStudent(Student student) throws IllegalArgumentException, SQLException {
//    	 StudentDao.readStudent();
//    	 return true; 
//     }
//     public static boolean updateStudent(Student student,int id) throws IllegalArgumentException, SQLException {
//    	 if(StudentValidator.validateStudent(student)) {
//    		 StudentDao.updateStudent(student, id);
//    	 }
//    	 return true;
//     }
//     public static boolean deleteStudent(int id)throws IllegalArgumentException, SQLException {
//    	 if(StudentValidator.validateId(id)) {
//    		 StudentDao.deleteStudent(id);
//    	 }
//    	 return true;
//     }
//     public static boolean findStudentbyName(String name) throws SQLException {
//    	 if(StudentValidator.validateName(name)) {
//    		 StudentDao.findStudentByName(name);
//    	 }
//    	 return true;
//     }
//}
