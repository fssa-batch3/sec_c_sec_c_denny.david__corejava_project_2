package com.fssa.StudentManagementApp.Service;

import java.sql.SQLException;

import com.fssa.StudentManagementApp.dao.StudentDao;
import com.fssa.StudentManagementApp.model.Student;
import com.fsss.StudentManagementApp.Validator.StudentValidator;

public class StudentSerivce {
  public boolean addStudent(Student student) throws IllegalArgumentException, SQLException{
	  if(StudentValidator.validateStudent(student)) {
		  StudentDao.addStudent(student);
	  }
	  return false;
  }   
     public boolean readStudent(Student student) throws IllegalArgumentException, SQLException {
    	 StudentDao.readStudent();
    	 return true; 
     }
     public boolean updateStudent(Student student,int id) throws IllegalArgumentException, SQLException {
    	 if(StudentValidator.validateStudent(student)) {
    		 StudentDao.updateStudent(student, id);
    	 }
    	 return true;
     }
     public boolean deleteStudent(int id)throws IllegalArgumentException, SQLException {
    	 if(StudentValidator.validateId(id)) {
    		 StudentDao.deleteStudent(id);
    	 }
    	 return true;
     }
     public boolean findStudentbyName(String name) throws SQLException {
    	 if(StudentValidator.validateName(name)) {
    		 StudentDao.findStudentByName(name);
    	 }
    	 return true;
     }
}
