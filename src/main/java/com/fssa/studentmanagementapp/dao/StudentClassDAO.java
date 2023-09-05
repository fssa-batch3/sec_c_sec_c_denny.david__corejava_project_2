package com.fssa.studentmanagementapp.dao;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.fssa.studentmanagementapp.Enum.Gender;
import com.fssa.studentmanagementapp.Enum.Stu_Status;
import com.fssa.studentmanagementapp.model.Student;
import com.fssa.studentmanagementapp.model.StudentClass;
import com.fssa.studentmanagementapp.util.ConnectionUtil;
import com.sun.org.apache.xerces.internal.util.Status;

public class StudentClassDAO {
	//Reading the students in a classwise
   public static StudentClass readClass() throws SQLException {
	   try(Connection con =  ConnectionUtil.getConnection()){
		   String query = "SELECT * FROM student_class";
		   try(Statement st = con.createStatement()){
			   try (ResultSet rs = st.executeQuery(query)) {
				  while(rs.next()) {
					  StudentClass stu= new StudentClass();
					  stu.setId(rs.getInt(1));
						stu.setStudentId(rs.getInt(2));
						stu.setStandard(rs.getInt(3));
						Stu_Status status=Stu_Status.valueOf(rs.getString(4));
						stu.setStatus(status);
				      return stu;
				  } 
			   }
		   }
	   }
	return null;
   }
   
}
